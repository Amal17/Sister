package Modul01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class ping {
    public static void main(String[] args) {
        try {
            System.out.println("IP or Hostname");
            InputStream input = System.in;

            InputStreamReader reader = new InputStreamReader(input);

            BufferedReader bufReader = new BufferedReader(reader);
            String ip = bufReader.readLine();
            
            InetAddress ia = InetAddress.getByName(ip);
            System.out.println(ia);
            
            if (ia.isReachable(3000)){
                System.out.println(ia + " is Reachable");
            } else {
                System.out.println(ia + "is unReachable");
            }
            
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }
    }
            
}
