package InterviewDirectory.toutiao2019_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/25.
 */
public class maxLengthNoDownSequence {

    //题目描述：小名同学观察了一下室内的PM2.5的值，发现PM2.5以小时为周期循环
    //即任意时刻的PM2.5的值总是和1小时前相等，
    // 若在t小时内采样一些点，选取若干采样的数值，
    // 能否找到一个PM2.5不曾下降的序列，序列长度最大为多少
    //输入：两个整数n,t，n表示采样点数个数，t表示询问t小时过后的结果
    //第二行：n个数字


    //思路：就是求t时间内所有采样点的最大不递减序列的长度。
    //第一种：就是讲n*t时间内的值都存在数组中，在计算最大不递减序列的长度，但是这个空间复杂度大：

    //4 3
//10 3 7 5
    //第二种：就是下面这一种：三层循环，一二层循环表示：对数组进行循环10 3 7 5，超过n的进行区域操作，定位到相应位置k%n，
    //进行动态规划的计数.

    static int []a ;
    static int n ;
    static int [] dp;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int t = sc.nextInt();
        a = new int[n];
        for(int i = 0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        int maxlen = 0;
        dp = new int[n*t];
        for(int i = 0;i<t;i++)
        {
            for(int j = 0;j<n;j++)
            {
                dp[i*n+j] = 1;
                for(int k = 0;k<i*n+j;k++)
                {
                    if(a[k%n]<=a[j])  //k除以n是第几位，应该取余数.
                        dp[i*n+j] = Math.max(dp[i*n+j],dp[k]+1);
                }
                maxlen = Math.max(maxlen,dp[i*n+j]);
            }
        }
        System.out.println(maxlen);
//4 3
//10 3 7 5
//4

//5 3
//10 3 5 7 5
//7

        //这种方法复杂化了：
        //int res = 0;
        //int [] dp = new int[n*t];
        //for(int i = 0; i < n*t; i++)
        //{
        //    dp[i] = 1;
        //    for(int j = 0; j < i; j++)
        //    {
        //        if(a[j] <= a[i])
        //            dp[i] = Math.max(dp[i],dp[j] + 1);
        //    }
        //
        //    res = Math.max(res,dp[i]);
        //}
        //System.out.println(res);

//4 3
//10 3 7 5
//4

//5 3
//10 3 5 7 5
//7
//        n = n*t;
//
//        int lmax=0;
//        for(int i=n-1;i>=1;i--)
//            if(q(i)>lmax) lmax=q(i); //逐个比较求最大
//
//        System.out.println(lmax);


    }

    //public static int theLength(int arr[]) {
    //    int count = 0;
    //    for (int i = 0; i < arr.length - 1; i++) {
    //        int cur_count = 0;
    //        for (int j = i + 1; j < arr.length; j++) {
    //            if (arr[i] < arr[j]) {
    //                cur_count++;
    //            }
    //            if (count < cur_count) {
    //                count = cur_count;
    //            }
    //        }
    //    }
    //    return count;
    //}


    //    static int q(int i){//第i个数字到第n个数字的最长非降数字个数
    //    int j,f,max;
    //    if(i==n)f=1;	//递归出口，如果是第n个数，则为1
    //    else {
    //        max=0;
    //        for(j=i+1;j<n;j++){
    //            if(a[j]>=a[i]&&q(j)>max){//因为a[i]比a[j]小，所以a[i]就可以加入a[j]到a[n]构成的非降序列，长度加一
    //                max=q(j);
    //            }
    //        }
    //        f=max+1;//长度加一
    //    }
    //    return f;
    //}

}