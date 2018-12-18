package Modul06;

public class ThreadUtama {
    public static void main(String[] args) {
        Thread kirim = new Kirim(40);
        Thread terima = new Terima(40);
        
        kirim.start();
        terima.start();
    }
}
