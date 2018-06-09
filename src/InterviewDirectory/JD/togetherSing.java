package InterviewDirectory.JD;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/29.
 */
public class togetherSing {
//    小Q和牛博士合唱一首歌曲,这首歌曲由n个音调组成,每个音调由一个正整数表示。
//对于每个音调要么由小Q演唱要么由牛博士演唱,对于一系列音调演唱的难度等于所有相邻音调变化幅度之和,
// 例如一个音调序列是8, 8, 13, 12,
// 那么它的难度等于|8 - 8| + |13 - 8| + |12 - 13| = 6(其中||表示绝对值)。
//现在要对把这n个音调分配给小Q或牛博士,让他们演唱的难度之和最小,请你算算最小的难度和是多少。
//如样例所示: 小Q选择演唱{5, 6}难度为1, 牛博士选择演唱{1, 2, 1}难度为2,难度之和为3,
// 这一个是最小难度和的方案了。

    public static void main(String[]args)
    {
        Scanner sr =new Scanner(System.in);
        while (sr.hasNext())
        {
            int n= sr.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sr.nextInt();
            }
            if(n>2000||n<1)
                break;
            if(n<3)  //n小于3的话，只有两个，一个人分担一个，就没有音差了。
                System.out.println("0");
            else
            {
                int []acc = new int[n];
                int [][]dp = new int[n][n];
                dp[0][0] = 0-Math.abs(arr[1]-arr[0]);
                for(int i=1;i<n;i++)
                {
                    acc[i] = Math.abs(arr[i]-arr[i-1])+acc[i-1];
                    dp[i][i-1] = acc[i-1];
                    for(int K=0;K<i-1;K++)
                    {
                        dp[i][K] = dp[i-1][K]+acc[i]-acc[i-1];
                        dp[i][i-1] = Math.min(dp[i][i-1], dp[i-1][K]+Math.abs(arr[i]-arr[K]));
                    }
                }
                int min = Integer.MAX_VALUE;
                for(int j=0;j<n-1;j++)
                {
                    min = Math.min(min, dp[n-1][j]);
                }
                System.out.println(min);
            }
        }
        sr.close();
    }
}