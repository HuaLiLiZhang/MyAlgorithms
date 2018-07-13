package InterviewDirectory.JD2017;

import java.util.Scanner;

/**
 * Created by huali on 2018/7/13.
 */
public class hexsumMeanvalue {
    public static void main(String[] args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int a = sr.nextInt();
            int sum = 0;
            for(int i=2;i<=a-1;i++)
            {
                sum+=hexsum(a, i);
            }
            int r = yueshu(sum, a-2);
            System.out.print(sum/r+"/"+(a-2)/r);
        }
    }

    private static int yueshu(int a1, int a2) {
        int r = 1;
        for(int i = 2;i<=Math.max(a1,a2);i++)
        {
            if(a1%i==0&&a2%i==0)
                r = Math.max(r, i);
        }
        return r;
    }

    private static int hexsum(int a, int i) {
        int sum = 0;
        while (a!=0)
        {
            sum+=(a%i);
            a = a/i;
        }
        return sum;
    }
}