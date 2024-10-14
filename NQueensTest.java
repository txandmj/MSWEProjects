public class NQueensTest {
    public static void main(String[] args) {
        NQueens nqueens = new NQueens();
        nqueens.solveNQueens(8);
        //nqueens.printNQueens();
        //test1: from assignment
        int[] queenPosition1 = {1,2,3,4,5,6,7,8};
        int minMoves1 = nqueens.minMoves(queenPosition1);
        System.out.println(minMoves1);
        //test2: from assignment
        int[] queenPosition2 = {1,1,1,1,1,1,1,1};
        int minMoves2 = nqueens.minMoves(queenPosition2);
        System.out.println(minMoves2);
        //test3: edge case
        int[] queenPosition3 = {};
        int minMoves3 = nqueens.minMoves(queenPosition3);
        System.out.println(minMoves3);
        //test4: one solution of 8 queens
        int[] queenPosition4 = {1,7,5,8,2,4,6,3};
        int minMoves4 = nqueens.minMoves(queenPosition4);
        System.out.println(minMoves4);
    }
}
