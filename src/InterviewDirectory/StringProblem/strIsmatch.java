package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/11.
 */
public class strIsmatch {
    public boolean isValid(char [] str ,char[] exp)
    {
        for(int i =0;i<str.length;i++)
        {
            if(str[i]=='.'||str[i]=='*')
                return false;
        }
        for(int i =0 ;i<exp.length;i++)
        {
            if(exp[i]=='*'&&(i==0||exp[i-1]=='*'))
                return false;
        }
        return true;
    }

    public boolean isMacth(String str, String exp)
    {
        if(str==null||exp==null)
            return false;
        char[] chs = str.toCharArray();
        char[] exps = exp.toCharArray();
        //return isValid(chs, exps)? process(chs, exps, 0, 0):false; //修改为：
        return isValid(chs, exps)&&process(chs, exps, 0, 0);
    }

    public boolean process(char[] str ,char[] exp, int si, int ei)
    {
        if(ei==exp.length)
            return si==str.length;
        if(ei+1== exp.length||exp[ei+1]!='*')
        {
            return si!=str.length&&(exp[ei]==str[si]||exp[ei]=='.')
                    &&process(str, exp, si+1, ei+1);
        }
        while (si!=str.length&&(exp[ei]==str[si]||exp[ei]=='.'))
        {
            if(process(str, exp, si,ei+2))
            {
                return true;
            }
            si++;
        }
        return process(str, exp,si,ei+2);
    }

}