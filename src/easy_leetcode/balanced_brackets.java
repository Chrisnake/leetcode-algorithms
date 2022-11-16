package easy_leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class balanced_brackets {

    // check if a string has balanced brackets, first with () and then with []{}<>
    // Can use a stack for this, first in last out.
    // If its an entry character aka (, {, [, < in stack doesn't exist, push to stack -> if this does exist already pop from stack.
    // If the stack is empty then that means there is no imbalance.

    public static void main(String[] args) {
        System.out.println(balancedBrackets("()"));
        System.out.println(balancedBrackets("{}()"));
        System.out.println(balancedBrackets("{(}()"));
        System.out.println(balancedBrackets("([)]"));
    }

    public static boolean balancedBrackets(String string) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < string.length(); i++) {
            char thisChar = string.charAt(i);
            if(thisChar == '{' || thisChar == '(' || thisChar == '[') {
                stack.push(thisChar);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    switch (thisChar) {
                        case '}':
                            if(stack.peek() != '{') {
                               return false;
                            } else {
                                stack.pop();
                            }
                            break;
                        case ')':
                            if(stack.peek() != '(') {
                                return false;
                            } else {
                                stack.pop();
                            }
                            break;
                        case ']':
                            if(stack.peek() != '[') {
                                return false;
                            } else {
                                stack.pop();
                            }
                            break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
