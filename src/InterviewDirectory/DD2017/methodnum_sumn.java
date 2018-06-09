package InterviewDirectory.DD2017;

import java.util.Scanner;

/**
 * Created by huali on 2018/6/7.
 */
public class methodnum_sumn {
//6
//给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
//当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
    static long [][]dp = new long [1000][1000] ;
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        int n= sr.nextInt();
        int sum = sr.nextInt();
        int [] arr = new int[n+1];
        for(int i =1;i<=n;i++)
        {
            arr[i] = sr.nextInt();
        }
        //初始化dp,用前i个组成和为0的方案，只有1种，就是什么都不取，和为0；
        for(int i=0;i<n;i++)
            dp[i][0] = 1;
        //用0个元素不能组成1~sum
        for(int j=1;j<=sum;j++)
        {
            dp[0][j] = 0;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(arr[i]<=j)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[n][sum]);
    }
}