import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable {
    int tableSize = 0;
    private ArrayList<LinkedList<String>> list = null;
    private int count = 0;//number of entries in the map
    private int prime; //prime for MAD compression
    private int scale;//scale from 1 to p-1 for MAD
    private int shift;//shift from 0 to p-1 for MAD
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

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
    //The MAD method ensures that the hash codes are uniformly distributed across the hash table
    public int getBucketIndex(String s) {//textbook
        int hashCode = s.hashCode(); //java build-in method
        return (Math.abs(hashCode * scale + shift) % prime) % tableSize;// Ensure non-negative index
    }

    public void insert(String s) {
        if(s == null) {
            System.out.println("The string is null");
            return;
        }

        if((double) count / tableSize > LOAD_FACTOR_THRESHOLD) {
            resizeTable();
        }

        int index = getBucketIndex(s);
        LinkedList<String> node = list.get(index);
        node.add(s);// Insert the string into the correct bucket
        count++;
    }
    //resizeTable() from chatgpt
    // Resize if load factor exceeds threshold
    // Resize the hash table to reduce collisions
    private void resizeTable() {
        int newSize = tableSize * 2;
        ArrayList<LinkedList<String>> newList = new ArrayList<>(newSize);
        // Initialize newlist of linked lists
        for(int i = 0; i < newSize; i++) {
            newList.add(new LinkedList<>());
        }
        // Rehash all existing entries into the newlist
        for(LinkedList<String> bucket : list) {
            for(String s : bucket) {
                int newIndex = (Math.abs(s.hashCode() * scale + shift) % prime) % newSize;
                newList.get(newIndex).add(s);
            }
        }
        this.list = newList;
        this.tableSize = newSize;
    }
    //Simply returns the number of elements (strings) stored in the hash table
    public int size() {
        return count;
    }
    // checks if a given string already exists in the table by
    // computing the bucket index and searching through the linked list.
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
