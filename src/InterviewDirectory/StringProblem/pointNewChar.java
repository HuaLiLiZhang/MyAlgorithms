package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/8.
 */
public class pointNewChar {
    //找到被指定的新类型。新类型的格式：1个或者两个字符。
    //小写字母 'g'，大写字母+小写字母，'Ac'大写字母+大写字母。 AC

    public String pointnewchar1(String str, int k )
    {
        if(str==null||str.equals("")||k<0||k>=str.length())
            return "";
        char [] ch = str.toCharArray();
        int unum=0;
        for(int i = k-1;i>=0;i--)
        {
            if(!Character.isUpperCase(ch[i]))   //找出K之前有多少个连续的大写字母。
                break;                           //.... k-3, k-2 ,k-1
            unum++;
        }
        //if(unum/2==0)
        //{
        //    if(Character.isUpperCase(ch[k]))
        //        return str.substring(k,k+2);
        //    else
        //        return str.substring(k, k+1);
        //}else
        //{
        //    return str.substring(k-1,k+1);
        //}
        if((unum&1)==1)  //如果有奇数个，返回k-1 ,和k的位置上的字符
            return str.substring(k-1, k+1);
        if(Character.isUpperCase(ch[k]))  //如果是偶数个大写字母，再次判断ch[k]是大写字母还是小写字母。
            //如果是大写字母，直接返回k,和k+1的字符。
            return str.substring(k, k+2);
        return String.valueOf(ch[k]);  //如果是小写字母，直接返回k位置上的字符。
    }

}