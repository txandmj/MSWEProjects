package StackQueue.src;

import StackQueue.src.StackCalculator;

public class StackTest {
    public static void main(String[] args) {
        //test code for stack class
//        Stack stack = new Stack();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.push("hello");
//        stack.push('w');
//        stack.push(11.33333);
//        stack.push(null);
//        System.out.println("The size is " + stack.size());
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println("The size is " + stack.size());

        //test code for calculator
        try{
            StackCalculator sc = new StackCalculator();
//            int res = sc.calculator("10 + 20 * 2 - 3 + 6 / 2");
//            System.out.println(res);
            //System.out.println(sc.calculator("10+foo"));
            System.out.println(sc.calculator("10+++20"));
            //System.out.println(sc.calculator("10+20 20"));
            System.out.println(sc.calculator("10+20+"));

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
