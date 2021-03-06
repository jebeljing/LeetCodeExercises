package package100;

/**
 * Created by Jebeljing on 12/11/2016.
 * 130. Surrounded Regions
 *  Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,

 X X X X
 X O O X
 X X O X
 X O X X

 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X

 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 2 || board[0].length < 2) return;

        int m = board.length;
        int n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1);
        }
//Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[m - 1][j] == 'O')
                dfs(board, m - 1, j);
        }
//post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j  < 0 || j > board[0].length - 1) return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i - 1][j] == 'O') dfs(board, i - 1, j);
        if (i < board.length - 1 && board[i + 1][j] == 'O') dfs(board, i + 1, j);
        if (j > 1 && board[i][j - 1] == 'O') dfs(board, i, j - 1);
        if (j < board[0].length - 1 && board[i][j + 1] == 'O') dfs(board, i, j + 1);
    }
}
