package Modul01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class scan {
    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("Localhost: " + localhost);
        
        byte[] ip = localhost.getAddress();
        
        for (int i = 1; i<=254; i++){
            ip[3] = (byte) i;
            InetAddress address = InetAddress.getByAddress(ip);
            
            if (address.isReachable(3000)){
                System.out.println(address+" - Reachable");
            } else {
                System.out.println(address+" - unReachable");
            }
        }
    }
}
