package InterviewDirectory.baidu2016;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/6/2.
 */
public class Mushroomarray {
//    现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线，在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
//
//输入描述:
//第一行N，M，K(1 ≤ N,M ≤ 20, k ≤ 100),N,M为草地大小，接下来K行，每行两个整数x，y，代表(x,y)处有一个蘑菇。
//
//
//输出描述:
//输出一行，代表所求概率(保留到2位小数)
//
//输入例子1:
//2 2 1
//2 1
//
//输出例子1:
//0.50
public static void main(String[]args)
{
    Scanner sr = new Scanner(System.in);

    while (sr.hasNext()) {
        int N = sr.nextInt();
        int M= sr.nextInt();
        int K = sr.nextInt();
        boolean [][]arr = new boolean[N][M];
        for(int i=0;i<K;i++)
        {
            int x = sr.nextInt();
            int y = sr.nextInt();
            arr[x-1][y-1] = true;
        }
        //boolean smallColumn = M<N;
        //int small = Math.min(N, M);
        //int big = Math.max(N, M);
        //float[] dp = new float[small];
        //for(int i=big-1;i>=0;i--)
        //{
        //    for(int j=small-1;j>=0;j--)
        //    {
        //        if(smallColumn?arr[i][j]:arr[j][i])
        //            dp[j]=0;
        //        else {
        //            if(i==big-1&&j==small-1)
        //            {
        //                dp[j]=1;
        //            }
        //            else if(i==big-1)
        //            {
        //                dp[j]=dp[j+1];
        //            }
        //            else if(j==small-1)
        //            {
        //
        //            }
        //            else
        //            {
        //                dp[j] = (float) (0.5*(dp[j]+dp[j+1]));
        //            }
        //        }
        //    }
        //}
        //System.out.println(String.format("%.2f",dp[0]));










        double[][]dp = new double[N+1][M+1];
        int i,j;
        for(i = 1; i <= N; ++i){
            for(j = 1; j <= M; ++j){
                if(i == 1 && j == 1) {
                    dp[1][1] = 1;
                    continue;
                }
                if(arr[i-1][j-1]) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i == N && j == M) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    continue;
                }
                if(i == N) {
                    dp[i][j] = dp[i-1][j]*0.5 + dp[i][j-1];
                    continue;
                }
                if(j == M) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]*0.5;
                    continue;
                }
                if(i == 1) {
                    dp[i][j] = dp[i][j-1]*0.5;
                    continue;
                }
                if(j == 1) {
                    dp[i][j] = dp[i-1][j]*0.5;
                    continue;}

                dp[i][j] = dp[i][j-1]*0.5 + dp[i-1][j]*0.5;
            }
        }
        System.out.println(String.format("%.2f", dp[N][M]) );

    }
    sr.close();
    }

}