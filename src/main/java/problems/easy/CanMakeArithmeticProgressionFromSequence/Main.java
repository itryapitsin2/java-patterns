package problems.easy.CanMakeArithmeticProgressionFromSequence;


import java.util.Stack;

public class Main {
    public static int parseString(String str) {
        int result = 0;
        int multiple = 1;
        boolean hasMultiply = false;
        Stack<Integer> stack = new Stack<>();

        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(Character.isLetter(c)) {
                result = 0;
                stack.clear();
                break;
            }

            if (c == '.') {
                break;
            }

            if (c == '-') {
                if (hasMultiply) {
                    result = 0;
                    stack.clear();
                    break;
                }
                multiple = -1;
                hasMultiply = true;
                continue;
            }

            if (c == '+') {
                if (hasMultiply) {
                    result = 0;
                    stack.clear();
                    break;
                }
                multiple = 1;
                hasMultiply = true;
                continue;
            }

            int v = Character.getNumericValue(c);

            if (v >= 0 && v <= 9) {
                stack.push(v);
            }
        }

        for(int i = stack.size() - 1; i >= 0; i--) {
            result += stack.get(i) * Math.pow(10, stack.size() - i - 1);
        }

        if (multiple > 0) {
            return result + 1 >= Integer.MAX_VALUE
                    ? Integer.MAX_VALUE
                    : result;
        } else {
            result *= -1;
            return result - 1 <= Integer.MIN_VALUE
                    ? Integer.MIN_VALUE
                    : result;
        }
    }

    public static int myAtoi(String s) {
        String[] strings = s.split("\\s");
        for(String str: strings) {
            if (str.length() == 0) {
                continue;
            }

            int result = parseString(str);
            return result;
        }

        return 0;

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: [3,5,1] is " + solution1.canMakeArithmeticProgression(new int [] {3,5,1}) + "\n");
        System.out.printf("Solution1: [1,2,4] is " + solution1.canMakeArithmeticProgression(new int [] {1,2,4}) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: [3,5,1] is " + solution2.canMakeArithmeticProgression(new int [] {3,5,1}) + "\n");
        System.out.printf("Solution2: [1,2,4] is " + solution2.canMakeArithmeticProgression(new int [] {1,2,4}) + "\n");

        int r = myAtoi("010");
    }
}