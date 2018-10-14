package Tugas06;

public class StoryThread extends Thread{
    
    int pasien= 10;
    int proses;
    
    public StoryThread(int proses){
        this.proses = proses;
    }
    
    public void run(){
        while(true){
            if(proses == 1){
                System.out.println(pasien+" sedang diperiksa dokter");
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                }
                break;
            }else if (proses == 2){
                int pas = pasien/2;
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                }
                System.out.println(pas+" sedang dirawat oleh perawat");
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                }
                System.out.println(pas+ " sedang dirawat oleh perawat");
                
                break;
            }else if(proses == 3 ){
                try {
                    sleep(10000);
                } catch (InterruptedException ex) {
                }
                System.out.println(pasien+" sedang membayar di kasir");
                
                break;
            }else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new StoryThread(1);
        t1.start();
        
        Thread t2 = new StoryThread(2);
        t2.start();
        
        Thread t3 = new StoryThread(3);
        t3.start();   
    }            
}
