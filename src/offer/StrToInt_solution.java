package offer;

/**
 * Created by huali on 2018/7/1.
 */
public class StrToInt_solution {
    public int StrToInt(String str) {
        if(str.equals("")||str.length()==0)
        {
            return 0;
        }
        int symbol = 0;
        int start = 0;
        int result = 0;
        if(str.charAt(0)=='+')
            start=1;
        else if (str.charAt(0)=='-')
        {
            start = 1;
            symbol=1;
        }
        for(int i=start;i<str.length();i++)
        {
            if(str.charAt(i)>'9'||str.charAt(i)<'0')
                return 0;
            int sum = result*10+(int) (str.charAt(i)-'0');
            if((sum-(int) (str.charAt(i)-'0'))/10!=result)
                return 0;
            result = result*10+(int) (str.charAt(i)-'0');
        }
        result = (int)Math.pow(-1,symbol)*result;
        return result;
    }

    public static boolean flag;
    public int StrToInt1(String str) {
        flag=false;
        //判断是否是合法输入
        //String.trim():返回字符串的副本，忽略前导空白和尾部空白。
        if(str==null||str.trim().equals(""))
        {
            flag=true;
            return 0;
        }
        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        //是符号位，start都为1.不是为0.
        int symbol = 0;
        int start = 0;
        char [] chars = str.trim().toCharArray();
        if(chars[0]=='+')
            start=1;
        else if(chars[0]=='-')
        {
            start=1;
            symbol=1;
        }
        //result存储结果
        int result = 0;
        for(int i=start;i<chars.length;++i) //从符号位开始遍历。
        {
            if(chars[i]>'9'||chars[i]<'0')
            {//如果遇到0-9以外的字符，返回0，
                flag=true;
                return 0;
            }

            int sum = result*10 +(int)(chars[i]-'0');
            if((sum-(int)(chars[i]-'0'))/10!=result)
            {
                flag=true;
                return 0;
            }  //这一句虽然不加也可以通过，但是这一句是判断是否溢出的标志，
            //如果数值太大，超过int最大值，那么就变为负数，(sum-(int)(chars[i]-'0'))/10!=result
            //这一句就成立了。要返回0
            result=result*10+(int)(chars[i]-'0');
        }
        result = (int)Math.pow(-1,symbol)*result;
        return  result;
    }
}