package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/19.
 */
public class minCoins3 {
    //0-1背包问题，一个只能取一次，不可重复取
    public int minCoins3(int[]arr,int aim)
    {
        if(arr==null||arr.length==0||aim<0)
            return -1;
        int n = arr.length;
        int [][] dp = new int[n][aim+1];
        int max = Integer.MAX_VALUE;
        for(int j =1;j<=aim;j++)
            dp[0][j] = max;
        if(arr[0]<=aim)
            dp[0][arr[0]] = 1;
        int left = 0;
        for(int i = 1;i<n;++i)
        {
            for(int j = 1;j<=aim;++j)
            {
                left = max;
                if(j-arr[i]>=0&&dp[i-1][j-arr[i]]!=max)
                    left = dp[i-1][j-arr[i]]+1;
                dp[i][j] = Math.min(dp[i-1][j],left);
            }
        }
        return dp[n-1][aim]==max?-1:dp[n-1][aim];
    }

    public int minCoin(int[]arr,int aim)
    {
        if(arr==null||arr.length==0||aim<0)
            return -1;
        int n = arr.length;
        int [] dp = new int[aim+1];
        int max = Integer.MAX_VALUE;
        for(int j = 1;j<=aim;++j)
        {
            dp[j] = max;
        }
        if(arr[0]<=aim)
            dp[arr[0]] = 1;
        int left = 0;
        for(int i = 1;i<n;++i)
        {
            for(int j=aim;j>=1;--j)
            {
                left = max;
                if(j-arr[i]>=0&&dp[j-arr[i]]!=max)
                    left = dp[j-arr[i]]+1;
                dp[j] = Math.min(left,dp[j]);
            }
        }
        return dp[aim]==max?-1:dp[aim];
    }
}