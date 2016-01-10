/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Bancho
 */
public class Producer implements Runnable {
    
    private ArrayBlockingQueue s1;
    private ArrayBlockingQueue s2;
    
    public Producer(ArrayBlockingQueue s1, ArrayBlockingQueue s2){
        this.s1 = s1;
        this.s2 = s2;
    }
    
    private long fib(long n){
        if ((n == 0) || (n == 1)) {
            return n;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }

    @Override
    public void run() {
        while(true){
            try{
                long n = (long) s1.poll();
                s2.put(fib(n));
            }catch(NullPointerException e){
                return;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                //ignore (don't know if correct thing to do)
            }
        }
    }
}
