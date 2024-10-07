import java.util.*;

public class BSTTree {
    Node root;
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
        inorderInternal(list, root.left);
        list.add(root.val);
        inorderInternal(list, root.right);
    }

    public Node bstToMinHeap() {
        List<Integer> sortedList = inorder();
        Node root = new Node(sortedList.get(0));
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int idx = 1;
        while(!que.isEmpty() && idx < sortedList.size()) {
            Node tmp = que.poll();
            tmp.left = new Node(sortedList.get(idx++));
            if(idx >= sortedList.size()){
                break;
            }
            que.offer(tmp.left);
            tmp.right = new Node(sortedList.get(idx++));
            if(idx >= sortedList.size()){
                break;
            }
            que.offer(tmp.right);
        }
        return root;
    }
}
