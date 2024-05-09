package problems.easy.FindMaximumAchievableNumber;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: num = 4, t = 1 is " + solution1.theMaximumAchievableX(4, 1) + "\n");
        System.out.printf("Solution1: num = 3, t = 2 is " + solution1.theMaximumAchievableX(3, 2) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: num = 4, t = 1 is " + solution2.theMaximumAchievableX(4, 1) + "\n");
        System.out.printf("Solution2: num = 3, t = 2 is " + solution2.theMaximumAchievableX(3, 2) + "\n");
    }
}