package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/6.
 */
public class huiwenmincut {
    public int mincut(String s)
    {
        if(s.equals("")||s.length()<=0||s.length()==1)
            return 0;
        int [] dp = new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            dp[i] = ishuiwensequence(s.substring(0,i+1))?0:i;
            if(dp[i]==0)
                continue;
            for(int j=1;j<=i;j++)
            {
                if(ishuiwensequence(s.substring(j,i+1)))
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
                else
                    dp[i] = Math.min(dp[i],dp[j-1]+i+1-j);
            }
        }
        return dp[s.length()-1];

    }

    private boolean ishuiwensequence(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start<end)
        {
            if(s.charAt(start++)!=s.charAt(end--))
                return false;

        }
        return true;
    }
}