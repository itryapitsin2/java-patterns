package problems.PartitioningIntoMinimumNumberOfDeciBinaryNumbers;


public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: " + solution1.minPartitions("32") + "\n");
        System.out.printf("Solution1: " + solution1.minPartitions("82734") + "\n");
        System.out.printf("Solution1: " + solution1.minPartitions("27346209830709182346") + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: " + solution2.minPartitions("32") + "\n");
        System.out.printf("Solution2: " + solution2.minPartitions("82734") + "\n");
        System.out.printf("Solution2: " + solution2.minPartitions("27346209830709182346") + "\n");

    }
}