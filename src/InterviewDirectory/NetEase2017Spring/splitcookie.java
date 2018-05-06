package InterviewDirectory.NetEase2017Spring;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/6.
 */
public class splitcookie {
//    易老师购买了一盒饼干，盒子中一共有k块饼干，
// 但是数字k有些数位变得模糊了，看不清楚数字具体是多少了。
// 易老师需要你帮忙把这k块饼干平分给n个小朋友，易老师保证这盒饼干能平分给n个小朋友。
// 现在你需要计算出k有多少种可能的数值
//输入描述:
//输入包括两行：
// 第一行为盒子上的数值k，模糊的数位用X表示，长度小于18(可能有多个模糊的数位)
// 第二行为小朋友的人数n
//
//
//输出描述:
//输出k可能的数值种数，保证至少为1
//
//输入例子1:
//9999999999999X 3
//
//输出例子1:
//4


    //此方法好像不太容易理解。

    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    String s = sc.next();
    //    int n = sc.nextInt();
    //    long [] dp = new long[n];
    //    dp[0]=1;
    //    for(int i =1;i<=s.length();i++)
    //    {
    //        char c= s.charAt(i-1);
    //        long [] tmp = new long[n];
    //        for(int j = 0;j<n;j++)
    //        {
    //            for(int k=0;k<10;k++)
    //            {
    //                if(c=='X'||c=='0'+k)
    //                {
    //                    tmp[(j*10+k)%n]+=dp[j];
    //                }
    //            }
    //        }
    //        dp = tmp;
    //    }
    //    System.out.println(dp[0]);
    //}




//dp[i][j]表示长度为i的数 除以小朋友的人数之后得到的余数为j的个数
// 
//dp[i][newJ] = dp[i-1][j], s[i] != 'X', newJ = (j*10+s[i]-'0')%n;
// 
//              dp[i-1][j], s[i] == 'X', newJ = (j*10+k)%n, k=0~9

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();

        long[][]dp = new long[s.length()+1][n];
        dp[0][0]=1;
        for(int i =1;i<=s.length();i++)
        {
            for(int j=0;j<n;j++)
            {
                if(s.charAt(i-1)=='X')
                {
                    for(int k =0;k<=9;k++)
                    {
                        int newJ = (j*10+k)%n;
                        dp[i][newJ] += dp[i-1][j];
                    }
                }
                else
                {
                    int newJ = (j*10+s.charAt(i-1)-'0')%n;
                    dp[i][newJ] +=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[s.length()][0]);
    }


}