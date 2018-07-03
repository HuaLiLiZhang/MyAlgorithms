package offer;

/**
 * Created by huali on 2018/7/3.
 */
public class hasPath_matrix {
    
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null||str==null||matrix.length<=0||str.length==0)
            return false;
        if(rows<1||cols<1)
            return false;
        int pathlength = 0;
        boolean [] visited = new boolean[rows*cols];
        for(int row=0;row<rows;row++)
        {
            for(int col =0;col<cols;col++)
            {
                if(haspath(matrix, rows,cols,row,col,str,pathlength, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean haspath(char[] matrix, int rows, int cols,
                          int row, int col, char[] str,
                         int pathlength, boolean[] visited) {
        if(pathlength==str.length)
            return true;
        boolean hapsth = false;
        if(row>=0&&row<rows&&col>=0&&col<cols&&
                matrix[row*cols+col]==str[pathlength]&&
                !visited[row*cols+col])
        {
            pathlength++;
            visited[row*cols+col]=true;
            hapsth= haspath ( matrix, rows, cols, row-1, col, str, pathlength, visited )
                    || haspath ( matrix, rows, cols, row, col-1, str, pathlength, visited )
                    || haspath ( matrix, rows, cols, row+1, col, str, pathlength, visited )
                    || haspath ( matrix, rows, cols, row, col+1, str, pathlength, visited );
            if(!hapsth)
            {
                pathlength--;
                visited[row*cols+col]=false;
            }
        }

        return  hapsth;
    }
}