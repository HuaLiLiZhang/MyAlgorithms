package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/28.
 */
public class BuyApple {
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int min =Integer.MAX_VALUE;
        for(int i = 0;i<=n/6;i++)
        {
            for(int j = 0;j<=(n-6*i)/8;j++)
            {
                if(i*6+j*8==n)
                {
                    if(min>(i+j))
                        min = i+j;
                }

            }
        }
        if(min==Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(min);
    }
}