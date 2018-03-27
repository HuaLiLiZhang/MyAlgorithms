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



}