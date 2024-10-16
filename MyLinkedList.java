public class MyLinkedList {
    private int size = 0;
    private ListNode head = null;
    // Return the size of the linked list
    public int getSize(){
        return size;
    }
    // Return the head of the list
    public ListNode getHead() {
        return head;
    }
    //get user in linked list by userId
    public User get(int userId) {
        ListNode cur = head;
        while(cur != null) {
            if(cur.getUser().getId() == userId) {
                return cur.getUser();
            }
            cur = cur.getNext();
        }
        return null;// User not found
    }
    // Add a new node for the user in sorted order
    public void addNode(User user) {
        ListNode prevNode = null;
        ListNode curNode = head;
        // Traverse until we find the right position for the new node
        while(curNode != null && curNode.getUser().getId() < user.getId()) {
            prevNode = curNode;
            curNode = curNode.getNext();
        }
        // Insert at the head if it's the smallest or the list is empty
        if(prevNode == null) {
            head = new ListNode(user, head);
        } else {
            ListNode newNode = new ListNode(user, curNode);
            prevNode.setNext(newNode);
        }
        size++;
    }
    //Delete a user node by userId
    public boolean deleteNode(int userId) {
        //The dummyHead node is helpful for simplifying edge cases (like removing the head node).
        ListNode dummyHead = new ListNode(null, head);
        ListNode cur = dummyHead;
        while(cur != null && cur.getNext() != null) {
            int nextId = cur.getNext().getUser().getId();
            if(nextId == userId) {
                cur.setNext(cur.getNext().getNext());
                size--;
                return true;
            } else {
                cur = cur.getNext();
            }
        }
        return false; // User not found
    }
}
