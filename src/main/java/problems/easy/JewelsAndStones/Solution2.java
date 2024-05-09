package problems.easy.JewelsAndStones;

public class Solution2 {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        for (char c : stones.toCharArray()) {
            if (jewels.indexOf(c) != -1) {
                count++;
            }
        }

        return count;
    }
}
