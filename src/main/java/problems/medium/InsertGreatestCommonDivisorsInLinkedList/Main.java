package problems.medium.InsertGreatestCommonDivisorsInLinkedList;


public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        ListNode n4 = getListNode();
        ListNode result1 = solution1.insertGreatestCommonDivisors(n4);
        System.out.print("Solution1: \n");
        print(result1);

        System.out.println();

        Solution2 solution2 = new Solution2();
        ListNode n5 = getListNode();
        ListNode result2 = solution2.insertGreatestCommonDivisors(n5);
        System.out.print("Solution2: \n");
        print(result2);
    }

    private static ListNode getListNode() {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(10, n1);
        ListNode n3 = new ListNode(6, n2);
        return new ListNode(18, n3);
    }

    private static void print(ListNode result1) {
        ListNode pointer1 = result1;
        while(pointer1.next != null) {
            System.out.print(pointer1.val + " ");
            pointer1 = pointer1.next;
        }
    }
}