package modul02;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class soal03 {
    public static void main(String[] args) {
        try{
            System.out.println("input Your Text : ");

            InputStream input = System.in;

            InputStreamReader reader = new InputStreamReader(input);

            BufferedReader bufReader = new BufferedReader(reader);
            String text = bufReader.readLine();

            String destination = "/home/alfa/NetBeansProjects/Sister/src/modul02/soal03.txt";
            OutputStream output = new FileOutputStream(destination);
            System.out.println("Opened "+destination+" for writing.");

            for (int i=0; i<text.length(); i++){
                output.write((byte)text.charAt(i));
            }

            output.close();
            System.out.println("Output Stream closed");
        }catch(IOException ioe){
            System.err.println("I/O error : "+ioe);
        }
    }
}
