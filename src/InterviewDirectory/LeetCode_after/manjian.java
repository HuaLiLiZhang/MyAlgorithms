package InterviewDirectory.LeetCode_after;

import InterviewDirectory.huawei2016.num;

import java.util.Scanner;

/**
 * Created by huali on 2018/10/9.
 */
public class manjian {
    //促销中“满X优惠”问题的两种解法：动态规划和枚举法

    //问题描述：给定一个无序数组int num[n]，
    // 其中放的是n中商品的价格，商家规定满m元有优惠，商品不重复购买，
    // 那么从买家的角度看如何购买才能既享受优惠又花最少钱？
    //问题分析：抽象成数学问题就是，从数组中取出若干个元素，使得它们之和sum为大于等于m的最小值。
    // 下面我分别从枚举法和动态规划角度介绍求解思路与代码。
    //1、枚举法
    //可能，我们最先想到的就是枚举法，n种商品一共有2^n中可能，
    // 分别计算出每种可能的和，再找出满足条件的。先贴代码，然后解释。Java代码如下：
    //
    /*public static int ToXDiscount(int[] num, int m){
        int n = num.length;
        int sum = 0, ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            sum += num[i];
        }
        if(sum < m){
            return -1;
        }
        else if(sum == m){
            return m;
        }

        for(int s=1; s<(1<<n); s++){ //1<=s<1024
        //s记录位数，就是选择数组中的哪几位
            int t = 0;
            for(int j=0; j<n; j++){
                if(((s>>j)&1) != 0){  //s的位置上为1那么相加
                    t = t + num[j];
                }
            }
            //判断这些位置的和是否大于ans，如果大于，去最小值。
            if(t>=m && t<ans){
                ans = t;
            }
        }
        return ans;
    }*/

    //
    //2、动态规划法
    //这是一个与0-1背包类似的问题，
    // 设二维数组dp[n+1][sum+1]中的任一项为dp[j][k]—从num[j],num[j+1],…,num[n-1]中任取若干个，
    // 它们之和不超过k的最大值。java代码如下：
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int X = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println(DPXDisc(arr,X));
    }

    public static int DPXDisc(int[] num, int m){
        int n = num.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += num[i];
        }
        if(sum < m) {
            return -1;
        }else if(sum == m){
            return m;
        }

        int[][] dp = new int[n+1][sum+1];
        for(int i=m; i<=sum; i++){
            for(int j=n-1; j>=0; j--){
                for(int k=0; k<=i; k++){
                    if(num[j] > k){
                        dp[j][k] = dp[j+1][k];
                        //任一项为dp[j][k]—从num[j],num[j+1],…,num[n-1]中任取若干个，它们之和不超过k的最大值
                    //    如果num[j] > k，那么dp[j][k] 不取
                    }
                    else{
                        dp[j][k] = Math.max(dp[j+1][k],dp[j+1][k-num[j]]+num[j]);
                    }
                }
            }
            if(dp[0][i] == i){
                return i;
            }
        }
        return sum;
    }

//    i从m逐步递增至sum过程中，一定会有一个i0使得：dp[0][i0]==i0，
// 即从num[0],num[1],…,num[n-1]中任取若干个元素，它们之和等于i0，
// 并且最早出现的这样的i0就一定是大于等于m的最小值。此时，程序停止，返回i0.

}