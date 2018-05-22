package InterviewDirectory.NetEase;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/21.
 */
public class Fibonacci {
//    Fibonacci数列是这样定义的：
//F[0] = 0
//F[1] = 1
//for each i ≥ 2: F[i] = F[i-1] + F[i-2]
//因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，
// 在Fibonacci数列中的数我们称为Fibonacci数。
// 给你一个N，你想让其变为一个Fibonacci数，
// 每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
//输入描述:
//输入为一个正整数N(1 ≤ N ≤ 1,000,000)
//
//
//输出描述:
//输出一个最小的步数变为Fibonacci数"
//
//输入例子1:
//15
//
//输出例子1:
//2

    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int n = sr.nextInt();
            int f1 = 0;
            int f2 = 1;
            int f3 ;
            while (true)
            {
                f3 = f2+f1;
                if(f3>=n)
                    break;
                f1 = f2;
                f2 = f3;

            }
            int count = n-f2>f3-n?f3-n:n-f2;
            System.out.println(count);

        }
        sr.close();

    }
}