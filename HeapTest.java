import java.util.ArrayList;
import java.util.List;

public class HeapTest {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(10);
        values.add(20);
        values.add(15);
        values.add(30);
        values.add(40);
        values.add(50);

        HeapBuilder heapBuilder = new HeapBuilder();

        // Test Min-Heap
        Node minHeapRoot = heapBuilder.createMinHeap(values);
        System.out.println("Min-Heap:");
        printTree(minHeapRoot);
        System.out.println();

        // Reset values for Max-Heap test
        values.clear();
        values.add(10);
        values.add(20);
        values.add(15);
        values.add(30);
        values.add(40);
        values.add(50);

        // Test Max-Heap
        Node maxHeapRoot = heapBuilder.createMaxHeap(values);
        System.out.println("Max-Heap:");
        printTree(maxHeapRoot);
    }

    // Helper method to print the binary tree (inorder traversal)
    public static void printTree(Node root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}
