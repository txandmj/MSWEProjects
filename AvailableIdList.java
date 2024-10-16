public class AvailableIdList {
    IdNode head = null;
    IdNode tail = null; //point the new userId
    int size = 0;
    // the first free-up unique ID assign to the new user
    public int removeHead() {
        int removedId = head.id;
        head = head.next;
        size--;
        return removedId;
    }

    public void addId(int userId) {
        IdNode newUser = new IdNode(userId);
        if(head == null) {
            head = newUser;
        } else {
            tail.next = newUser;
        }
        tail = newUser; // Update the tail pointer
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
