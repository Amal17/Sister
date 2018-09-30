/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul04;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author User
 */
public class AplikasiClient {
    
    public static final int SERVICE_PORT=8;
    public static final int BUFSIZE=256;
    public static String nim, nama, asal, kelas;
    
    
    
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        AplikasiClient ac = new AplikasiClient();
        String hostname = "localhost";
        InetAddress addr= InetAddress.getByName(hostname);
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(2000);
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        for(;;){
            String message;
            System.out.println("Choose an action : \n"
                    + "1. Insert \n"
                    + "2. Update \n"
                    + "3. Delete \n"
                    + "4. Exit");
            String text=reader.readLine();
            if(text.equals("4")){
                message=text+"-a";
                System.exit(0);
            }else if(text.equals("1")){
                ac.modify();
                message=text+"-"+nim+"-"+nama+"-"+asal+"-"+kelas+"-";
            }else {
                System.out.print("Index data mahasiswa: ");
                BufferedReader bfedit = new BufferedReader(reader);
                int ind = Integer.parseInt(bfedit.readLine());
                if(text.equals("2"))
                {
                    ac.modify();
                    message=text+"-"+nim+"-"+nama+"-"+asal+"-"+kelas+"-"+ind+"-";
                }else
                {
                    message=text+"-"+ind+"-";
                }
            }
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(bout);
            pout.print(message);
            byte[] barray = bout.toByteArray();
            DatagramPacket packet = new DatagramPacket (barray, barray.length, addr, SERVICE_PORT);
            System.out.println("Sending packet to "+hostname);
            socket.send(packet);
            System.out.println("Waiting for response.....");
            byte[] recbuf= new byte[BUFSIZE];
            DatagramPacket receivePacket= new DatagramPacket(recbuf, BUFSIZE);
            boolean timeout = false;
            try {
                socket.receive(receivePacket);
            } catch(InterruptedIOException ioe) {
                timeout = true;
            }
            
            if (!timeout) {
                System.out.println("packet received!");
                System.out.println("Details : " + receivePacket.getAddress());
                
                ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData(),
                        0, receivePacket.getLength());
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(bin));
                System.out.println(reader2.readLine());
            } else {
                System.out.println("Packet lost!");
            }
        }
    }
    
    public void modify()
    {
        try {
            InputStream input = System.in;
            InputStreamReader reader = new InputStreamReader(input);
            
            System.out.print("Nim: ");
            BufferedReader bfNim = new BufferedReader(reader);
            this.nim = bfNim.readLine();
            System.out.print("Nama: ");
            BufferedReader bfNama = new BufferedReader(reader);
            this.nama = bfNama.readLine();
            System.out.print("Asal: ");
            BufferedReader bfAsal = new BufferedReader(reader);
            this.asal = bfAsal.readLine();
            System.out.print("Kelas: ");
            BufferedReader bfKelas = new BufferedReader(reader);
            this.kelas = bfKelas.readLine();
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
