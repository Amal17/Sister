package Modul04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {

    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 4096;
    private DatagramSocket socket;
    
    public EchoServer(){
        try{
            socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Server Active on port " + socket.getLocalPort());
        }catch (Exception e){
            System.err.println("Unable to bind port "+e);
        }
    }
    
    public void serviceClients(){
        byte[] buffer = new byte[BUFSIZE];
        for(;;){
            try{
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);
                socket.receive(packet);
                System.out.println("Packet received from "+packet.getAddress()+":"+packet.getPort()+" of length "+packet.getLength());
                socket.send(packet);
            }catch(IOException e){
                System.err.println("I/O Exception : "+e);
            }
        }
    }
    
    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.serviceClients();
    }
}
