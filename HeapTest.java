import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 20, 30, 40, 50, 100);
        HeapBuilder heapBuilder = new HeapBuilder();

        // Test Min-Heap
        Node minHeapRoot = heapBuilder.createMinHeap(list);
        System.out.println("Min-Heap:");
        printTree(minHeapRoot);
        System.out.println();

        // Reset values for Max-Heap test
        List<Integer> list2 = Arrays.asList(10, 15, 20, 30, 40, 50, 100);
        // Test Max-Heap
        Node maxHeapRoot = heapBuilder.createMaxHeap(list2);
        System.out.println("Max-Heap:");
        printTree(maxHeapRoot);
        System.out.println();

        //Test bst to heap transformer
        // Create a BST and insert nodes
        BSTTree bst = new BSTTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(2);
        bst.insert(8);
        bst.insert(15);
        bst.insert(25);

        BSTToHeapTransformer transformer = new BSTToHeapTransformer();
        //Test bst to min-heap
//        List<Node> list = transformer.bstToMinHeap(bst);
//        System.out.println("BST To Min - Heap: ");

        //Test bst to max-heap
        List<Node> list3 = transformer.bstToMaxHeap(bst);
        System.out.println("BST To Max - Heap: ");
        for(Node n : list3) {
            System.out.print(n.val + " ");
        }
    }

    // Helper method to print the binary tree (inorder traversal)
    public static void printTree(Node root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}
