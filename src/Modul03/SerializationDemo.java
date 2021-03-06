package Modul03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class SerializationDemo {
    public void serialize(List<Participant> pList, String fileName){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(pList);
        } catch (IOException e) {
            System.out.println("a problem accured during serialization \n"+e.getMessage());
        }
    }

    public List<Participant> deserialize (String fileName){
        List<Participant> pList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            pList = (List<Participant>) in.readObject();
        } catch (IOException e) {
            System.out.printf("A problem accured deserializing %s%n", fileName);
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.printf("A problem accured deserializing %s%n", fileName);
            System.out.println(e.getMessage());
        }
        return pList;
    }

}
