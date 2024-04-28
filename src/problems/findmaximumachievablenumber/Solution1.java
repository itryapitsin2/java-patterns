package problems.findmaximumachievablenumber;

public class Solution1 {
    public int theMaximumAchievableX(int num, int t) {
        int x = t - 1;
        while (t >= 0) {
            num += 1;
            t -= 1;
        }
        return num + x;
    }
}
