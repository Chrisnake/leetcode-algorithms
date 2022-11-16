package easy_leetcode;

public class remove_linked_list_elements {

    /**
     * Given the head of a linked list and an integer val, remove all the nodes of the linked list
     * that has Node.val == val, and return the new head.
     * <p>
     * Input: head = [1,2,6,3,4,5,6], val = 6
     * Output: [1,2,3,4,5]
     */

    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        //traverse(head, val, 0);
        return null;
    }

    public static ListNode traverse(ListNode head, ListNode original, int val, int current) {
        while(head.next != null) {
            if(head.val == val) {
                ListNode headCopy = head;
                int i = 0;
                while(i != current){
                   // headCopy.
                }
            } else {
               // ListNode node = traverse(head.next, val, current++);
            }
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
