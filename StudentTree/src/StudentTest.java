package StudentTree.src;

import java.io.*;
public class StudentTest {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = null;
        try{
            //Task-1: Build a Binary Search Tree (BST) using the data
            String path = ("C:\\code\\MSWEProjects\\tree-input.txt");
            br = new BufferedReader(new FileReader(path));
            BSTStudentTree studentTree = new BSTStudentTree();
            String line = "";
            while((line = br.readLine()) != null) {
                String operation = line.substring(0, 1);
                Student student = extractStudentInfo(line);
                TreeNode studentNode = new TreeNode(student);
                if("I".equals(operation)) {
                    studentTree.insert(studentNode);
                } else if("D".equals(operation)) {
                    studentTree.delete(studentNode);
                }
            }
            //Task-2: Traverse the binary search tree recursively,Print the node data to a text file
            String context = studentTree.inorderTraversal();
            String inorderTraversalPath = "C:\\code\\MSWEProjects\\inorderTraversal.txt";
            studentTree.writeIntoFile(context, inorderTraversalPath);
            //Task-3: Traverse the binary search tree level-by-level. Print the node data to a text file
            String contextLevelOrder = studentTree.levelOrderTravaersal();
            String layerTraversalPath = "C:\\code\\MSWEProjects\\levelOrderTraversal.txt";
            studentTree.writeIntoFile(contextLevelOrder, layerTraversalPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // Read the input file and process each record. From chatgpt
    private static Student extractStudentInfo(String line) {
        String number = line.substring(1, 8).trim();
        String lastName = line.substring(8,33).trim();
        String home = line.substring(33,37).trim();
        String program = line.substring(37, 41).trim();
        String year = line.substring(41, 42);
        return new Student(number, lastName, home, program, year);

    }
}
