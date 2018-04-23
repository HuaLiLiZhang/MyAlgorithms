package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/22.
 */
public class shotGame {
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        int num = sr.nextInt();
        int [] x = new int[num];
        int [] y = new int[num] ;
        for(int i =0;i<num;i++)
        {
            x[i] = sr.nextInt();
        }
        for(int j =0;j<num;j++)
        {
            y[j] = sr.nextInt();
        }
        if(num<=2)
        {
            System.out.println(num);
            return;
        }

        int res =1;

        for(int i=0;i<num;i++)
        {
            for(int j =0;j<num;j++)
            {
                if(i!=j)
                {
                    int dx1= x[j]- x[i];
                    int dy1= y[j]- y[i];
                    for(int k =0;k<num;k++)
                    {
                        int cnt = 0;
                        if(i!=k&&j!=k)
                        {
                            for(int r =0;r<num;r++)
                            {
                                int dx2 = x[r] -x[i];
                                int dy2 = y[r] -y[i];
                                if(dy1*dx2 == dy2*dx1)  //代表平行,也就是跟x[i],y[i]，x[j]，y[j]在一条直线上
                                {
                                    cnt++;
                                }
                                else {
                                    dx2 = x[r] - x[k];
                                    dy2 = y[r] - y[k];
                                    if (dy1 * dy2 == -dx2 * dx1)
                                        //如果不在一条直线上，看看是否在一条垂直线上，两个点r,k代表一条垂直线。
                                        // 代表在垂直的那条线上。
                                    {
                                        cnt++;
                                    }
                                }
                            }
                        }
                        res = Math.max(res, cnt);
                    }
                }
            }
        }
        System.out.println(res);
    }
}