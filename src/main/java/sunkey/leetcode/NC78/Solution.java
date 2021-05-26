package sunkey.leetcode.NC78;

public class Solution {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode head = node;
        for (int i = 2; i <= 20; i++) {
            ListNode cur = new ListNode(i);
            node.next = cur;
            node = cur;
        }
        print(head);
        System.out.println("============");
        ListNode reverse = ReverseList(head);
        print(reverse);
    }

    public static void print(ListNode node) {
        do {
            System.out.println(node.val);
            node = node.next;
        } while (node != null);
    }

    /**
     * T C
     * 1 2 3 4 5
     * <p>
     * T   C
     * 2 1 3 4 5
     * <p>
     * T     C
     * 3 2 1 4 5
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode top = head;
        ListNode current = head.next;
        head.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = top;
            top = current;
            current = next;
        }
        return top;
    }

}