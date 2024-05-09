package problems.GreatestEnglishLetterInUpperAndLowerCase;

class Solution1 {
    public String greatestLetter(String s) {
        char result = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            boolean isUpperCase = Character.isUpperCase(chars[i]);

            if (isUpperCase) {
                char tmp = Character.toLowerCase(chars[i]);
                int idx = s.indexOf(tmp);
                if (idx != -1 && chars[i] > result) {
                    result = chars[i];
                }
            } else {
                char tmp = Character.toUpperCase(chars[i]);
                int idx = s.indexOf(tmp);
                if (idx != -1 && tmp > result) {
                    result = tmp;
                }
            }
        }

        return result == 0 ? "" : Character.toString(result);
    }
}