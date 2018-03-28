package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/28.
 */
public class str_01_boolean {
    //表达式得到期望结果的组成种数。
    //判断合法性
    //划分进行判断。
    public int str_01_num1(String str, boolean desired)
    {
        if(str==null||str.equals(""))
            return 0;
        char[] ch = str.toCharArray();
        if(!isValid(ch))
            return 0;
        return p(ch,desired,0,ch.length-1);
    }

    public int p(char[]ch,boolean desired, int l,int r) {
        if (l == r) {
            if (ch[l] == '1')
                return desired ? 1 : 0;
            else
                return desired ? 0 : 1;
        }
        int res = 0;
        if (desired) {
            for (int i = l + 1; i < r; i += 2) {
                switch (ch[i]) {
                    case '&':
                        res += p(ch, true, l, i - 1) * p(ch, true, i + 1, r);
                        break;
                    case '|':
                        res += p(ch, true, l, i - 1) * p(ch, true, i + 1, r);
                        res += p(ch, true, l, i - 1) * p(ch, false, i + 1, r);
                        res += p(ch, false, l, i - 1) * p(ch, true, i + 1, r);
                        break;
                    case '^':
                        res += p(ch, true, l, i - 1) * p(ch, false, i + 1, r);
                        res += p(ch, false, l, i - 1) * p(ch, true, i + 1, r);
                        break;
                }
            }
        } else {
            for (int i = l + 1; i < r; i = i + 2) {
                switch (ch[i]) {
                    case '&':
                        res += p(ch, false, l, i - 1) * p(ch, true, i + 1, r);
                        res += p(ch, true, l, i - 1) * p(ch, false, i + 1, r);
                        res += p(ch, false, l, i - 1) * p(ch, false, i + 1, r);
                        break;
                    case '|':
                        res += p(ch, false, l, i - 1) * p(ch, false, i + 1, r);
                        break;
                    case '^':
                        res += p(ch, true, l, i - 1) * p(ch, true, i + 1, r);
                        res += p(ch, false, l, i - 1) * p(ch, false, i + 1, r);
                        break;
                }
            }
        }
        return res;
    }

    public boolean isValid(char[] ch)
    {
        if((ch.length&1)==0)
            return false;
        for(int i =0;i<ch.length;i=i+2)
        {
            if(ch[i]!='0'&&ch[i]!='1')
                return false;
        }
        for(int j =1;j<ch.length;j=j+2)
        {
            if(ch[j]!='&'&&ch[j]!='|'&&ch[j]!='^')
                return false;
        }
        return true;
    }
}