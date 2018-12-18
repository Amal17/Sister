package UTS;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class client {  
    public static final int SERVICE_PORT = 13;
    public static void main(String[] args) {
        try {
            String hostname = "localhost";
            
            Socket clien = new Socket(hostname, SERVICE_PORT);
            System.out.println("Connection established");
            
            clien.setSoTimeout(2000);
            
//            BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));
//            DataOutputStream outServer = new DataOutputStream(clien.getOutputStream());
//            
            BufferedReader reader = new BufferedReader(new InputStreamReader(clien.getInputStream()));
            
//            String message = inUser.readLine();
//            outServer.writeBytes("Hallo Server");

OutputStream out = clien.getOutputStream();
                PrintStream pout = new PrintStream(out);
                
                pout.print("Hallo Server");
                

                out.flush();
                out.close();
                            
            String ServerMessage = reader.readLine();
            System.out.println("FROM SERVER: " + ServerMessage);

            clien.close();
        } catch (IOException e) {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
}
