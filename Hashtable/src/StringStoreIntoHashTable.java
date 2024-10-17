package Hashtable.src;

import java.util.Arrays;

public class StringStoreIntoHashTable {
    private HashTable ht = null;

    public StringStoreIntoHashTable() {
        ht = new HashTable(131);
    }
    // Split the str into words using a regular expression that matches non-alphanumeric characters
    //splitDelimiters() from chatgpt
    public String[] splitDelimiters(String s) {
        String[] splitedString = s.split("[^a-zA-Z0-9]+");
        return splitedString;
    }
    // Sort the characters in a string to get the anagram root
    private String sort(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    // It iterates through the array of words, sorts each word,
    // checks if the sorted version is already in the hash table, and adds it if it's not.
    public void add(String[] splitedString) {
        if(splitedString == null || splitedString.length == 0) {
            return;
        }
        for(String s : splitedString) {
            if(s.length() == 0) {
                continue;
            }
            String sortedString = sort(s);
            if(!ht.exist(sortedString)) {
                ht.insert(sortedString);
            }
        }
    }
    //This method returns the total number of unique anagram roots in the hash table.
    public int getSize() {
        return ht.size();
    }

}
