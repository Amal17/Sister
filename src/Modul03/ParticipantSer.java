package Modul03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author LAB_TI
 */
public class ParticipantSer implements Serializable{
    private String firstName;
    private String lastName;
    private int age;

    public ParticipantSer (String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void printData(){
        System.out.println("Nama\t: "+firstName+" "+lastName);
        System.out.println("Usia\t: "+age);
    }

    public void saveObject(ParticipantSer Obj){
        try {
            FileOutputStream fos = new FileOutputStream("data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Obj);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println("a ploblem accured during serialize.\n"+e);
        }
    }

    public void readObject(ParticipantSer Obj){
        try {
            FileInputStream fis = new FileInputStream("data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Obj = (ParticipantSer) ois.readObject();
            Obj.printData();
            fis.close();
        } catch (Exception e) {
            System.out.println("a ploblem accured during serialize.\n"+e);
        }
    }

    public static void main(String[] args) {
        ParticipantSer is = new ParticipantSer("Fadhil", "Amal", 20);
        is.saveObject(is);
        is.readObject(is);
    }
}
