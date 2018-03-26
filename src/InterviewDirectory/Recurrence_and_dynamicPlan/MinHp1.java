package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/26.
 */
public class MinHp1 {
    public int minHP1(int [][]map)
    {
        if(map==null||map.length==0||map[0]==null||map[0].length==0)
            return 1;
        int row = map.length;
        int col = map[0].length;
        int [][]dp = new int [row--][col--];
        dp[row][col]=map[row][col]>0?1:-map[row][col]+1;
        for(int j=col-1;j>=0;j--)
        {
            dp[row][j]=Math.max(dp[row][j+1]-map[row][j],1);
        }
        int right = 0;
        int down = 0;
        for(int i=row-1;i>=0;i--)
        {
            dp[i][col] = Math.max(dp[i+1][col]-map[i][col],1);
            for(int j=col-1;j>=0;j--)
            {
                right = Math.max(dp[i][j+1]-map[i][j],1);
                down = Math.max(dp[i+1][j]-map[i][j],1);
                dp[i][j] = Math.max(right ,down);
            }

        }
        return dp[0][0];
    }


}