import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class BSTStudentTree {
    private TreeNode root = null;
    public TreeNode getRoot() {
        return root;
    }
    public void insert(TreeNode newStudent) {
        if(root == null) {
            root = newStudent;
        } else {
            TreeNode cur = root;
            insertIntoBST(cur, newStudent);
        }

    }
    private TreeNode insertIntoBST(TreeNode cur, TreeNode studentNode) {
        if(cur == null) {
            return studentNode;
        }
        if(studentNode.student.getName().compareToIgnoreCase(cur.student.getName()) < 0) {
            cur.left = insertIntoBST(cur.left, studentNode);
        } else if(studentNode.student.getName().compareToIgnoreCase(cur.student.getName()) > 0) {
            cur.right = insertIntoBST(cur.right, studentNode);
        }
        return cur;
    }

    public TreeNode delete(TreeNode student) {
        if(root == null) {
            return null;
        }
        TreeNode node = root;
        return deleteInternal(node, student);
    }
    public TreeNode deleteInternal (TreeNode node, TreeNode student) {
        if(node.student.equals(student.student)) {
            if(node.left == null) {
                return node.right;
            }
            if(node.right == null) {
                return node.left;
            }
            TreeNode cur = node.right;
            while(cur.left != null) {
                cur = cur.left;
            }
            cur.left = node.left;
            return  node.right;
        }
        if(student.student.getName().compareToIgnoreCase(root.student.getName()) < 0) {
            node.left = deleteInternal(node.left, student);
        } else if(student.student.getName().compareToIgnoreCase(root.student.getName()) > 0) {
            node.right = deleteInternal(node.right, student);
        }
        return node;
    }

    public String inorderTraversal() {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        inorderTraversalInternal(root, sb);
        return sb.toString();
    }

    private void inorderTraversalInternal(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        inorderTraversalInternal(root.left, sb);
        sb.append(root.student + "\n");
        inorderTraversalInternal(root.right, sb);
    }
    public String layersTravaersal() {
        StringBuilder sb = new StringBuilder();
        layersTraversalInternal(sb);
        return sb.toString();
    }
    public void layersTraversalInternal(StringBuilder sb) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode cur = root;
        que.offer(cur);
        while(!que.isEmpty()) {
            int size = que.size();
            while(size-- > 0) {
                TreeNode temp = que.poll();
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
            while((line=bufReader.readLine()) != null ) {
                bw.write(line + "\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
