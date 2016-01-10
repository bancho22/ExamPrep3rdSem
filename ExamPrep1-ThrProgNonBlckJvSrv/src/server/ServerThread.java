/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.Socket;


/**
 *
 * @author Bancho
 */
public class ServerThread extends Thread {
    
    private StadiumServer server;
    private Socket socket;
    private ClientRole role;

    public ServerThread(StadiumServer server) {
        this.server = server;
    }

    public void setServSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        role = server.identifyClient(socket);
        if (role != null) {
            server.handleClient(socket, role);
        }
    }
    
}
