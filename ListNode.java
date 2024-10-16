public class ListNode {
    private User user;
    private ListNode next;

    public ListNode(User user, ListNode next) {
        this.user = user;
        this.next = next;
    }
    public User getUser() {
        return user;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
}
