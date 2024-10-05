import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashTest {
    public static void main(String[] args) throws IOException {
        String path = "C:\\code\\MSWEProjects\\pride-and-prejudice.txt";
        StringStoreIntoHashTable ht = new StringStoreIntoHashTable();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(path));
            String line = null;
            while((line = br.readLine()) != null) {
                String[] splitWords = ht.splitDelimiters(line);
                ht.add(splitWords);
            }
            // After processing the entire file, print the number of unique anagram roots
            System.out.println("Unique anagram roots: " + ht.getSize());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            br.close();
        }
    }
}
