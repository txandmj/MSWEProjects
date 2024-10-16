package StackQueue.src;

import java.util.ArrayList;
// it implements a stack by using an arraylist
public class Stack<Object> {
    private ArrayList<Object> list = null;
    private int size = 0;

    public Stack() {
        list = new ArrayList<>();
    }
    //Adds an element (o) to the top of the stack
    //It checks if the object is null before adding it to the stack.
    public void push(Object o) {
        if(o == null) {
            System.out.println("Object is null");
            return;
        } else {
            list.add(o);
            size++;
            //System.out.println(o + " is added!");
        }
    }
    //Removes and returns the top element of the stack
    //It checks if the stack is empty before removing and return the top element
    public Object pop() {
        if(size == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        Object temp = list.remove(size - 1);
        size--;
        return temp;
    }
    //It checks if the stack is empty before return the top element
    public Object peek(){
        if(size == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        return list.get(size - 1);
    }
    public int size() {
        return size;
    }
}
