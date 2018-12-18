package Modul06;

public class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("I am an instance of the java.lang.Runnable interface");
    }
    
    public static void main(String[] args) {
        System.out.println("Creating runnable object");
        
        Runnable run = (Runnable) new RunnableThread();
        
        System.out.println("Creating first thread");
        Thread t1 = new Thread(run);
        
        System.out.println("Creating second thread");
        Thread t2 = new Thread(run);
        
        System.out.println("Starting both threads");
        t1.start();
        t2.start();
    }
    
}
