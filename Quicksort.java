//https://www.bilibili.com/video/BV1vP411g7J3/
/*
time complexity :O(nlogn)
in-place sorting: O(1)
 */
public class Quicksort {
    //This is the entry point for sorting the array
    public void quickSort(char[] chars) {
        sort(chars, 0, chars.length - 1);
    }
//This method performs the recursive quicksort algorithm by dividing the array into smaller subarrays and sorting each.
    public void sort(char[] chars, int low, int high) {
        if(low >= high) { //checks if the array (or subarray) has one or fewer elements
            return;
        }
        int pivotIndex = partition(chars, low, high);
        sort(chars, low, pivotIndex - 1);//sorts the left partition (elements smaller than the pivot).
        sort(chars, pivotIndex + 1, high);//sorts the right partition (elements larger than the pivot).
    }
    //rearrange the elements in such a way that elements smaller than the pivot are placed to its left, and elements larger are placed to its right.
    // The method returns the pivot's final position (index).
    public int partition(char[] chars, int low, int high) {
        char pivot = chars[low]; //he pivot is chosen as the first element (chars[low]) of the current subarray
        while(low < high) {
            while(low < high && chars[high] >= pivot) { //Right scan:finds an element smaller than the pivot.
                high--;
            }
            chars[low] = chars[high];
            while(low < high && chars[low] <= pivot) {//Left scan:finds an element greater than the pivot.
                low++;
            }
            chars[high] = chars[low];
        }
        chars[low] = pivot;//After the loop terminates, the pivot is placed in its correct position
        return low;
    }
}
