package problems.FinalValueOfVariableAfterPerformingOperations;

public class Solution1 {
    public int finalValueAfterOperations(String[] operations) {
        return apply(operations, 0, 0);
    }

    public int apply(String[] operations, int x, int idx) {
        if (idx == (operations.length)) {
            return x;
        }

        if ((operations[idx].equals("++X")) || (operations[idx].equals("X++"))) {
            return apply(operations, x += 1, idx += 1);
        } else {
            return apply(operations, x -= 1, idx += 1);
        }
    }
}
