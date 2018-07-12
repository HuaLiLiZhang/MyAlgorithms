package InterviewDirectory.LeetCode_after;

/**
 * Created by huali on 2018/7/11.
 */
public class isInterleaveThreeString {
    public boolean isInterleave(String s1, String s2, String s3)
    {
        if(s1==null||s2==null||s3==null)
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1==0&&len2==0&&len3==0)
            return true;
        boolean dp[][] = new boolean[len1+1][len2+1];
        if(len3!=len1+len2)
            return false;
        for(int i=0;i<=len1;i++)
        {
            for(int j =0;j<=len2;j++)
            {
                dp[i][j] = i==0&&j==0||
                        (i-1>=0)&&dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)
                        ||(j-1>=0)&&dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args)
    {
        String s1 = "aabcc"   ;
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";
        isInterleaveThreeString is = new isInterleaveThreeString();
        boolean re = is.isInterleave(s1,s2,s3);
        System.out.println(re);
    }
}