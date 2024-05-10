package problems.medium.InsertGreatestCommonDivisorsInLinkedList;

/**
 * Stupid and slow solution
 */
public class Solution1 {

    private int findGreatestCommonDivisor(int a, int b) {
        int top = Math.min(a, b);
        int max = top;

        long start = System.nanoTime();
        for (int i = top; i >= 1; i--) {
            max = i;
            if ((a % i == 0) && (b % i == 0)) {
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("a=" + a + " b=" + b + " :" + (end - start));

        return max;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode pointer = head;
        while (pointer.next != null) {
             int val = pointer.val;
             int nextVal = pointer.next.val;

             int greatestCommonDivisor = findGreatestCommonDivisor(val, nextVal);
            ListNode tmp = pointer;
            tmp.next = new ListNode(greatestCommonDivisor, tmp.next);
            pointer = tmp.next.next;
        }

        return head;
    }
}
