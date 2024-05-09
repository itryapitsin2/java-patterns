package problems.PartitioningIntoMinimumNumberOfDeciBinaryNumbers;

public class Solution1 {

    public int minPartitions(String n) {
        int result = 0;

        char[] chars = n.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            int value = Character.getNumericValue(chars[i]);
            if (value > result) {
                result = value;
            }
        }

        System.gc();

        return result;
    }
}
