import java.util.Arrays;

public class Permutation {
    public boolean checkInclusion(String s1, String s2) {
        int lenS1 = s1.length(), lenS2 = s2.length();
        if (lenS1 > lenS2) {
            return false;
        }
        if (s1 == null || lenS1 == 0) {
            return true;
        }

        char[] charsS1 = s1.toCharArray();
        quickSort(charsS1, 0, charsS1.length - 1);
        String sortedS1 = new String(charsS1);

        char[] charsS2 = s2.toCharArray();
        for (int i = 0; i < lenS2 - lenS1 + 1; i++) {
            char[] temp = Arrays.copyOfRange(charsS2, i, i + lenS1 - 1);
            quickSort(temp, 0, temp.length - 1);
            String sortedSubstring = new String(temp);
            if (sortedSubstring.equals(sortedS1)) {
                return true;
            }
        }
        return false;
    }

    //This method performs the recursive quicksort algorithm by dividing the array into smaller subarrays and sorting each.
    public void quickSort(char[] chars, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(chars, start, end);
        quickSort(chars, start, pivotIndex - 1);
        quickSort(chars, pivotIndex + 1, end);
    }

    //rearrange the elements in such a way that elements smaller than the pivot are placed to its left, and elements larger are placed to its right.
    // The method returns the pivot's final position (index).
    public int partition(char[] chars, int low, int high) {
        char pivot = chars[low];
        while (low < high) {

            while (low < high && chars[high] > pivot) {
                high--;
            }
            chars[low] = chars[high];
            while (low < high && chars[low] < pivot) {
                low++;
            }
            chars[high] = chars[low];
        }
        chars[low] = pivot;
        return low;
    }
}
