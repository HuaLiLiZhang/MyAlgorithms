package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/6.
 */
public class addLeastchar_toPalindrome1 {
    //给定一个字符串str，如果可以在str的任意位置添加字符，
    // 请返回在添加字符最少的情况下，让str整体都是回文字符串的结果。


    //原问题。
    // 首先考虑，如果可以在str的任意位置添加字符，最少需要添加几个字符就可以让str整体都是回文字符串。
    // 这个问题可以使用动态规划解决。
    // 如果str的长度为N，生成N×N的dp矩阵，
    // dp[i][j]的含义是子串str[i…j]最少添加几个字符可以使str[i…j]整体都是回文串。
    // dp[i][j]的求法如下：
    //
    //如果i == j，说明此时只有一个字符，本身就是回文串，dp[i][j] = 0。
    //
    //如果str[i…j]有两个字符，如果这个字符相同dp[i][j] = 0。否则dp[i][j] = 1。
    //
    //如果str[i…j]多于两个字母，如果str[i] == str[j]。
    // 则dp[i][j] = dp[i+1][j-1]。
    // 否则，dp[i][j] = min(dp[i+1][j], dp[i][j-1]) + 1。
    // 为什么呢？举例说明，假设str = “ABC”，可以先将“BC”变成回文串“BCB”，
    // 然后在末尾加“A”，也可以先将“AB”变成回文串“ABA”，

    public String getPalindrom1(String str)
    {
        if(str ==null||str.length()<2)
            return str;
        char[] chas = str.toCharArray();
        int [][]dp = getDp(chas);
        char[]res= new char[chas.length+dp[0][chas.length-1]];
        int i =0;
        int j = chas.length-1;
        int resl = 0;
        int resr = res.length-1;
        while (i<=j)
        {
            if(chas[i] == chas[j])
            {
                res[resl++] = chas[i++];
                res[resr--] = chas[j--];
            }else if(dp[i][j-1]<dp[i+1][j])
            {
                res[resl++] = chas[j];
                res[resr--] = chas[j--];
            }else {
                res[resl++] = chas[i];
                res[resr--] = chas[i++];
            }
        }
        return String.valueOf(res);
    }

    public int [][] getDp(char[] str)
    {
        int [][] dp = new int [str.length][str.length];
        for(int j = 1;j<str.length;j++)
        {
            dp[j-1][j] = str[j-1]==str[j] ?0:1;
            for(int i = j-2;i>-1;i--)
            {
                if(str[i]==str[j])
                    dp[i][j] = dp[i+1][j-1];
                else
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
            }
        }
        return dp;
    }



    //第二种方法
    //进阶问题。假设str的长度为N，strlps的长度为M，则整体回文串的长度为2×N - M。
    // 整个过程类似 “剥洋葱”。代码如下：

    public String getPalindrome2(String str, String strlps)
    {
        char[] ch = str.toCharArray();
        char[] lps = strlps.toCharArray();
        char [] res = new char[2*ch.length-lps.length];
        int chl = 0;
        int chr = ch.length-1;
        int lpsl = 0;
        int lpsr = lps.length-1;
        int resl = 0;
        int resr = res.length-1;

        while (lpsl<=lpsr)
        {
            int templ = chl;
            int tempr = chr;
            while (ch[chl]!=lps[lpsl])
                chl++;
            while (ch[chr]!=lps[lpsr])
                chr--;
            set(res, resl,resr, ch, templ, chl, chr, tempr);
            resl+=chl-templ+tempr-chr;
            resr-=chl-templ+tempr-chr;
            res[resl++] = ch[chl++];  //对应结果字符串数组中，指定到下一个位置
            res[resr--] = ch[chr--];
            lpsl++;
            lpsr--;
        }
        return String.valueOf(res);
    }

    public void set(char[]res, int resl ,int resr, char[]ch, int chls, int chle, int chrs, int chre)
    {
        for(int i = chls;i<chle;i++)
        {
            res[resl++] = ch[i];
            res[resr--] = ch[i];
        }
        for (int i=chre;i>chrs;i--)
        {
            res[resl++] = ch[i];
            res[resr--] = ch[i];
        }
    }

}
