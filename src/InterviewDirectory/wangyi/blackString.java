package InterviewDirectory.wangyi;

        import java.util.Scanner;

/**
 * Created by huali on 2018/4/26.
 */
public class blackString {
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int n = sr.nextInt();
            long [] dp = new long [n+1];
            dp[1] = 3;
            dp[2] = 9;
            for(int i = 3;i<=n;i++)
            {
                dp[i] = 2*dp[i-1] + dp[i-2];
            }
            System.out.println(dp[n]);
        }
        sr.close();
    }
}