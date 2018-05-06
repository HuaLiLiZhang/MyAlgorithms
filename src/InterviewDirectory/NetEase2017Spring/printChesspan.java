package InterviewDirectory.NetEase2017Spring;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/5.
 */
public class printChesspan {
    //小易有一块n*n的棋盘，棋盘的每一个格子都为黑色或者白色，小易现在要用他喜欢的红色去涂画棋盘。小易会找出棋盘中某一列中拥有相同颜色的最大的区域去涂画，帮助小易算算他会涂画多少个棋格。
    //输入描述:
    //输入数据包括n+1行：
    // 第一行为一个整数n(1 ≤ n ≤ 50),即棋盘的大小
    // 接下来的n行每行一个字符串表示第i行棋盘的颜色，'W'表示白色，'B'表示黑色
    //
    //
    //输出描述:
    //输出小易会涂画的区域大小
    //
    //输入例子1:
    //3 BWW BBB BWB
    //
    //输出例子1:
    //3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [][] ch = new char[n][n];
        for(int i =0;i<n;i++)
        {
            ch[i] = sc.next().toCharArray();
        }
        int [][] dp = new int [n][n];
        for(int i = 0;i<n;i++)
        {
            dp[0][i] =1;
        }
        int maxcol = 0;
        for(int j= 0;j<n;j++)
        {
            int i=1;
            for(;i<n;i++)
            {
                if(ch[i][j]==ch[i-1][j])
                {
                    dp[i][j] =dp[i-1][j]+1;
                }
                else
                {
                    maxcol = Math.max(maxcol, dp[i-1][j]);
                    dp[i][j] = 1;
                }
            }
            dp[i-1][j] = Math.max(maxcol, dp[i-1][j]);
        }
        int max = dp[n-1][0];
        for(int k = 1;k<n;k++)
        {
            if(dp[n-1][k]>max)
            {
                max = dp[n-1][k];
            }
        }
        System.out.println(max);
    }
}