import java.util.*;

public class Sorting {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            MergeSort sort = new MergeSort();
            sort.mergeSort(chars);
            String sortedKey = new String(chars);
            List<String> list = map.getOrDefault(sortedKey, new ArrayList<>());
            list.add(s);
            map.put(sortedKey, list);
        }
        for(List<String> l : map.values()) {
            res.add(l);
        }
        return res;
    }

}
