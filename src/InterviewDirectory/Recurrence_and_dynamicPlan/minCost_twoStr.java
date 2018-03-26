package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/24.
 */
public class minCost_twoStr {
    public int mincost1(String str1,String str2, int ic, int dc,int rc)
    {
        if(str1==null||str2==null)
        {
            return 0;
        }
        char[]ch1 = str1.toCharArray();
        char[]ch2 = str2.toCharArray();
        int row = ch1.length+1;
        int col = ch2.length+1;
        int[][]dp = new int[row][col];
        for (int i =1;i<row;i++)
        {
            dp[i][0] = dc*i;
        }
        for(int j=1;j<col;j++)
        {
            dp[0][j]=ic*j;
        }
        for(int i=1;i<row;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(ch1[i-1]==ch2[j-1])
                {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j]=dp[i-1][j-1]+rc;
                }
                dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+ic);
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+dc);
            }
        }
        return dp[row-1][col-1];

    }


    public int minCost(String str1,String str2,int ic,int dc,int rc)
    {
        if(str1==null||str2==null)
        {
            return 0;
        }
        char[]ch1 = str1.toCharArray();
        char[]ch2 = str2.toCharArray();
        char[]longs = ch1.length>ch2.length?ch1:ch2;
        char[]shorts = ch1.length<ch2.length?ch1:ch2;
        if(ch1.length<ch2.length)
        {
            int temp = ic;
            ic = dc;
            dc = temp;
        }
        int []dp = new int[shorts.length+1];
        for(int i=1;i<=shorts.length;i++)
            dp[i] = ic*i;
        for(int i =1;i<=longs.length;i++)
        {
            int pre= dp[0];
            dp[0] =dc*i;
            for(int j=1;j<=shorts.length;j++)
            {
                int tmp = dp[j];
                if(longs[i-1]==shorts[j-1])
                {
                    dp[j] = pre;
                }else {
                    dp[j]=pre+rc;
                }
                dp[j] = Math.min(dp[j],dp[j-1]+ic);
                dp[j] = Math.min(dp[j],tmp+dc);
                //dp[j] = Math.max(Math.max(dp[j],dp[j-1]+ic),tmp+dc);
                pre = tmp;
            }
        }
        return dp[shorts.length];
    }
}