package problems.easy.FinalValueOfVariableAfterPerformingOperations;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: operations = [\"++X\",\"++X\",\"X++\"] is " + solution1.finalValueAfterOperations(new String[]{"++X","++X","X++"}) + "\n");
        System.out.printf("Solution1: operations = [\"X++\",\"++X\",\"--X\",\"X--\"] is " + solution1.finalValueAfterOperations(new String[]{"X++","++X","--X","X--"}) + "\n");
        System.out.printf("Solution1: operations = [\"--X\",\"X++\",\"X++\"] is " + solution1.finalValueAfterOperations(new String[]{"--X","X++","X++"}) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: operations = [\"++X\",\"++X\",\"X++\"] is " + solution2.finalValueAfterOperations(new String[]{"++X","++X","X++"}) + "\n");
        System.out.printf("Solution2: operations = [\"X++\",\"++X\",\"--X\",\"X--\"] is " + solution2.finalValueAfterOperations(new String[]{"X++","++X","--X","X--"}) + "\n");
        System.out.printf("Solution2: operations = [\"--X\",\"X++\",\"X++\"] is " + solution2.finalValueAfterOperations(new String[]{"--X","X++","X++"}) + "\n");

    }
}