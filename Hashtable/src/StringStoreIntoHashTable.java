import java.util.Arrays;

public class StringStoreIntoHashTable {
    private HashTable ht = null;

    public StringStoreIntoHashTable() {
        ht = new HashTable(131);
    }
//this method splits the input string based on common delimiters
    public String[] splitDelimiters(String s) {
        String delimiters = "[ ,.!?\n\t]";
        String[] res = s.split(delimiters);
        return res;
    }
    //This method sorts the characters in a string, which effectively turns a word into its anagram root.
    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
// It iterates through the array of words, sorts each word,
// checks if the sorted version is already in the hash table, and adds it if it's not.
    public void add(String[] line) {
        if(line == null || line.length == 0) {
            System.out.println("Nothing to read");
        }
        for(String s : line) {
            if(s.length() == 0) {
                continue;
            }
            String sortedString = sort(s);
            if(ht.exist(sortedString)) {
                continue;
            } else {
                ht.insert(sortedString);
            }
        }
    }
    //This method returns the total number of unique anagram roots in the hash table.
    public int getSize() {
        return ht.size();
    }

}
