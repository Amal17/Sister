package Modul06;

public class TerimaRunnable implements Runnable{
    int threadNumber;
    
    public TerimaRunnable (int num){
        threadNumber = num;
    }
    
    @Override
    public void run(){
        try{
        for (int i=0; i<20; i++){
            if (threadNumber % 2 == 0){
                System.out.print(threadNumber + " ");
            }
            threadNumber++;
            Thread.sleep(500);
        }
        }catch(InterruptedException ex){
            System.err.println(threadNumber + " is Finished!");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Creating runnable object");
        
        Runnable run = (Runnable) new TerimaRunnable(1);
        
        Thread t1 = new Thread(run);
        
        t1.start();
    }
    
}
