package InterviewDirectory.pingduoduo2019_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/30.
 */
public class Main3 {
    static int max = (int) Math.pow(10,6)+10;
    static int [] ok = new int[max];
    public static void main(String[] args)
    {
        Scanner sc  =new Scanner(System.in);
        Arrays.fill(ok,-1);
        int b = sc.nextInt();
        int a = sc.nextInt();
        b= b%a;
        int n  = 0;
        int c,d;
        while (true)
        {
            if(b==0)
            {
                c=n;
                d= 0;
                break;
            }
            if(ok[b]!=-1)
            {
                c= ok[b];
                d = n-c;
                break;
            }
            ok[b] = n;
            n++;
            b = (b*10)%a;
        }
        System.out.printf("%d %d\n",c,d);
    }

}