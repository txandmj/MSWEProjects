import java.util.*;


public class BSTToHeapTransformer {
    public List<Node> bstToMinHeap(BSTTree bst) { // Convert BST to Min-Heap
        //inorder traversal bst,return non-descending list;
        List<Integer> sortedList = bst.inorder();
        HeapBuilder builder = new HeapBuilder();
        //build minheap tree from non-descending list, return root;
        Node root = builder.buildBinaryTree(sortedList, 0);
        List<Node> res = new ArrayList<>(); //store result
        heapNode(res, root); //traversal minheap tree by level order
        return res;
    }

    public List<Node> bstToMaxHeap(BSTTree bst) {// Convert BST to Max-Heap
        List<Integer> sortedList = bst.inorder();
        Collections.reverse(sortedList);// Reverse to create Max-Heap
        HeapBuilder builder = new HeapBuilder();
        //build max - heap tree from non-ascending list, return root;
        Node root = builder.buildBinaryTree(sortedList, 0);
        List<Node> res = new ArrayList<>();
        heapNode(res, root);
        return res;
    }

    private void heapNode(List<Node> res, Node root) {
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            while(size-- > 0) {
                Node temp = que.poll();
                res.add(temp);
                if(temp.left != null) {
                    que.offer(temp.left);
                }
                if(temp.right != null) {
                    que.offer(temp.right);
                }
            }
        }
    }
}
