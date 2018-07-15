package InterviewDirectory.JD2017;

import java.util.Scanner;

/**
 * Created by huali on 2018/7/13.
 */
public class passTheExam {
    public static void main(String[] args)
    {
        Scanner sr = new Scanner(System.in);

        int n = sr.nextInt();
        int []arr = new int[100+5];
        for(int i=1;i<=n;i++)
        {
            arr[i] = sr.nextInt();
        }
        double [][] dp = new double[100+5][100+5];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++)
        {
            dp[i][0] = dp[i-1][0]*(100.0-arr[i])/100;
            for(int j = 1;j<=i;j++)
            {
                dp[i][j] = dp[i-1][j]*(100-arr[i])/100+dp[i-1][j-1]*1.0*arr[i]/100;
            }
        }
        int begin = (3*n+4)/5;
        double ans = 0;
        for(int i = begin;i<=n;i++)
            ans+=dp[n][i];
        System.out.println(String.format("%.5f",ans));
    }
}