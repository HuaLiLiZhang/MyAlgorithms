package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/26.
 */
public class reverseX {
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int x = sr.nextInt();
            int y = sr.nextInt();
            System.out.println(rev((rev(x)+rev(y))));
        }
        sr.close();
    }

    public static int rev(int x)
    {
        int yushu = 0;
        String s = "";
        while (x!=0)
        {
            yushu = x%10;
            x = x/10;
            s += String.valueOf(yushu);

        }
        char [] ch = s.toCharArray();
        int i =0;
        for(;i<ch.length;i++)
        {
            if(ch[i]!=0)
                break;
        }
        x = Integer.parseInt(s.substring(i, ch.length));
        return x;
    }

}