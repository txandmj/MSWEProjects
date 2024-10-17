package StudentTree.src;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class BSTStudentTree {
    private TreeNode root = null;
    public TreeNode getRoot() {
        return root;
    }
    //properly insert a new student into the tree
    public void insert(TreeNode newStudent) {
        if(root == null) {//new node becomes the root
            root = newStudent;
        } else { //calls a helper function
            TreeNode cur = root;
            insertIntoBST(cur, newStudent);
        }
    }
    // This recursive method inserts the student in its correct location.
    private TreeNode insertIntoBST(TreeNode cur, TreeNode studentNode) {
        if(cur == null) {
            return studentNode;
        }
        //If the student's name is lexicographically smaller, the method recurses on the left subtree.
        if(studentNode.student.getName().compareToIgnoreCase(cur.student.getName()) < 0) {
            cur.left = insertIntoBST(cur.left, studentNode);
        }
        //If the student's name is lexicographically larger, the method recurses on the right subtree.
        else if(studentNode.student.getName().compareToIgnoreCase(cur.student.getName()) > 0) {
            cur.right = insertIntoBST(cur.right, studentNode);
        }
        return cur;
    }
    //Deletes a student from the tree.
    public TreeNode delete(TreeNode student) {
        if(root == null) {
            return null;
        }
        TreeNode cur = root;
        return deleteInternal(cur, student);
    }
    // Recursively deletes the node with the matching student.
    public TreeNode deleteInternal (TreeNode node, TreeNode student) {
        if(node.student.equals(student.student)) {
            if(node.left == null) {
                return node.right;
            }
            if(node.right == null) {
                return node.left;
            }
            //assign the left subtree of the node being deleted to the left of the successor
            // because the left subtree contains smaller values.
            TreeNode cur = node.right;
            while(cur.left != null) {
                cur = cur.left;
            }
            cur.left = node.left;
            return  node.right;
        }
        //If the student’s name is smaller, it recurses on the left subtree
        if(student.student.getName().compareToIgnoreCase(root.student.getName()) < 0) {
            node.left = deleteInternal(node.left, student);
        }
        //If the student’s name is larger, it recurses on the right subtree.
        else if(student.student.getName().compareToIgnoreCase(root.student.getName()) > 0) {
            node.right = deleteInternal(node.right, student);
        }
        return node;
    }
    //Traverses the tree in-order (left-root-right) and returns a string of all students.
    public String inorderTraversal() {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        inorderTraversalInternal(root, sb);
        return sb.toString();
    }
    //Recursively traverses the tree:
    private void inorderTraversalInternal(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        inorderTraversalInternal(root.left, sb);
        sb.append(root.student + "\n");
        inorderTraversalInternal(root.right, sb);
    }
    //Traverses the tree layer by layer (breadth-first search) and appends the student information to a StringBuilder.
    public String levelOrderTravaersal() {
        StringBuilder sb = new StringBuilder();
        levelOrderTraversalInternal(sb);
        return sb.toString();
    }
    private void levelOrderTraversalInternal(StringBuilder sb) {
        if(root == null) {
            return;
        }
        //Uses a queue to traverse each layer (level) of the tree.
        //Initialize a queue to help with level-order traversal
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode cur = root;// Start with the root node
        que.offer(cur);
        while(!que.isEmpty()) {
            int size = que.size();// Get the current number of nodes at this level.
            while(size-- > 0) {// Process all nodes at the current level.
                TreeNode temp = que.poll();// Remove a node from the queue.
                sb.append(temp.student + "\n");
                if(temp.left != null) {
                    que.offer(temp.left);
                }
                if(temp.right != null) {
                    que.offer(temp.right);
                }
            }
        }
    }
    //From https://stackoverflow.com/questions/9259411/what-is-the-best-way-to-iterate-over-the-lines-of-a-java-string
    public void writeIntoFile(String content, String path) {
        BufferedReader bufReader = new BufferedReader(new StringReader(content));
        String line = null;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            while((line = bufReader.readLine()) != null ) {
                bw.write(line + "\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
