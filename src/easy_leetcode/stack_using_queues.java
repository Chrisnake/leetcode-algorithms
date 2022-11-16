package easy_leetcode;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class stack_using_queues {

    /**
     * Implement a last-in-first-out (LIFO) stack using only two queues.
     * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
     * <p>
     * Implement the MyStack class:
     * void push(int x) Pushes element x to the top of the stack.
     * int pop() Removes the element on the top of the stack and returns it.
     * int top() Returns the element on the top of the stack.
     * boolean empty() Returns true if the stack is empty, false otherwise.
     * <p>
     * Notes:
     * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
     * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
     */

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }

    static class MyStack {

        Queue<Integer> mainQueue;

        public MyStack() {
            mainQueue = new LinkedList<>();
        }

        public void push(int x) {
            if(mainQueue.peek() != null) {
                List<Integer> reversedOrder = new ArrayList<>();
                while(mainQueue.peek() != null) {
                    reversedOrder.add(mainQueue.poll());
                }
                mainQueue.add(x); // add it to the end
                mainQueue.addAll(reversedOrder);
            } else {
                mainQueue.add(x);
            }
        }

        public int pop() {
            if(mainQueue.peek() == null) {
                return -1;
            }
            return mainQueue.poll();
        }

        public int top() {
            if(mainQueue.isEmpty()) {
                return -1;
            }
            return mainQueue.iterator().next();
        }

        public boolean empty() {
            return mainQueue.isEmpty();
        }

        @Override
        public String toString() {
            return "MyStack{" +
                "mainQueue=" + mainQueue +
                '}';
        }
    }

}
