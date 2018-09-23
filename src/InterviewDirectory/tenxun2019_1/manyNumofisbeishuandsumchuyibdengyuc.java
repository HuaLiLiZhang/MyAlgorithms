package InterviewDirectory.tenxun2019_1;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/16.
 */
public class manyNumofisbeishuandsumchuyibdengyuc {
    //是否存在很多数字，两个以上，并且这些数字是a倍数，并且数字的和 除以b 余数为c。
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i<t;i++)
        {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            func(A,B,C);
        }
    }

    private static void func(int a, int b, int c) {
        for(int n = 0;n<=1000;n++)
        {
            for(int m = 1;m<=1000;m++)
            {
                if((c+b*n)==a*m)
                {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}