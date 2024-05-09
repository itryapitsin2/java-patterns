package problems.easy.ScoreOfString;

public class Solution1 {
    public int scoreOfString(String s) {
        int sum = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            int chr = (int) s.charAt(i);
            int chrNext = (int) s.charAt(i + 1);

            int distance = chr - chrNext;
            if (distance < 0) {
                distance *= -1;
            }

            sum += distance;
        }

        return sum;
    }
}