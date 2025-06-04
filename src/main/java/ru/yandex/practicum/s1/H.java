package ru.yandex.practicum.s1;

public class H {
    private static int[] addTwoNumbers(int[] input) {
        int[] output = new int[3];

        if ((input[0] == 1 && input[1] == 1) || (input[0] == 0 && input[1] == 0)) {
            output[1] = 1;
        } else {
            output[0] = 1;
        }

        if (input[2] == 1 && output[1] == 1) {
            output[2] = 1;
            output[1] = 0;
        } else {
            output[1] = 1;
        }

        return output;
    }
    /**
     * `a` has longer length than `b`
     */
    private static String s(String a, String b) {
        int acc = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            int a1 = Character.getNumericValue(a.charAt(i));
            int b1 = i < b.length() ? Character.getNumericValue(b.charAt(i)) : 0;

            if (a1 == 1 && b1 == 1) {
                acc = 1;
                result.append(0);
            } else {
                result.append(1);
            }
        }

        return result.toString();
    }
    private static String sumOfBinaries(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        return a.length() > b.length() ? s(a, b) : s(b, a);
    }
    public static void main(String[] args) {
        var result = addTwoNumbers(new int[] { 1,1,0});
        System.out.println(result);
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            String a = reader.readLine();
//            String b = reader.readLine();
//            System.out.println(sumOfBinaries(a, b));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}