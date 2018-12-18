package Modul03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class praktikum3 {
    public static void main(String[] args) throws IOException {
        List<Participant> participants = new ArrayList<Participant>();
        String firsName = "", lastName = "";
        int age = 0;

        try {
            System.out.print("Firs Name : ");
            InputStream input = System.in;

            InputStreamReader reader = new InputStreamReader(input);

            BufferedReader bufReader = new BufferedReader(reader);

            firsName = bufReader.readLine();

            System.out.print("Last Name : ");
            input = System.in;
            lastName = bufReader.readLine();

            System.out.print("Age : ");
            input = System.in;
            age = Integer.parseInt(bufReader.readLine());

        } catch (IOException ioe) {
            System.err.println("I/O error : "+ioe);
        }

        participants.add(new Participant(firsName, lastName, age));

        System.out.println("Participants : "+participants);

        SerializationDemo demo = new SerializationDemo();
        demo.serialize(participants, "Praktikum3Data.ser");
        System.out.println("serizlization is done");
        
        System.out.println("Deserialize object...");
        List<Participant> newList = demo.deserialize("Praktikum3Data.ser");
        System.out.println("New List: "+newList);
    }
}
