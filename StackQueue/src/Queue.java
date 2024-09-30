import java.util.ArrayList;

public class Queue<Object> {
    private ArrayList<Object> list;
    int size = 0;
    public Queue(){
        list = new ArrayList<>();
    }
    public void enqueue(Object element) {
        if(element == null) {
            System.out.println("Object is null!");
            return;
        }
        list.add(element);
        size++;
        //System.out.println(element + " is added!");
    }

    public Object dequeue() {
        if(size == 0) {
            System.out.println("Queue is empty!");
            return null;
        }
        size--;
        return list.remove(0);
    }
    public Object poll() {
        if(size == 0) {
            System.out.println("Queue is empty!");
            return null;
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
