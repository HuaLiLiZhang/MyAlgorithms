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

        if(isValid(chs,exs))
        {

            //构建dp数组
            for(int i = elen-2; i>-1;i-=2)
            {
                if(exs[i]!='*'&&exs[i+1]=='*')
                    dp[slen][i] = true;
                else
                    break;
            }
            if(slen>0&&elen>0)
            {
                if(exs[elen-1]=='.'||chs[slen-1]==exs[elen-1])
                    dp[slen-1][elen-1] = true;
            }

            //对以后的进行判断。
            for(int i = chs.length-1;i>-1;i--)
            {
                for(int j = exs.length-2;j>-1;j--)
                {
                    if(exs[j+1]!='*')
                    {
                        dp[i][j] = (chs[i] == exs[j]||exs[j]=='.')&&dp[i+1][j+1];
                    }else {
                        int si = i;
                        while (si!=chs.length&&(chs[si]==exs[j]||exs[j]=='.'))
                        {
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