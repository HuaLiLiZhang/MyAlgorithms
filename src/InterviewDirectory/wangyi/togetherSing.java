package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/23.
 */
public class togetherSing {
    //动态规划题
    //
    //1.dp[i][j]（永远有i > j）表示某一个人最近唱的音为第i个，另一个人最近唱的是第j个时最小的难度
    //2. 由于只由一个人唱完肯定不是最优解。因此先在一个for循环内确定以下两种情况的初值
    //          dp[i][0]：第二个人唱第一个音，第一个人唱后面所有音
    //          dp[i][i-1]：第一个人唱最近的一个音，第二个人唱前面所有音
    //3.dp[i][j]转移方程
    //      每当交换唱歌次序，两人最近一次唱的音符一定是相邻的，所以底下分相邻和不相邻讨论：
    //(1). 当j == i - 1，即交换唱歌次序，dp[i][i-1]时，表明第一个人上一个音可能在第k个音（0 <= k < i-1）,由唱了最近的第i个，第二个人仍然留在第i-1个音。
    //dp[i][i-1] = 对所有k求min(dp[i-1][k] + abs(arr[i] - arr[k]) ) 其中（0 <= k < i-1）
    //(2). 当j < i - 1，即不交换唱歌次序时，只可能由唱到i-1音符的人续唱
    //dp[i][j] = dp[i-1][j] + abs(arr[i] - arr[i-1])
    //
    //最后求出所有dp[len-1][]里的最小值即为全局最优解
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int n = sr.nextInt();
            int []arr = new int[n];
            for(int i =0 ;i<n;i++)
                arr[i] = sr.nextInt();
            if(n>2000||n<1)
                break;
            if(n<3)  //n小于3的话，只有两个，一个人分担一个，就没有音差了。
                System.out.println("0");
            else
            {
                int []acc = new int[n];
                int [][] dp = new int [n][n];
                dp[0][0] = 0-Math.abs(arr[1]-arr[0]);

                for(int i = 1;i<n;i++)
                {
                    acc[i] = acc[i-1]+Math.abs(arr[i]-arr[i-1]);   //acc代表总难度增加总和。
                    dp[i][i-1] = acc[i-1];
                    for(int j=0;j<i-1;j++)
                    {
                        dp[i][j] = dp[i-1][j] + acc[i] -acc[i-1];
                        dp[i][i-1] = Math.min(dp[i][i-1], dp[i-1][j]+Math.abs(arr[i]-arr[j]));
                    }
                }
                int min = Integer.MAX_VALUE;
                for(int j=0;j<n-1;j++)
                {
                    min = Math.min(min, dp[n-1][j]);
                }
                System.out.println(min);
            }
        }
        sr.close();

    }
}