public class QueueTest {
    public static void main(String args[]) {
        Queue<Object> que = new Queue<>();
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);
        que.enqueue(5);
        System.out.println("The size of que is " + que.size());
        System.out.println(que.dequeue());
        System.out.println(que.poll());
        System.out.println("The size of que is " + que.size());
        StackWithTwoQs s2q = new StackWithTwoQs();
        s2q.push(6);
        s2q.push(7);
        s2q.push(8);
        s2q.push(9);
        s2q.push(10);
        System.out.println(s2q.size());
        System.out.println(s2q.pop());
        System.out.println(s2q.size());
        System.out.println(s2q.peek());
        System.out.println(s2q.size());
    }


}
