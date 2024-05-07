package problems.ScoreOfString;


public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: \"hello\" is " + solution1.scoreOfString("hello") + "\n");
        System.out.printf("Solution1: \"zaz\" " + solution1.scoreOfString("zaz") + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: \"hello\" is " + solution2.scoreOfString("hello") + "\n");
        System.out.printf("Solution2: \"zaz\" " + solution2.scoreOfString("zaz") + "\n");

    }
}