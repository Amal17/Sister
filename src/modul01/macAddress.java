package modul01;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fadhil
 */
public class macAddress {
    public static String getMacAddress (String [] args) {
        try{
            Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
            
            while (networkInterface.hasMoreElements()){
                NetworkInterface nextElement = networkInterface.nextElement();
                byte [] mac = nextElement.getHardwareAddress();
                StringBuilder sb = new StringBuilder();
                if(mac != null){
                    for (int i=0; i<mac.length; i++){
                        sb.append(String.format("%02X%s", mac[i], (i<mac.length-1) ? "-" : ""));
                    }
                    return sb.toString();
                }
            }
            return Long.toHexString(System.currentTimeMillis());
        }catch (SocketException ex){
            return Long.toHexString(System.currentTimeMillis());
        }
    }
    public static void main(String[] args) throws SocketException {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Current IP Address is "+ip.getHostAddress());
            System.out.print("This PC MAC Address is ");
            NetworkInterface n = NetworkInterface.getByInetAddress(ip);
            System.out.println(getMacAddress(args));
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        }
    }
}
