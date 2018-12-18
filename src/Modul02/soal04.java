package Modul02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class soal04 {
    private static String name;
    public static void main(String[] args) throws IOException {
        System.out.println("Masukkan Text. Ketik 'exit' untuk keluar");
        while(true){

            try{
                InputStream input = System.in;

                InputStreamReader reader = new InputStreamReader(input);

                BufferedReader bufReader = new BufferedReader(reader);
                String text = bufReader.readLine();

                if(text.equals("exit")){
                    System.out.println("Anda mengetik : "+text);
                    System.out.println("Terima Kasih");
                    System.exit(0);
                }else{
                    System.out.println("Anda mengetik : ");
                    System.out.println(text);
                }

            }catch(IOException ioe){
                System.err.println("I/O error : "+ioe);
            }
        }
    }
}
