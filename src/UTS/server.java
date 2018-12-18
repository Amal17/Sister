package UTS;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static final int SERVICE_PORT = 13;
    
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(SERVICE_PORT);
            System.out.println("SERVER READY");
            
            for (;;) {
                Socket clien = server.accept();
                
                BufferedReader inClient = new BufferedReader(new InputStreamReader(clien.getInputStream()));
////                DataOutputStream outClient = new DataOutputStream(clien.getOutputStream());
//                
                String messageClient = inClient.readLine();
                System.out.println("Dari Client : "+messageClient);
//                
//                outClient.writeBytes("Hallo");
                OutputStream out = clien.getOutputStream();
                PrintStream pout = new PrintStream(out);
                
                pout.print("Hallo Client");
                

                out.flush();
                out.close();
                                
                clien.close();
                
            }
        } catch (Exception e) {
            System.err.println("Error : "+e.getMessage());
        }
    }
}
