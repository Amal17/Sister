package Tugas06;

public class ArrayThread extends Thread{

    int [] a = {6, 9, 1, 2, 3, 5};
    int [] b = {7, 11, 6, 4, 3, 1};
    int [] c = {5, 4, 3, 2, 1, 12};
    
    static int [] Hasil = new int[6];
    static int total;
    int i;
    
    public ArrayThread(int i){
        this.i = i;
    }
    
    
    public void run(){
        Hasil[i] = a[i] + b[i] + c[i];
        System.out.println("Thread "+i+" : "+a[i]+" + "+b[i]+" + "+c[i]+" = "+Hasil[i]);
    }
    
    static int total(){
        System.out.print("Isi hasil :");
        for(int i=0 ; i<Hasil.length; i++){
            System.out.print(Hasil[i]+" ");
            total += Hasil[i];
        }
        return total;
    }
        
    public static void main(String[] args) {
        
        Thread t1 = new ArrayThread(0);
        Thread t2 = new ArrayThread(1);
        Thread t3 = new ArrayThread(2);
        Thread t4 = new ArrayThread(3);
        Thread t5 = new ArrayThread(4);
        Thread t6 = new ArrayThread(5);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
     
        System.out.println("Total : "+total());
    }    
}
