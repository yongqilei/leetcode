// 
// 
package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueens {

    List<List<String>> ans = new ArrayList<>();
    boolean[] visitedRow;
    boolean[] visitedCol;
    boolean[] diagonal;
    boolean[] backDiagonal;
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        visitedRow = new boolean[n];
        visitedCol = new boolean[n];
        diagonal = new boolean[2 * n];
        backDiagonal = new boolean[2 * n];
        backtrace(queens, n, 0);
        return ans;
    }
    public void backtrace(int[] queens, int n, int row) {
        if (row == n) {
            ans.add(generateBoard(queens, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (visitedRow[row] || visitedCol[col] || diagonal[row + col] || backDiagonal[row - col + n - 1]) {
                continue;
            }
            queens[row] = col;
            visitedRow[row] = true;
            visitedCol[col] = true;
            diagonal[row + col] = true;
            backDiagonal[row - col + n - 1] = true;
            backtrace(queens, n, row + 1);
            queens[row] = 0;
            visitedRow[row] = false;
            visitedCol[col] = false;
            diagonal[row + col] = false;
            backDiagonal[row - col + n - 1] = false;
        }
    }
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        char[] row = new char[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
