package Modul06;

public class ThreadUtamaRunnable {
    public static void main(String[] args) {
        Runnable runKirim = (Runnable) new KirimRunnable(1);
        Runnable runTerima = (Runnable) new TerimaRunnable(1);
        
        Thread TKirim = new Thread(runKirim);
        Thread TTerima = new Thread(runTerima);
        
        TKirim.start();
        TTerima.start();
    }
}
