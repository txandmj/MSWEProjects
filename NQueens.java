import java.util.ArrayList;
import java.util.List;
//https://programmercarl.com/0051.N%E7%9A%87%E5%90%8E.html#%E6%80%9D%E8%B7%AF
public class NQueens {
    List<List<Integer>> results = new ArrayList<>();
    public void solveNQueens(int n) {
        if(n <= 0) {
            System.out.println("Invalid input number: " + n);
        }
        //Initializes the chessboard and starts the backtracking process from the first row
        int[][] chessboard = new int[n][n];
        backTrack(n, 0, chessboard);
    }
    //This is a recursive backtracking function that tries to place a queen in each column of the current row
    private void backTrack(int n, int row, int[][] chessboard) {
        if(row == n) {
            List<Integer> path = findPathInChessboard(chessboard);
            results.add(path);
            return;
        }
        for(int col = 0; col < n; col++) {
            if(isValid(col, row, n, chessboard)) {
                chessboard[row][col] = row + 1;
                backTrack(n, row + 1, chessboard);
                //After attempting to place a queen, it backtracks by resetting the chessboard for the next iteration
                chessboard[row][col] = 0;
            }
        }
    }
    //This checks whether placing a queen at the current position is valid
    //It ensures no queens exist in the same column, row or along both diagonals.
    private boolean isValid(int col, int row, int n, int[][] chessboard) {
//        for(int i = 0; i < n; i++) {
//            if(chessboard[row][i] != 0) {
//                return false;
//            }
//        }
        for(int j = 0; j < row; j++) {
            if(chessboard[j][col] != 0) {
                return false;
            }
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(chessboard[i][j] != 0) {
                return false;
            }
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(chessboard[i][j] != 0) {
                return false;
            }
        }
        return true;
    }
    //This method finds the positions of the queens in the chessboard and returns them as a list.
    //The result represents the row index of each queen in the respective column.
    private List<Integer> findPathInChessboard(int[][] chessboard) {
        List<Integer> path = new ArrayList<>();
        for(int col = 0; col < chessboard[0].length; col++) {
            for(int row = 0; row < chessboard.length; row++) {
                if(chessboard[row][col] != 0) {
                    path.add(chessboard[row][col]);
                }
            }
        }
        return path;
    }
    //This prints all the valid solutions stored in the results list.
    public void printNQueens() {
        for(List<Integer> list : results) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    //calculate the minimum moves required to match a given queen position with one of the valid solutions.
    //It compares the given queen positions with each solution and returns the minimum number of differing queen placements.
    public int minMoves(int[] queenPosition) {
        if(queenPosition.length != results.get(0).size()) {
            System.out.println("Input should match the size of chessboard!");
            return -1;
        }

        int minMove = queenPosition.length;
        for(List<Integer> list : results) {
            int count = 0;
            int index = 0;
            while(index < list.size()) {
                if(list.get(index) != queenPosition[index]) {
                    count++;
                }
                index++;
            }
            minMove = Math.min(minMove, count);
        }
        return minMove;
    }
}
