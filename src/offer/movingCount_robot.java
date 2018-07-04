package offer;

/**
 * Created by huali on 2018/7/3.
 */
public class movingCount_robot {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0)
            return 0;
        boolean [] visited = new boolean[rows*cols];
        int count = countMovingsteps(threshold,rows,cols, 0,0,visited);
        return count;
    }

    private int countMovingsteps(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if(row>=0 && row<rows && col>=0 && col<cols
                && getSum ( row )+getSum ( col )<= threshold
                && !visited[row*cols+col])
        {
            visited[row*cols+col]=true;
            count = 1+countMovingsteps(threshold,rows,cols,row-1,col,visited)
                    +countMovingsteps(threshold,rows,cols,row,-1,visited)
                    +countMovingsteps(threshold,rows,cols,row+1,col,visited)
                    +countMovingsteps(threshold,rows,cols,row,col+1,visited);
        }
        return count;
    }

    private int getSum(int col) {
        int count =0;
        while (col!=0)
        {
            count+=col%10;
            col/=10;
        }
        return count;
    }
}