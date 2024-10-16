import java.util.*;

public class BSTTree {
    Node root;
    //inserts the node at the correct position based on BST properties (left for smaller values, right for larger).
    public void insert(int val) {
        root = insertInternal(root, val);
    }
    private Node insertInternal(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }
        if(root.val > val) {
            root.left = insertInternal(root.left, val);
        } else if(root. val < val) {
            root.right = insertInternal(root.right, val);
        }
        return root;
    }
//Performs an in-order traversal (left-root-right) of the tree
// and returns a sorted list of node values.
    public List<Integer> inorder() {
        if(root == null) {
            return null;
        }
        List<Integer> sortedList = new ArrayList<>();
        inorderInternal(sortedList, root);
        return sortedList;
    }
    private void inorderInternal(List<Integer> list, Node root) {
        if(root == null) {
            return;
        }
        //This recursive method visits the left subtree,
        // adds the current node value, and then visits the right subtree.
        inorderInternal(list, root.left);
        list.add(root.val);
        inorderInternal(list, root.right);
    }
}
