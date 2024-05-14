package problems.easy.SingleNumber;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: " + solution1.singleNumber(new int[]{2,2,1}) + "\n");
        System.out.printf("Solution1: " + solution1.singleNumber(new int[]{4,1,2,1,2}) + "\n");
        System.out.printf("Solution1: " + solution1.singleNumber(new int[]{1}) + "\n");
    }
}