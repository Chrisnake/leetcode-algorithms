package easy_leetcode;

import java.util.ArrayList;
import java.util.List;

public class reverse_linked_list {
    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     * // 1 -> 2 -> 3 -> 4 -> null
     * // 4 -> 3 -> 2 -> 1 -> null
     */
    public static void main(String[] args) {

        ListNode body2 = new ListNode(3);
        ListNode body1 = new ListNode(2, body2);
        ListNode head = new ListNode(1, body1);

        System.out.println(reverseList(head));
    }

    // 1 2 3
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while(current != null) {
            System.out.println("-------------------------------------------------------------------------------------");
            next = current.next; // save the next in the linked list
            System.out.println("next: " + next);
            current.next = prev; // reverse logic
            System.out.println("current.next: " + current.next);

            prev = current; // iterate previous
            System.out.println("prev: " + prev);
            current = next; // iterate curr
            System.out.println("current: " + current);

        }
        return prev; // this will be head at the end.
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }
}
