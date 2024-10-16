import java.util.*;


public class BSTToHeapTransformer {
    public Node bstToMinHeap(BSTTree bst) { // Convert BST to Min-Heap
        //inorder traversal bst,return non-descending list;
        List<Integer> sortedList = bst.inorder();
        HeapBuilder builder = new HeapBuilder();
        //build minheap tree from non-descending list, return root;
        Node root = builder.buildBinaryTree(sortedList, 0);
        return root;
    }

    public Node bstToMaxHeap(BSTTree bst) {// Convert BST to Max-Heap
        List<Integer> sortedList = bst.inorder();
        Collections.reverse(sortedList);// Reverse to create Max-Heap
        HeapBuilder builder = new HeapBuilder();
        //build max - heap tree from non-ascending list, return root;
        Node root = builder.buildBinaryTree(sortedList, 0);
        return root;
    }
}
