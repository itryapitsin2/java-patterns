package problems.easy.JewelsAndStones;

class Solution1 {
    public int numJewelsInStones(String jewels, String stones) {
        int countOfJewels = 0;
        for(char stone: stones.toCharArray()) {
            for(char jewel: jewels.toCharArray()) {
                if (stone == jewel) {
                    countOfJewels++;
                }
            }
        }
        return countOfJewels;
    }
}