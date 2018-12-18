package Modul04;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoClient {
    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 256;
    
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        String hostname = "localhost";
        InetAddress addr = InetAddress.getByName(hostname);
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(2000);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for(;;){
            System.out.println("Write your message here..");
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(bout);
            pout.print(reader.readLine());
            
            byte[] barray = bout.toByteArray();
            
            DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
            System.out.println("Sending packet to " + hostname);
            socket.send(packet);
            
            System.out.println("Waiting for packet...");
            
            byte[] recbuf = new byte[BUFSIZE];
            DatagramPacket receivePacket = new DatagramPacket(recbuf, BUFSIZE);
            
            boolean timeout = false;
            
            try{
                socket.receive(receivePacket);
            }catch(InterruptedIOException e){
                timeout = true;
            }
            
            if(!timeout){
                System.out.println("Packet Received!");
                System.out.println("Detail : " + receivePacket.getAddress());
                
                ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());
                
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(bin));
                System.out.println(reader2.readLine());
            }else{
                System.out.println("Packet Lost");
            }
        }
    }
}
