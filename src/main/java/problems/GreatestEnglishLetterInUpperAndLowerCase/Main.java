package problems.GreatestEnglishLetterInUpperAndLowerCase;


public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: \"arRAzFif\" is " + solution1.greatestLetter("arRAzFif") + "\n");
        System.out.printf("Solution1: \"lEeTcOdE\" is " + solution1.greatestLetter("lEeTcOdE") + "\n");
        System.out.printf("Solution1: \"AbCdEfGhIjK\" is " + solution1.greatestLetter("AbCdEfGhIjK") + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: \"arRAzFif\" is " + solution2.greatestLetter("arRAzFif") + "\n");
        System.out.printf("Solution2: \"lEeTcOdE\" is " + solution2.greatestLetter("lEeTcOdE") + "\n");
        System.out.printf("Solution1: \"AbCdEfGhIjK\" is " + solution2.greatestLetter("AbCdEfGhIjK") + "\n");
    }
}