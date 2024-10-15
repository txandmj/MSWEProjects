import java.util.ArrayList;

public class Queue<Object> {
    private ArrayList<Object> list;
    int size = 0;
    public Queue(){
        list = new ArrayList<>();
    }
    //It checks if the object is null before adding it to the queue.
    public void enqueue(Object element) {
        if(element == null) {
            System.out.println("Object cannot be null");
        }
        list.add(element);
        size++;
        //System.out.println(element + " is added!");
    }
    //It checks if the queue is empty before removing and return the top element
    public Object dequeue() {
        if(size == 0) {
            System.out.println("The queue is empty");
        }
        size--;
        return list.remove(0);
    }
    //It checks if the queue is empty before return the top element
    public Object poll() {
        if(size == 0) {
            System.out.println("The queue is empty");
        }
        return list.get(0);
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
