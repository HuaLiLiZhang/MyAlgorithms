package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/19.
 */
public class minPathSum1 {
    /**时间复杂度：O(MN) ,空房间复杂度也是O(MN)
     * 矩阵的最小路径和
     * 1 3 5 9
     * 8 1 3 4
     * 5 0 6 1
     * 8 8 4 0
     * 1.首先计算，第一行和第一列到达每个位置的最小路径和。
     * 得到：
     * 1 4 9 18
     * 9
     * 14
     * 22
     * 在计算剩下的 每行的最小路径和，此时应该比较最上边和最左边的值那个小，最小的加上本位置的值
     * 得到最小路径，
     * 返回最右边的那个值。
     * @param m
     * @return
     */
    public int minpathsum(int [][]m)
    {
        if(m==null||m.length==0||m[0]==null||m[0].length==0)
        {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int [][]dp = new int [row][col];
        dp[0][0]=m[0][0];
        for(int i=1;i<col;i++)
        {
            dp[0][i] = dp[0][i-1]+m[0][i];
        }
        for(int j= 1;j<row;j++)
        {
            dp[j][0]=dp[j-1][0]+m[j][0];
        }
        for(int i= 1;i<row;++i)
        {
            for(int j= 1;j<col;++j)
            {
                dp[i][j]= Math.min(dp[i-1][j],dp[i][j-1])+m[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    //空间复杂度为：O(min(M,N))
    public int minPathArr(int [][]m)
    {
        if(m==null||m.length==0||m[0]==null||m[0].length==0)
            return 0;
        int row = m.length;
        int col = m[0].length;
        int []arr = {0,0,0,0};
        arr[0]=m[0][0];
        for(int i=1;i<col;++i)
            arr[i]=m[0][i]+arr[i-1];
        for(int i=1;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(j==0)
                    arr[j]=m[i][j]+arr[j];
                else
                {
                    arr[j] = Math.min(arr[j-1],arr[j])+m[i][j];
                }
            }
        }
        return arr[col-1];
    }

    public int minpath(int[][]m)
    {
        if(m==null||m.length==0||m[0]==null||m[0].length==0)
            return 0;
        int more = Math.max(m.length,m[0].length);
        int less = Math.min(m.length,m[0].length);
        boolean rowmore = more ==m.length;
        int []arr = new int[less];
        arr[0]=m[0][0];
        for(int i=1;i<less;i++)
        {
            arr[i]=arr[i-1]+(rowmore?m[0][i]:m[i][0]);
        }
        for(int i=1;i<more;i++)
        {
            arr[0] = arr[0]+(rowmore?m[i][0]:m[0][i]);
            for(int j=1;j<less;++j)
            {
                arr[j]=Math.min(arr[j-1],arr[j])+(rowmore?m[i][j]:m[j][i]);
            }
        }
        return arr[less-1];
    }

}