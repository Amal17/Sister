package modul03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serialization {
    public void serialize(List<DataMahasiswa> pList, String fileName){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(pList);
        }catch(IOException e){
            System.out.println("A problem accured during serialization \n"+e.getMessage());
        }
    }
    
    public List<DataMahasiswa> deserialize(String fileName){
        List<DataMahasiswa> pList = null;
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            pList = (List<DataMahasiswa>) in.readObject();
        }catch(IOException e){
            System.out.printf("A Problem accured during deserializing %s%n", fileName);
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Class Not Found during deserializing "+e.getMessage()); 
        }
        return pList;
    }
    
}
