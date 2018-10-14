package Modul06;

public class WaitingThreadDead extends Thread{
    public void run(){
        System.out.println("This thread feels a little ill..");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.err.println("Interrupted Exception "+e);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread dying = new WaitingThreadDead();
        dying.start();
        System.out.println("Waiting for thread death");
        dying.join();
        System.out.println("Thread has died");
    }
}
