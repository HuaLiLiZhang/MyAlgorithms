package offer;

/**
 * Created by huali on 2018/7/1.
 */
public class isNumeric1 {
    private  int index= 0;
    public boolean isNumeric(char[] str) {
        if(str.length<=0)
            return false;
        boolean flag = matchAdd(str);
        if(index<str.length&&str[index]=='.')
        {
            index++;
            flag = matchInteger(str)||flag;
        }
        if(index<str.length&&(str[index]=='E'||str[index]=='e'))
        {
            index++;
            flag = flag&&matchAdd(str);
        }
        return flag&&index==str.length;


    }

    private boolean matchAdd(char[] str) {
        if(index<str.length&&(str[index]=='+'||str[index]=='-'))
            index++;
        return matchInteger(str);
    }

    private boolean matchInteger(char[] str) {
        int start = index;
        while (index<str.length&&(str[index]>='0'&&str[index]<='9'))
        {
            index++;
        }
        return start<index;
    }


    public boolean isNumeric2(char[] str) {
        String s = String.valueOf(str);
        return s.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([Ee][\\+-]?[0-9]+)?");
    }


    public boolean isNumeric1(char[] str) {
        //String string=String.valueOf(str);
        //return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
        if(str.length<1)
            return false;
        boolean flag =scanInteger(str);
        if(index <str.length&&str[index]=='.')
        {
            index++;
            flag = scanUnsignedInteger(str)||flag;
        }
        if(index<str.length&&(str[index]=='E'||str[index]=='e'))
        {
            index++;
            flag=flag&&scanInteger(str);
        }
        return flag&&index==str.length;
        // String s = String.valueOf(str);
        // return s.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([Ee][\\+-]?[0-9]+)?");
    }

    private boolean scanInteger(char[]str)
    {
        if(index<str.length&&(str[index]=='+'||str[index]=='-'))
            index++;
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str)
    {
        int start = index;
        while (index<str.length&&str[index]>='0'&&str[index]<='9')
            index++;
        return start<index;//是否存在整数。
    }
}