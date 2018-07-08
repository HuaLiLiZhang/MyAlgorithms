package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/6.
 */
public class solveOX {
    int rows = 0;
    int cols = 0;
    public void solve(char[][] board) {

        if(board==null||board.length<=0||board[0].length<=0)
            return ;
        rows = board.length;
        cols = board[0].length;
        for(int j =0;j<cols;j++)
        {
            dfs(board, 0, j);
            dfs(board, rows-1, j);
        }
        for(int i = 0;i<rows;i++)
        {
            dfs(board, i,0);
            dfs(board, i, cols-1);
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                if(board[i][j]=='*')
                    board[i][j] = 'O';
            }
        }


    }

    private void dfs(char[][] board, int row, int col) {
        if(board[row][col]=='O')
        {
            board[row][col]='*';
            if(row>1)
                dfs(board,row-1, col);
            if(col>1)
                dfs(board, row, col-1);
            if(row<rows-1)
                dfs(board,row+1, col);
            if(col<cols-1)
                dfs(board, row,col+1);
        }
    }
}