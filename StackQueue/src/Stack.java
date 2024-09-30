import java.util.ArrayList;

public class Stack<Object> {
    private ArrayList<Object> list = null;
    private int size = 0;
    public Stack() {
        list = new ArrayList<>();
    }
    public void push(Object o) {
        if(o == null) {
            System.out.println("Object is null!");
            return;
        } else {
            list.add(o);
            size++;
            //System.out.println(o + " is added!");
        }
    }

    public Object pop() {
        if(size == 0) {
            System.out.println("Stack is empty!");
            return null;
        }
        Object temp = list.remove(size - 1);
        size--;
        return temp;
    }

    public Object peek() {
        if(size == 0) {
            System.out.println("Stack is empty!");
            return null;
        }
        return list.get(size - 1);
    }
    public int size() {
        return size;
    }
}
