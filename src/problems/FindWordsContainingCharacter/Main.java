package problems.FindWordsContainingCharacter;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: words = [\"leet\",\"code\"], n = 'e' is " + Arrays.toString(solution1.findWordsContaining(new String[]{"leet", "code"}, 'e').toArray()) + "\n");
        System.out.printf("Solution1: words = [\"abc\",\"bcd\",\"aaaa\",\"cbc\"], x = 'a' is " + Arrays.toString(solution1.findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a').toArray()) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: words = [\"leet\",\"code\"], n = 'e' is " + Arrays.toString(solution2.findWordsContaining(new String[]{"leet", "code"}, 'e').toArray()) + "\n");
        System.out.printf("Solution2: words = [\"abc\",\"bcd\",\"aaaa\",\"cbc\"], x = 'a' is " + Arrays.toString(solution1.findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a').toArray()) + "\n");
    }
}