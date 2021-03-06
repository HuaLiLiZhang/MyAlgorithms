package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/10.
 */
public class mincut {
    public int nimcut1(String str)
    {
        if(str==null||str.equals(""))
        {
            return 0;
        }
        char[]chas = str.toCharArray();
        int len = chas.length;
        int []dp = new int[len+1];
        dp[len]=-1;
        boolean [][]p = new boolean[len][len];
        for(int i =len-1;i>=0;i--)
        {
            dp[i] = Integer.MAX_VALUE;
            for(int j = i;j<len;j++)
            {
                if(chas[i]==chas[j]&&(j-i<2||p[i+1][j-1]))
                {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }
}