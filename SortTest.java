import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        String[] strings = {"bucket","rat","mango","tango","ogtan","tar"};
        Sorting sort = new Sorting();
        List<List<String>> res = sort.groupAnagrams(strings);
        for(List<String> l : res) {
            System.out.println(l);;
        }
    }
}
