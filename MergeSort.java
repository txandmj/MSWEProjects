// https://www.jiuzhang.com/solution/merge-sort/
// time complexity: O(NlogN), space complexity: O(N)
public class MergeSort {
    public void mergeSort(char[] chars) {
        int len = chars.length;
        char[] temp = new char[len];
        sort(chars, 0, len, temp);
    }
    public void sort(char[] chars, int start, int end, char[] temp) {
        if(start + 1 >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        sort(chars, start, middle, temp);
        sort(chars, middle, end, temp);
        merge(chars, start, middle, end, temp);
    }

    public void merge(char[] chars, int start, int middle, int end, char[] temp) {
        int left = start;
        int right = middle;
        int index = start;
        while(left < middle && right < end) {
            if(chars[left] > chars[right]) {
                temp[index++] = chars[right++];
            } else {
                temp[index++] = chars[left++];
            }
        }
        while(left < middle) {
            temp[index++] = chars[left++];
        }
        while(right < end) {
            temp[index++] = chars[right++];
        }
        System.arraycopy(temp, start, chars, start, index - start);
    }
}
