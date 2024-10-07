import java.util.Collections;
import java.util.List;
//https://www.geeksforgeeks.org/building-heap-from-array/
//from chatgpt
public class HeapBuilder {
    //return heap root node
    //The createMinHeap method takes a list of integers and rearranges it into a Min-Heap using the heapify process.
    public Node createMinHeap(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        int indexOfLastNonLeaf = size / 2 - 1;
        for (int i = indexOfLastNonLeaf; i >= 0; i--) {
            heapifyMin(list, size, i);
        }
        return buildBinaryTree(list, 0);
    }
//comparing each node with its left and right children and swapping if necessary.
    private void heapifyMin(List<Integer> list, int size, int index) {
        int min = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if(left < size && list.get(left) < list.get(min)) {
            min = left;
        }
        if(right < size && list.get(right) < list.get(min)) {
            min = right;
        }
        if(min != index) {
            //swaps elements at the specified positions in given list
            Collections.swap(list, index, min);
            heapifyMin(list, size, min);
        }
    }
// recursively builds a binary tree from the list, where the index of each node's children is calculated as 2 * index + 1 (left child) and 2 * index + 2 (right child).
// This function converts the array-based heap into a tree-based structure.
    public Node buildBinaryTree(List<Integer> list, int index) {
        if(index >= list.size()) {
            return null;
        }
        Node root = new Node(list.get(index));
        root.left = buildBinaryTree(list, index * 2 + 1);
        root.right = buildBinaryTree(list, index * 2 + 2);
        return root;
    }

    public Node createMaxHeap(List<Integer> list) {
        if(list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        int indexOfLastNonLeaf = size / 2 - 1;
        for(int i = indexOfLastNonLeaf; i >= 0; i--) {
            heapifyMax(list, size, i);
        }
        return buildBinaryTree(list, 0);

    }
    private void heapifyMax(List<Integer> list, int size, int index) {
        int max = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if(left < size && list.get(left) > list.get(max)) {
            max = left;
        }
        if(right < size && list.get(right) > list.get(max)) {
            max = right;
        }
        if(max != index) {
            Collections.swap(list, index, max);
            heapifyMax(list, size, max);
        }
    }
}
