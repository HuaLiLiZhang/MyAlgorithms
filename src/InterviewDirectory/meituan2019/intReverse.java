package InterviewDirectory.meituan2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/7.
 */
public class intReverse {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long i = 0;
        long t = sc.nextInt();
        while (t!=0)
        {
            i = 10*i+(t%10);
            t/=10;
        }
        if(i<Integer.MIN_VALUE||i>Integer.MAX_VALUE)
        {
            System.out.println(0);
        }
        System.out.println(i);
    }
}