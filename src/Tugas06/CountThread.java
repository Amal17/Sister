package Tugas06;

import java.io.IOException;

public class CountThread extends Thread{
    int count;
    public static boolean kondisi = true;
    
    public void run(){
        count=0;
        for (;;){
            if(kondisi){
                count++;
                if(count % 2 == 0){
                    System.out.print(count+" ");
                }
            }else {
                count--;
                if(count % 2 != 0){
                    System.out.print(count+" ");
                }
            }
            try{
                sleep(500);
            }catch(InterruptedException ie){
            
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Thread t1 = new CountThread();
        t1.start();
        System.out.println("Berhitung Maju Genap. ___Coba Enter");
        System.in.read();
//        t1.suspend();
//        System.out.println("Press enter to resume ");
//        System.in.read();
//        t1.resume();
        kondisi = false;
        System.out.println("Berhitung Mundur Ganjil. ___Enter Sekali Lagi");
        System.in.read();
        t1.stop();
    }
}
