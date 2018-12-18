package Modul07;

/**
 *
 * @author root
 */
public class Counter {
    private int countValue;
    
    public Counter(){
        countValue = 0;
    }
    
    public Counter(int start){
        countValue = start;
    }
    
    public synchronized void increaseCount(){
        int count = countValue;
        
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.err.println("Inerupted Exception : "+e);
        }
        count = count + 1;
        countValue = count;
    }
    
    public synchronized int getCount(){
        return countValue;
    }
}
