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
public class Main {
    
    public static final int NUM_OF_PROD_THREADS = 4;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Long> s1 = new ArrayBlockingQueue<Long>(1024);
        long[] values = {4, 5, 8, 12, 21, 22, 34, 35, 36, 37, 42};
        for (long value : values) {
            s1.add(value);
        }
        
        ArrayBlockingQueue<Long> s2 = new ArrayBlockingQueue<Long>(1024);
        
        Thread[] prodThrs = new Thread[NUM_OF_PROD_THREADS];
        
        for (int i = 0; i < NUM_OF_PROD_THREADS; i++) {
            Producer p = new Producer(s1, s2);
            Thread t = new Thread(p);
            prodThrs[i] = t;
        }
        
        for (int i = 0; i < NUM_OF_PROD_THREADS; i++) {
            prodThrs[i].start();
        }
        
        Consumer c1 = new Consumer(s2);
        Thread consThr = new Thread(c1);
        consThr.start();
        
        for (int i = 0; i < NUM_OF_PROD_THREADS; i++) {
            prodThrs[i].join();
        }
        System.out.println("sum: " + c1.getSum());
        consThr.interrupt();
    }

}
