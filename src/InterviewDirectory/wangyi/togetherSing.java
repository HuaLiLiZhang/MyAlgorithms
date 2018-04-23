package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/23.
 */
public class togetherSing {
    //动态规划
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
                    acc[i] = acc[i-1]+Math.abs(arr[i]-arr[i-1]);
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