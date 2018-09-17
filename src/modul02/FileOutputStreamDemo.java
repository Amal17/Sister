package modul02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String destination = "/home/alfa/NetBeansProjects/Sister/src/modul02/writedocument.txt";
        OutputStream output = new FileOutputStream(destination);
        System.out.println("Opened "+destination+" for writing.");

        String data = "Coba tulis data dengan output stream";

        for (int i=0; i<data.length(); i++){
            output.write((byte)data.charAt(i));
        }

        output.close();
        System.out.println("Output Stream closed");
    }
}
