package Modul07;

import java.io.IOException;

/**
 *
 * @author root
 */
public class WaitNotify extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Thread notificationThread = new WaitNotify();
        notificationThread.start();
        
        synchronized (notificationThread){
            notificationThread.wait();
        }
        
        System.out.println("The wait is over");
    }
    
    public void run(){
        System.out.println("Hit Enter to stop waiting thread");
        try {
            System.in.read();
        } catch (IOException e) {
            System.err.println("IO Exception : "+e);
        }
        
        synchronized(this){
            this.notifyAll();
        }
    }
}
