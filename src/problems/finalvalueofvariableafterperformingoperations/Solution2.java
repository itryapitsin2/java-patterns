package problems.finalvalueofvariableafterperformingoperations;

public class Solution2 {
    public int finalValueAfterOperations(String[] operations) {
        return apply(operations, 0, 0);
    }

    public int apply(String[] operations, int x, int idx) {
        int X = 0;
        int n = operations.length;
        for (int i = 0; i < n; i++) {
            if (operations[i].equals("++X") || operations[i].equals("X++")) X += 1;
            else if (operations[i].equals("--X") || operations[i].equals("X--")) X -= 1;
        }
        return X;
    }
}
