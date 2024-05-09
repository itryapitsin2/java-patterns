package problems.easy.Palindrome;

public class Solution1 {
    public boolean isPalindrome(int x) {
        String temp = Integer.toString(x);
        for (int i = 0; i < temp.length() / 2; i++) {
            char rightValue = temp.charAt(i);
            char leftValue = temp.charAt(temp.length() - (i + 1));
            if (rightValue != leftValue) {
                return false;
            }
        }

        return true;
    }
}