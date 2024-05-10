package problems.medium.InsertGreatestCommonDivisorsInLinkedList;

/**
 * Stupid and slow solution
 */
public class Solution2 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        while (current != null && current.next != null) {
            int gcd = gcd(current.val, current.next.val);
            if (gcd >= 1) {
                ListNode newNode = new ListNode(gcd);
                newNode.next = current.next;
                current.next = newNode;
                current = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public int gcd(int a, int b) {
        int c = b;
        long start = System.nanoTime();
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        long end = System.nanoTime();
        System.out.println("a=" + a + " b=" + c + " :" + (end - start));
        return a;
    }
}
