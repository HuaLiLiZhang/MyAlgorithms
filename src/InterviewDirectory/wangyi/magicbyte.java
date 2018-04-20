package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/20.
 */
public class magicbyte {
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int num = sr.nextInt();
            StringBuffer str = new StringBuffer();
            if(num<1)
                break;
            while (num!=0)
            {
                if(num==1)
                {
                    str.append("1");
                    break;
                }else if (num==2)
                {
                    str.append("2");
                    break;
                }
                if(num%2==0)
                {
                    num = num/2-1;
                    str.append("2");
                }else {
                    num = (num-1)/2;
                    str.append("1");
                }
            }
            System.out.println(str.reverse().toString());
        }
        sr.close();
    }
}