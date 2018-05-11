package InterviewDirectory.netEASe2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/11.
 */
public class n_n_min {
//    任意2n个整数，从其中选出n个整数，使得选出的n个整数和同剩下的n个整数之和的差最小。

//    8 1 1 9 9 9 9 14 20这个测试用例据挂掉了。
//    72
//[14, 9, 9, 1]
//33
//39、

//    本应该：{9,9,9,9}  {1, 1 ,14, 20}

//    public static void main(String []args)
//    {
//        Scanner sr = new Scanner(System.in);
//        int num = sr.nextInt();
//        int []arr = new int[num];
//        int sum = 0;
//        for(int i=0;i<num;i++)
//        {
//            arr[i] = sr.nextInt();
//            sum+=arr[i];
//        }
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        int []a = new int[num/2];
//        int []b = new int[num/2];
//
//        a[0] = arr[num-1];
//        b[0] = arr[num-2];
//        int suma = a[0];
//        int sumb = b[0];
//        int counta = 1;
//        int countb = 1;
//        for(int i=num-3;i>=0;i--)
//        {
//            if(suma>=sumb)
//            {
//                if(countb==num/2)
//                    break;
//                b[countb] = arr[i];
//                countb++;
//                sumb+=arr[i];
//            }
//            else
//            {
//                if(counta==num/2)
//                    break;
//                a[counta] = arr[i];
//                counta++;
//                suma+=arr[i];
//            }
//        }
//
//        System.out.println(sum);
//        if(countb==num/2) {
//            System.out.println(Arrays.toString(b));
//            System.out.println(sumb);
//            System.out.println(sum-sumb);
//        }
//        if(counta==num/2) {
//            System.out.println(Arrays.toString(a));
//            System.out.println(suma);
//            System.out.println(sum-suma);
//        }
//
//    }


//    要用回溯
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        int N = sr.nextInt();
        int []arr = new int[N*2];
        int sum = 0;
        for(int i=0;i<N*2;i++)
        {
            arr[i] = sr.nextInt();
            sum+=arr[i];
        }
        //System.out.println(sum);
        //类似于叠高塔问题。N个砖头，叠两堆和的差最小的两堆塔。
        int [][] dp = new int[N+1][sum/2+2];
        for (int i = 0 ; i <= 2*N-1 ; ++i)  //2N个元素 0——2N-1
        {
            for (int j = Math.min(i,N) ; j >= 1 ; --j)  //i 从1 开始，i<=N时，j等于i 。i>N时候，j等于N
            {
                for (int s = sum/2+1 ; s >= arr[i] ; --s)  //总共有2N个元素，所以要进行2N次
                {
                    dp[j][s] = Math.max(dp[j-1][s-arr[i]]+arr[i] , dp[j][s]);
                }
            }
        }
        System.out.println(sum);
        System.out.println(Math.min(dp[N][sum/2+1], sum - dp[N][sum/2+1]));
        System.out.println(Math.max(dp[N][sum/2+1], sum - dp[N][sum/2+1]));
    }



}