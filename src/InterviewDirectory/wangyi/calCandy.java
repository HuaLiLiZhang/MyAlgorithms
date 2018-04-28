package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/28.
 */
public class calCandy {
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int m = sr.nextInt();
        int p = sr.nextInt();
        int q = sr.nextInt();
        int a = (n+p)/2;
        int b = (m+q)/2;
        int c = q - b;
        if((a+b)==p&&(a-b)==n)
            System.out.println(a+" "+b+" "+c);
        else
            System.out.println("No");
        
    }
}