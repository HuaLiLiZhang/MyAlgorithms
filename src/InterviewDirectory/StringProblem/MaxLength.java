package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/7.
 */
public class MaxLength {
    //给定一个字符串str，判断整体是有效的括号字符串的最长括号子串的长度。
    //时间复杂度为O(N)，空间复杂度是：O(N)
    //有效括号字符串的长度

    //算法思想：
    //动态规划：

    /**
     * 1.只有一个字符，dp[0]=0
     * 2.从左遍历str i--(n-1)，对于str[i]：
     * 如果str[i]=‘）’,pre= i-dp[i-1]-1，就判断str[i-dp[i-1]-1]的字符是否为‘（’，如果是dp[i] = dp[i-1]+2;
     *  然后还要判断在str[i-dp[i-1]-1]的字符是为‘（’的基础上pre>0时，dp[i] = dp[i-1]+2+(pre>0?dp[pre-1]:0);
     * @param str
     * @return
     */

    public int maxlength(String str)
    {
        if(str==null||str.equals(""))
            return 0;
        char[]chr = str.toCharArray();
        int []dp = new int [chr.length];
        int pre = 0;
        int res = 0;
        for(int i = 0;i<chr.length;i++)
        {
            if(chr[i]==')')
            {
                pre = i - dp[i-1] -1;
                if(pre>=0&&chr[pre]=='(')
                {
                    dp[i] = dp[i-1]+2+(pre>0?dp[pre-1]:0);
                //    pre>0?dp[pre-1]:0是判断出现这种情况，()(())(，前面还有两个单个的（）
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}