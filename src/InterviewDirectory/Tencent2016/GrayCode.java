package InterviewDirectory.Tencent2016;

import java.util.*;
/**
 * Created by huali on 2018/5/10.
 */
public class GrayCode {
    public String[] getGray(int n) {
        int m = (int)Math.pow(2,n);
        int [][] dp = new int[m][n];

        int count = 0;
        for(int i=0;i<m;i++)
        {
            int two = count;
            for(int j=n-1;j>=0;j--)
            {
                dp[i][j] = two&1;
                two = two>>>1;
            }

            count++;
        }
        String [] s = new String[m];
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(s[i]!=null&&j!=0)
                    s[i] = s[i]+String.valueOf(dp[i][j-1]^dp[i][j]);
                else
                    s[i] = String.valueOf(dp[i][j]);
            }

        }
        return s;
    }

    public static void main(String []args)
    {
        String [] s = new GrayCode().getGray(3);
        for(String s1:s)
        {
            System.out.print('"'+s1+'"');
            System.out.print(" ");
        }
    }
}