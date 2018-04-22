package InterviewDirectory.wangyi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by huali on 2018/4/22.
 */
public class Rerange_sequence {
    public static void main(String []argz)
    {
        Scanner sr = new Scanner(System.in);
        String s = sr.nextLine();
        char [] c = s.toCharArray();
        int len = c.length;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i =0;i<len;i++)
        {
            String s1 = s.substring(0,i);
            String s2 = s.substring(i+1,len);
            String s3 = s1+s2;
            for(int j=0;j<len;j++)
            {
                String b1 = s3.substring(0,j);
                String b2 = s3.substring(j, len-1);
                String e = String.valueOf(c[i]);
                String ss = b1+e+b2;
                if (ss.equals(s))
                    continue;
                else
                    {
                    if (isValid(ss))
                        map.put(ss, 1);
                    }
            }
        }
        System.out.println(map.size());

    }
    public static boolean isValid(String str)
    {
        if(str==null||str.equals(""))
            return false;
        char [] chs = str.toCharArray();
        int status = 0;
        for(int i =0;i<chs.length;i++)
        {
            if(chs[i]!=')'&&chs[i]!='(')
                return false;
            if(chs[i]==')'&&--status<0)
                return false;
            if(chs[i]=='(')
                status++;
        }
        return status==0;
    }
}