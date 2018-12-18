package Tugas06;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
    public static final int SERVICE_PORT = 13;
    String hostname = "localhost";
    
    public void run(){
        try {
            ServerSocket server = new ServerSocket(SERVICE_PORT);
            for(int i = 1;; i++){
                Socket terimaclient = server.accept();
                System.out.println("Client ke "+i+" terhubung dari port "+terimaclient.getPort());
                OutputStream out = terimaclient.getOutputStream();
                String balasan = "Anda Adalah client ke-"+i;
                PrintStream pout= new PrintStream(out);
                pout.print(balasan);
                out.flush();
                out.close();
                terimaclient.close();
                
            }
        } catch (IOException ex) {
        }
        
    }
    public static void main(String[] args) {
        Thread t1 = new ServerThread();
        t1.start();        
    }
}
