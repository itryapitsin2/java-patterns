package problems.easy.MissingNumber;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: " + solution1.singleNumber(new int[]{3,0,1}) + "\n");
        System.out.printf("Solution1: " + solution1.singleNumber(new int[]{0,1}) + "\n");
        System.out.printf("Solution1: " + solution1.singleNumber(new int[]{9,6,4,2,3,5,7,0,1}) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution1: " + solution2.singleNumber(new int[]{3,0,1}) + "\n");
        System.out.printf("Solution1: " + solution2.singleNumber(new int[]{0,1}) + "\n");
        System.out.printf("Solution1: " + solution2.singleNumber(new int[]{9,6,4,2,3,5,7,0,1}) + "\n");
    }
}