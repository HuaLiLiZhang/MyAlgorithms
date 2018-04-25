package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/25.
 */
public class elegantPoint {
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        while(sr.hasNext())
        {
            int n = sr.nextInt();
            double r = Math.sqrt(n);
            int count = 0;
            for(int i=0;i<r;i++)
            {
                //for(int j = 0;j<=Math.sqrt(n-i*i);j++)
                //{
                //    if(i*i+j*j==n)
                //    {
                //        if(i==0||j==0)
                //        {
                //            count+=2;
                //        }
                //        else
                //            count+=4;
                //    }
                //}  //运行超时
                //优化1
                double j = Math.sqrt(n-i*i);
                if((int) j==j)
                    count++;
            }
            System.out.println(count<<2);//优化2
        }
        sr.close();
    }
}