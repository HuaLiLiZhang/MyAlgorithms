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
// dp[i][j]表示前i位（高位开始）余数为j的个数
        long[][]dp = new long[s.length()+1][n];
        dp[0][0]=1;


////前i-1字符串组成的整数 除n得的余数为j的情况有dp[i - 1][j]种，余数只能在0到n-1的范围
////假设前i-1字符串组成的数是125，n=4，余数为125 % 4 = 1，
////所以dp[3][0]=0,dp[3][1]=1,dp[3][2]=0,dp[3][3] = 0
////假设第i个字符为6，所以新的数变成1256，1256 % n就相当于(125 * 10 + 6) % n
////相当于[(124 + 1)*10 + 6] % n,因为前i-1个组成的数中125 % n = 1，所以(125 - 1) * 10是能除尽n的
////所以就相当于[(1 * 10) + 6] % n ,而 1 就是前i-1个组成的数除n得到的余数，所以前i-1个组成的数除n有多少个余
////数为1的情况，那么前i个组成的数就有多少种余数为[(1*10) + 6] % n 的情况。
////for(int j = 0; j < n; j++) 此for循环中的j代表前i-1个组成的数除n得到的余数，余数从0到n-1
        for(int i =1;i<=s.length();i++)
        {
            for(int j=0;j<n;j++)
            {
                if(s.charAt(i-1)=='X')  // 如果当前位为X，用0-9带入
                {
                    for(int k =0;k<=9;k++)
                    {
                        int newJ = (j*10+k)%n;
                        dp[i][newJ] += dp[i-1][j];
                    }
                }
                else
                { // 如果当前位上的数字为不为X，用具体值带入
                    int newJ = (j*10+s.charAt(i-1)-'0')%n;
                    dp[i][newJ] +=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[s.length()][0]);
    }


}