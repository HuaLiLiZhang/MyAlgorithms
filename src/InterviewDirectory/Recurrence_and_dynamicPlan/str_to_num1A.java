package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/27.
 */
public class str_to_num1A {
    public int num1(String str)
    {
        if(str==null||str.length()==0)
            return 0;
        char[] ch = str.toCharArray();
        return process(ch , 0);
    }
    public int process(char[]ch, int i)
    {
        if(i==ch.length)
            return 1;
        if(ch[i]=='0')
            return 0;
        int res = process(ch,i+1);
        if(i+1<ch.length&&(ch[i]-'0')*10+ch[i+1]-'0'<27)
            res+=process(ch,i+2);
        return res;
    }


    public int num2(String str)
    {
        if(str==null||str.length()==0)
            return 0;
        char[] ch = str.toCharArray();
        int cur = ch[ch.length-1]=='0'?0:1;
        int next = 1;
        int tmp=0;
        for(int i=ch.length-2;i>=0;i--)
        {
            if(ch[i]=='0')
            {
                next = cur;
                cur =0;
            }else {
                tmp = cur;
                if((ch[i]-'0')*10+ch[i+1]-'0'<27)
                    cur+=next;
                next = tmp;
            }

        }
        return cur;
    }
}