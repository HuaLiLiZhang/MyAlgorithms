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
                dp[i][j] = Math.min(right ,down);
            }

        }
        return dp[0][0];
    }

    public int minHp2(int [][]map)
    {
        if(map==null||map.length==0||map[0]==null||map[0].length==0)
            return 1;
        int more = Math.max(map.length,map[0].length);
        int less= Math.min(map.length,map[0].length);
        boolean rowmore =more== map.length;

        int []dp = new int[less];
        int tmp = map[map.length-1][map[0].length-1];
        dp[less-1] = tmp>0?1:-tmp+1;

        int row = 0;
        int col = 0;

        for(int i = less-2;i>=0;i--)
        {
            row = rowmore?more -1:i;
            col = rowmore?i:more-1;
            dp[i] = Math.max(dp[i+1]-map[row][col],1);
        }
        for(int i=more-2;i>=0;i--)
        {
            row = rowmore?i:less-1;
            col = rowmore?less-1:i;
            dp[less-1] = Math.max(dp[less-1]-map[row][col],1);
            for(int j = less -2;j>=0;j--)
            {
                row = rowmore?i:j;
                col = rowmore?j:i;
                dp[j] = Math.min(Math.max(dp[j]-map[row][col],1),Math.max(dp[j+1]-map[row][col],1));
            }
        }
        return dp[0];

    }
}