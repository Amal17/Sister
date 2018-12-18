package Modul06;

import java.io.IOException;

public class SuspendingThread extends Thread{
    public void run(){
        int count = 1;
        System.out.println("I can count. Watch me go!");
        for(;;){
            System.out.print(count++ + " ");
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.err.println("InteruptedException "+e);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Thread counter = new SuspendingThread();
        counter.start();
        System.out.println("Press any enter to SUSPEND the thread counting");
        System.in.read();
   
        counter.suspend();
        System.out.println("Press any enter to RESUME the thread counting");
        System.in.read();
        counter.resume();
        System.out.println("Press any enter to STOP the thread counting");
        System.in.read();
        counter.stop();
    }
}
