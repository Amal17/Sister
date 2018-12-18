package Modul06;

public class Terima extends Thread{
    int threadNumber;
    
    public Terima (int num){
        threadNumber = num;
    }

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
    
   
}
