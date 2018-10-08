package Modul05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeClient {
    public static final int SERVICE_PORT = 13;
    
    public static void main(String[] args) throws IOException {
        try{
            String hostname = "localhost";
            
            Socket daytime = new Socket(hostname, SERVICE_PORT);
            System.out.println("Connection established");
            
            daytime.setSoTimeout(2000);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            System.out.println("Result : "+reader.readLine());
            
            daytime.close();
        }catch(IOException e){
            System.err.println("I/O Exception : "+e);
        }
    }
}
