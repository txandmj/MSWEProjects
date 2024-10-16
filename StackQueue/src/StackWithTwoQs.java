package StackQueue.src;

import StackQueue.src.Queue;

public class StackWithTwoQs {
    private Queue<Object> que1;//in-out
    private Queue<Object> que2;//temp que
    private int size = 0;

    public StackWithTwoQs() {
        que1 = new Queue<>();
        que2 = new Queue<>();
    }
    public void push(Object o) {
        while (!que1.isEmpty()) {
            que2.enqueue(que1.dequeue());
        }
        que1.enqueue(o);
        size++;
        while (!que2.isEmpty()) {
            que1.enqueue(que2.dequeue());
        }
    }
    public Object pop() {
        Object temp = que1.dequeue();
        size--;
        return temp;
    }
    public Object peek() {
        return que1.poll();
    }
    public int size() {
        return size;
    }

}
