package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/20.
 */
public class StringFragment {
    public static  void  main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            String str = sr.next();
            if(!Isvalid(str))
                break;
            int length = str.length();
            char[]ch  = str.toCharArray();
            int count =0;
            for(int i =0;i<length;i++)
            {
                while (i<length-1&&ch[i]==ch[i+1])
                    i++;
                count++;
            }
            //count++;
            System.out.printf("%.2f", (float)length/count);
        }
    }
    public static boolean Isvalid(String str)
    {
        if (str.length()<1||str.length()>50)
            return false;
        String s = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        char [] ch = s.toCharArray();
        for(int i =0;i<ch.length;i++)
        {
            if(str.contains(String.valueOf(ch[i])))
                return false;
        }
        return true;
    }
}