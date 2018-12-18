package Tugas06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread {
    public static final int SERVER_PORT = 13;
    String hostname = "localhost";
    Socket client1, client2, client3;
    BufferedReader buff ;
    
    public void run(){
        try {
            client1 = new Socket(hostname, SERVER_PORT);
            buff = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            System.out.println(buff.readLine());
            client1.close();
            sleep(2000);
            
            client2 = new Socket(hostname, SERVER_PORT);
            buff = new BufferedReader(new InputStreamReader(client2.getInputStream()));
            System.out.println(buff.readLine());
            client2.close();
            sleep(2000);
            
            client3 = new Socket(hostname, SERVER_PORT);
            buff = new BufferedReader(new InputStreamReader(client3.getInputStream()));
            System.out.println(buff.readLine());
            client3.close();
            sleep(2000);
        } catch (IOException | InterruptedException ex) {
        }
        
    }
    public static void main(String[] args) {
        Thread t1 = new ClientThread();
        t1.start();
    }
    
}
