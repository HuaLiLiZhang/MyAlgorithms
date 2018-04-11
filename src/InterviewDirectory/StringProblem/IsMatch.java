package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/11.
 */
public class IsMatch {
    //递归调用
    public boolean isValid(char[]s, char []e)
    {
        for(int i = 0;i<s.length;i++)
        {
            if(s[i]=='*'||s[i]=='.')
                return false;
        }
        for(int i =0;i<e.length;i++)
        {
            if(e[i]=='*'&&(i==0||e[i-1]=='*'))
                return false;
        }
        return true;
    }

    public boolean Ismatch1(String s, String e)
    {
        if(s==null||e==null)
            return false;
        char [] ch = s.toCharArray();
        char [] ex = e.toCharArray();
        return isValid(ch, ex)&&process(ch, ex, 0, 0);
    }
    public boolean process(char[] s, char [] e, int si, int ei)
    {
        if(ei==e.length)
            return si == s.length;
        if(ei+1==e.length||e[ei+1]!='*')
            return si!=s.length&&(s[si]==e[ei]||e[ei]=='.')
                    &&process(s, e, si+1, ei+1);
        while (si!=s.length&&(s[si]==e[ei]||e[ei]=='.'))
        {
            if(process(s, e, si, ei+2))
                return true;
            si++;
        }
        return process(s, e, si, ei+2);
    }


    //动态规划
    //str :是原字符串，exp是：能否匹配str的字符串,就是是否满足能保证跟str一样
    public boolean isMathc2(String str, String exp)
    {
        if(str==null||exp==null)
            return false;
        char [] chs = str.toCharArray();
        char [] exs = exp.toCharArray();
        int slen = chs.length;
        int elen = exs.length;
        boolean [][] dp = new boolean[slen+1][elen+1];
        dp[slen][elen] =  true;
        // index 是计数到slen ,elen时候，str， exp已经遍历完，故等于true

        if(isValid(chs,exs))
        {

            //构建dp数组
            for(int i = elen-2; i>-1;i-=2)
            {
                //先从最后一行最后面开始，表示str已经读取完，exp为读取到elen -2,
                // exp: .     *      b,前面的elen-2 个exp[elen-2]必须不等于*，exp[elen-1]必须等于*
                // elen-2    elen-1  elen
                if(exs[i]!='*'&&exs[i+1]=='*')
                    dp[slen][i] = true;
                else
                    break;
            }
            if(slen>0&&elen>0)
            {
                //这个是对最后一列进行判断，slen-1 行elen-1列的字符满足,
                // 相等或者exs[elen-1]=='.',就等于true
                if(exs[elen-1]=='.'||chs[slen-1]==exs[elen-1])
                    dp[slen-1][elen-1] = true;
                //其他情况默认为false，
                // 初始化boolean [][] dp = new boolean[slen+1][elen+1];默认false。
            }

            //对以后的进行判断。
            for(int i = chs.length-1;i>-1;i--)
            {
                for(int j = exs.length-2;j>-1;j--)
                {
                    if(exs[j+1]!='*')  //分情况：j+1 的字符串不等*，满足,
                    // 相等或者exs[j]=='.'和dp[i+1][j+1]为true 就等于true
                    {
                        dp[i][j] = (chs[i] == exs[j]||exs[j]=='.')&&dp[i+1][j+1];
                    }else {
                        //j+1 的字符串等*
                        int si = i;
                        while (si!=chs.length&&(chs[si]==exs[j]||exs[j]=='.'))
                        {
                            //chs[si]==exs[j]||exs[j]=='.'时候，判断后面的dp[si][j+2]满足的话，
                            // 因为当前已经满足。就为true，
                            if(dp[si][j+2])
                            {
                                dp[i][j]=true;
                                break;
                            }
                            si++;
                        }
                        if(!dp[i][j])
                        {
                            dp[i][j]=dp[si][j+2];
                        }
                    }
                }
            }
            return dp[0][0];
        }
        return false;
    }
}