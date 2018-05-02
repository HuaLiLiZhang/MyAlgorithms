package InterviewDirectory.NetEase;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/2.
 */
public class Staggered01string {
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
           String str = sr.next();
           int maxlen = 1;
           int len = 1;
           for(int i =1;i<str.length();i++)
           {
               if(str.charAt(i-1)!=str.charAt(i))
               {
                   len++;
                   if(len>maxlen)
                       maxlen=len;
               }
               else
                   len =1;
           }
            System.out.println(maxlen);
        }
        sr.close();


    }
}