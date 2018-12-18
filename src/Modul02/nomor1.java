package Modul02;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

/**
 *
 * @author Fadhil
 */
public class nomor1 {
    public static void main(String[] args) {
        String text = "";
        String path = "/home/alfa/NetBeansProjects/Sister/src/modul02/Tugas01.txt";
        try{
            InputStream fileInput = new FileInputStream ("/home/alfa/NetBeansProjects/Sister/src/modul02/soal03.txt");
            int data = fileInput.read();
            while (data != -1){
                text += ((char)data);
                data = fileInput.read();
            }
            fileInput.close();
            
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
