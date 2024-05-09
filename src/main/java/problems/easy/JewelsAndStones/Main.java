package problems.easy.JewelsAndStones;


public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: jewels = \"aA\", stones = \"aAAbbbb\" is " + solution1.numJewelsInStones("aA", "aAAbbbb") + "\n");
        System.out.printf("Solution1: jewels = \"z\", stones = \"ZZ\" is " + solution1.numJewelsInStones("z", "ZZ") + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: jewels = \"aA\", stones = \"aAAbbbb\" is " + solution2.numJewelsInStones("aA", "aAAbbbb") + "\n");
        System.out.printf("Solution2: jewels = \"z\", stones = \"ZZ\" is " + solution2.numJewelsInStones("z", "ZZ") + "\n");
    }
}