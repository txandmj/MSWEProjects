import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable {
    int tableSize = 0;
    private ArrayList<LinkedList<String>> list = null;
    private int count = 0;//numberofentries inthemap
    private int prime; //primeforMADcompression
    private int scale;//scale from 1 to p-1 for MAD
    private int shift;//shift from 0 to p-1 for MAD
    public HashTable(int tableSize) {
        this.tableSize = tableSize;
        list = new ArrayList<>(tableSize);
        for(int i = 0; i < tableSize; i++) {
            list.add(new LinkedList<>());
        }
        prime = 109345121;
        scale = (int) (Math.random() * (prime - 1) + 1);
        shift = (int) (Math.random() * prime);
    }
    //from textbook: MAD compression function
    public int getBucketIndex(String s) {//textbook
        int hashCode = s.hashCode(); //java build-in method
        return (Math.abs(hashCode * scale + shift) % prime) % tableSize;// Ensure non-negative index
    }

    public void insert(String s) {
        if(s == null) {
            System.out.println("The string is null");
            return;
        }
        // Check if the string already exists before inserting (to avoid duplicates)
        if(!exist(s)) {
            int index = getBucketIndex(s);
            LinkedList<String> node = list.get(index);
            node.add(s);// Insert the string into the correct bucket
            count++;
        }

    }

    public int size() {
        return count;
    }
    public boolean exist(String s) {
        int index = getBucketIndex(s);
        LinkedList<String> node = list.get(index);
        for(String str : node) {
            if(str.equals(s)) {
                return true;// If the string is found, return true
            }
        }
        return false;
    }
}
