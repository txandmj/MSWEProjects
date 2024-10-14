import java.util.ArrayList;
import java.util.List;
public class NQueens {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> positions = new ArrayList<>();
    public List<List<Integer>> solveNQueens(int n) {
        int[][] chessboard = new int[n][n];
        backTrack(int n, int row, int[][] chessboard);
    }
    public void backTrack(int n, int row, int[][] chessboard) {
        if(row == n) {
            results.add(positions);
        }
        for(int i = 0; i < n; i++) {

        }
    }
}
