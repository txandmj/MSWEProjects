package StackQueue.src;

import StackQueue.src.Queue;
// the class implements a stack using two queues
public class StackWithTwoQs {
    private Queue<Object> que1;// This queue (que1) holds the elements as the main data storage
    private Queue<Object> que2;//temp que used to help rearrange the elements during the push operation.
    private int size = 0;

    public StackWithTwoQs() {
        que1 = new Queue<>();
        que2 = new Queue<>();
    }
    //To add an element to the stack in a Last-In-First-Out (LIFO) manner
    public void push(Object o) {
        while (!que1.isEmpty()) {
            //making space for the new element at the front of the queue.
            que2.enqueue(que1.dequeue());
        }
        que1.enqueue(o);
        size++;
        //Move elements back to que1, que1 maintains the stack order,where the newly added element is always at the front (ready to be popped first).
        while (!que2.isEmpty()) {
            que1.enqueue(que2.dequeue());
        }
    }
    //Removes and returns the top element of the stack
    //due to the push logic, que1 always has the stack's top element at the front
    public Object pop() {
        Object temp = que1.dequeue();
        size--;
        return temp;
    }
    //Returns the top element of the stack without removing it.
    public Object peek() {
        return que1.poll();
    }
    public int size() {
        return size;
    }
}
