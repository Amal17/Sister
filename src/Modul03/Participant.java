package Modul03;

import java.io.Serializable;

/**
 *
 * @author LAB_TI
 */
public class Participant implements Serializable{
    private String firsName;
    private String lastName;
    private int age;

    public Participant(String firsName, String lastName, int age){
        this.firsName = firsName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName(){
        return firsName;
    }

    public String getLastName(){
        return lastName;
    }

    public int  getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
    
    @Override
    public String toString(){
        return firsName+" "+lastName+" ("+age+")";
    }
}
