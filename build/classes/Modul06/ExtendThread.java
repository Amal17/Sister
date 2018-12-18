package Modul06;

public class ExtendThread extends Thread{
    int threadNumber;
    
    public ExtendThread(int num){
        threadNumber = num;
    }
    
    public void run(){
        System.out.println("I'm thread number: "+threadNumber);
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            System.err.println(threadNumber + " is Finished!");
        }
        System.out.println(threadNumber + " is Finished!");
    }
    
    public static void main(String[] args) {
        System.out.println("Creating thread 1");
        Thread t1 = new ExtendThread(1);
        
        System.out.println("Creating threat 2");
        Thread t2 = new ExtendThread(2);
        
        t1.start();
        t2.start();
    }
}
