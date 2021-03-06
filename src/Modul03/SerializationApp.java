package Modul03;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class SerializationApp {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<Participant>();
        participants.add(new Participant("Dee", "Aja", 21));
        participants.add(new Participant("Ami", "Fahmi", 21));
        participants.add(new Participant("Haya", "Hayati", 20));
        participants.add(new Participant("Aya", "Hayati", 19));

        System.out.println("Participants : "+participants);

        SerializationDemo demo = new SerializationDemo();
        demo.serialize(participants, "participantData.ser");
        System.out.println("serizlization is done");
        
        System.out.println("Deserialize object...");
        List<Participant> newList = demo.deserialize("participantData.ser");
        System.out.println("New List: "+newList);
    }
}
