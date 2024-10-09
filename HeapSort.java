import java.util.Collections;

public class HeapSort {
    public void heapSort(char[] chars) {
        int len = chars.length;
        // Build the heap (heapify the array)
        int startSortIndex = len / 2 - 1;
        for(int i = startSortIndex; i >= 0; i--) {
            heapify(chars, len, i);
        }
        // Extract elements from heap one by one, this part from chatGPT
        for(int i = len - 1; i >= 0; i--) {
            // Move current root (largest element) to end
            char temp = chars[0];
            chars[0] = chars[i];
            chars[i] = temp;
            heapify(chars, i, 0);// Call heapify on the reduced heap
        }
    }

    public void heapify(char[] chars, int len, int index) {
        if(index >= len) {
            return;
        }
        int min = index;
        int left = min * 2 + 1;
        int right = min * 2 + 2;
        if(left < len && chars[min] > chars[left]) {
            min = left;
        }
        if(right < len && chars[min] > chars[right]) {
            min = right;
        }
        if(min != index) {
            char temp =  chars[index];
            chars[index] = chars[min];
            chars[min] = temp;
            heapify(chars, len, min);
        }
    }
}
