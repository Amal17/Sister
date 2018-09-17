package modul01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHostDemo {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Looking up local host");
        InetAddress localAddress = InetAddress.getLocalHost();
        System.out.println("Name : " + localAddress.getHostName());
        System.out.println("IP Address : " + localAddress.getHostAddress());
        System.out.println(localAddress);
    }
}
