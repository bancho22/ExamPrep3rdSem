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
public class Consumer implements Runnable{

    private ArrayBlockingQueue s2;
    private long sum;

    public Consumer(ArrayBlockingQueue s2){
        this.s2 = s2;
        sum = 0;
    }

    public long getSum(){
        return sum;
    }

    @Override
    public void run() {
        while(true){
            try {
                long n = (long) s2.take();
                System.out.println(n);
                sum += n;
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}
