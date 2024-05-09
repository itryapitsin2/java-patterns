package problems.Palindrome;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: 121 is " + solution1.isPalindrome(121) + "\n");
        System.out.printf("Solution1: -121 " + solution1.isPalindrome(-121) + "\n");
        System.out.printf("Solution1: 10 " + solution1.isPalindrome(10) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: 121 is " + solution2.isPalindrome(121) + "\n");
        System.out.printf("Solution2: -121 " + solution2.isPalindrome(-121) + "\n");
        System.out.printf("Solution2: 10 " + solution2.isPalindrome(10) + "\n");
    }
}