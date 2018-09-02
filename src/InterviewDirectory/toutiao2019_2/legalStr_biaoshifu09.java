package InterviewDirectory.toutiao2019_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/25.
 */
public class legalStr_biaoshifu09 {
    //合法的标识符:数组0-9组成的字符串。（可以包含多个前导0）、
    //定义合法的表达式：
    //1.若X为合法的标识符，则X为合法的表达式
    //2.若X为合法的标识符，则（X）为合法的表达式
    //3.若X和Y均为合法的表达式，则X+Y，X-Y均为合法的表达式
    //一下表达式均合法：1,100,1+1,(10) 1-(3-2)
    //一下表达式不合法：(,-1,1+-2

    //输入：给定长度的n，输出长度为n的合法表达式的数目，结果对1000000007取余。
    //例如  输入 ：1 ，输出 ：10（0-9）个数

    //思路：
    //动态规划求解， dp[i]表示长度为i的合法字符串，
    // dp2[i]表示长度为i的符合以下两种形式的的合法表达式， 形式一：全是数字， 形式二： (合法表达式)，
    // 维护dp[i]的时候，考虑最后一个加号或者减号出现的位置j，
    // dp[i]加上2LL*dp[j]*dp2[i-1-j]，因为枚举的是最后一个加减号的位置，
    // 因此右边只能是全数字或者(合法表达式)。
    // 为什么要枚举最后一个加减号，就是为了避免重复计算，
    // 例如1+2+3，如果不枚举最后一个加号，当枚举到1+2的加号时，左边1和右边2+3可行，
    // 当枚举到2+3的加号时，左边1+2和右边3也可行，这样1+2+3会被计算两次。

    //测试用例：
    // 1
    //10
    //2
    //100
    //3
    //1210
    //4
    //14100
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int n = sc.nextInt();
            int mod = 1000000007;
            long [] dp = new long[1010];
            long [] f = new long[1010];
            long [] dp2 = new long[1010];
            f[0] = 1;
            for(int i = 1;i<=1000;i++)
            {
                f[i] = 10*f[i-1]%mod;  //f[i]计算i位都是数字的情况。
            }
            dp2[0] = dp[0] = 0;
            dp2[1] = dp[1] = 10;
            for(int i = 2;i<=n;i++)
            {
                dp[i] = dp[i-2]; // 代表括号表达式，要去掉两位嘛，
                dp[i] = (dp[i]+f[i])%mod;  //
                //首先：dp2[i]=dp[i-2]+f[i]，这很好理解，
                // dp2[i]表示形如：(1)(合法表达式)或(2)全数字表达式 长度为i的表达式个数。
                dp2[i] = dp[i]; //dp2[i]表示形如：(1)(合法表达式)或(2)全数字表达式 长度为i的表达式个数。
                for(int j=1;j<i;j++)
                {
                    //其次是：dp[i]的计算。dp[i]包括
                    // (1)dp2[i]
                    // (2)合法表达式+合法表达式
                    // (3)合法表达式-合法表达式 三部分组成，
                    // 所以dp[i]一开始等于dp2[i]，然后在此基础上加上(2)和(3)两种形式。
                    dp[i] = (dp[i]+2*dp[j]*dp[i-1-j])%mod;
                }
            }

            System.out.println(dp[n]);
        }
    }


//    另外一种思路：
//    这段代码中dp[i]表示以数字结尾的合法字符串；
// dp2[i]表示以括号结尾的合法字符串大概是这种形式：(合法表达式)，而不是我们(合法表达式)+(合法表达式)的形式。
//因此在递推dp2[i]时，需要考虑括号中间有类似 (合法表达式)+(合法表达式)的形式，
// 这部分就是固定最后一个加号或减号遍历，和解法一的思路一样，代码中就是dp2[i] += (2*b*d)%1000000007;

    /*public static void main(String[] args)
    {
        long dp[] = new long[1002];//存以数字结尾的合法表达式
        long dp2[] = new long[1002];//存以括号结尾的合法表达式
        int a;
        Scanner sc = new Scanner(System.in);
        Arrays.fill(dp,0);
        Arrays.fill(dp2,0);
        dp[0] = 0;
        dp[1] = 10;
        dp[2] = 100;
        dp[3] = 200+1000;
        dp2[0] = 0;
        dp2[1] = 0;
        dp2[2] = 0;
        dp2[3] = 10;
        while(sc.hasNext())//注意while处理多个case
        {
            a = sc.nextInt();
            //dp2
            for(int i = 4;i<=a;i++)
            {
                for(int j = i-2;j>=3;j--)
                {
                    long d = (dp[i-j-1]+dp2[i-j-1])%1000000007;
                    long b = (dp[j-2]+dp2[j-2])%1000000007;
                    dp2[i] += (2*b*d)%1000000007;
                }
                dp2[i] += (dp[i-2]+dp2[i-2])%1000000007;
                dp[i] = (dp[i-1] + 2*(dp[i-2]+dp2[i-2]))*10%1000000007;
            }

            System.out.println(((dp[a]+dp2[a])%1000000007));
        }
    }*/

}