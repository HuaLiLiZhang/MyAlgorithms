package InterviewDirectory.LeetCode_after;

/**
 * Created by huali on 2018/7/12.
 */
public class isInterleaves1s2s3 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null&&s2==null&&s3==null)
            return true;
        if(s1==null||s2==null||s3==null)
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1==0&&len2==0&&len3==0)
            return true;
        if(len3!=len1+len2)
            return false;
        boolean [][] dp = new boolean[len1+1][len2+1];
        for(int i = 0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                dp[i][j] = i==0&&j==0||(i>=1)&&dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)
                        ||(j>=1)&&dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
            }
        }
        return dp[len1][len2];
    }
}