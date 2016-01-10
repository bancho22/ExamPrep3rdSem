/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bancho
 */
public class StadiumServer {

    /**
     * @param args the command line arguments
     */
    
    public static final String IP = "localhost";
    public static final int PORT = 8080;

    public ServerSocket servSocket;
    
    private AtomicInteger connectedClientsATM;
    private AtomicInteger connectionsMade;
    private AtomicInteger counter;
    private ArrayList<Integer> c;

    
    private void startServer() throws IOException {
        connectedClientsATM = new AtomicInteger(0);
        connectionsMade = new AtomicInteger(0);
        counter = new AtomicInteger(0);
        c = new ArrayList<Integer>();
        
        servSocket = new ServerSocket();
        servSocket.bind(new InetSocketAddress(IP, PORT));
        System.out.println("Server started: " + new Date());
        while (true) {
            Socket socket = servSocket.accept(); //Blocks call until a client connects
            startNewThread(socket);
        }
    }
    
    public ClientRole identifyClient(Socket s){
        try {
            Scanner sc = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            String msg = sc.nextLine(); //Blocks call until it gets a msg
            switch(msg){
                case "##TURNSTILE##":
                    pw.println("You have been registered as a turnstile.");
                    return ClientRole.TURNSTILE;
                case "##MONITOR##":
                    pw.println("You have been registered as a monitor.");
                    return ClientRole.MONITOR;
                default:
                    pw.println("Invalid protocol. Failed to identify yourself.");
                    s.close();
                    connectedClientsATM.decrementAndGet();
                    return null;
            }
        } catch (Exception ex) {
            connectedClientsATM.decrementAndGet();
            return null;
        }
    }

    public void handleClient(Socket s, ClientRole role) {
        try {
            Scanner sc = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            boolean doRun = true;
            do {
                String msg = sc.nextLine(); //Blocks call until it gets a msg
                switch(msg){
                    case "incrementCount":
                        switch(role){
                            case TURNSTILE:
                                counter.incrementAndGet();
                                pw.println("Number of spectators successfully incremented. Current value: " + counter.get());
                                break;
                            case MONITOR:
                                pw.println("You are not allowed to access this method.");
                                break;
                        }
                        break;
                    case "getCount":
                        switch(role){
                            case TURNSTILE:
                                pw.println("You are not allowed to access this method.");
                                break;
                            case MONITOR:
                                pw.println("Current number of spectators: " + counter.get());
                                break;
                        }
                        break;
                    case "##STOP##":
                        s.close();
                        connectedClientsATM.decrementAndGet();
                        doRun = false;
                        break;
                    default:
                        pw.println("Ivalid protocol. Try again.");
                        break;
                }
            } while (doRun);
        } catch (Exception ex) {
            connectedClientsATM.decrementAndGet();
        }
    }

    private void startNewThread(Socket s) {
        ServerThread t = new ServerThread(this);
        t.setServSocket(s);
        t.start();
        connectedClientsATM.incrementAndGet();
        connectionsMade.incrementAndGet();
        c.add(connectedClientsATM.get());
    }

    public static void main(String[] args) {
        try {
            new StadiumServer().startServer();
        } catch (IOException ex) {
            Logger.getLogger(StadiumServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
