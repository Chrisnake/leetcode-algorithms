package easy_leetcode;

public class merge_two_sorted_arrays {

    /**
     * Given two sorted arrays, merge them together, [1,2,5] [3,7,9]
     *  We can first compare 1 and 3 together - Since 1 is smaller we add that to the head of the linked list. -> 1
     *  Next we compare 2 with 3, since 2 is smaller we add that and append to the linked list. -> 1, 2
     *  Next we compare 5 with 3, since 3 is smaller we add that and append to the linked list. -> 1, 2, 3
     *  Next we compare 7 with 5, since 5 is smaller we add that and append to the linked list. -> 1, 2, 3, 5
     *  Next since we have no more to compare, just append the rest of the other list. -> 1, 2, 3, 5, 7, 9
     */

    public static void main(String[] args) {
        // Linked list one
        ListNode third = new ListNode(7, null);
        ListNode second = new ListNode(3, third);
        ListNode head = new ListNode(1, second);

        ListNode third2 = new ListNode(2, null);
        ListNode second2 = new ListNode(4, third2);
        ListNode head2 = new ListNode(5, second2);

        mergeTwoLists(head, head2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode prev = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        System.out.println(result.next);
        return result.next;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }
}
