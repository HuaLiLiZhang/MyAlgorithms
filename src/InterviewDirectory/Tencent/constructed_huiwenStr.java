package InterviewDirectory.Tencent;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/16.
 */
public class constructed_huiwenStr {
    //构建回文序列： 最长公共子序列问题，连续，现在解决了连续子序列？
    //public int deleteminNUm(String str)
    //{
    //    if(str==null||str.equals(""))
    //        return 0;
    //    String str1 = reverse(str);
    //
    //    int [][]dp = construted_dp(str, str1);
    //
    //    int max = 0;
    //    for(int i = 0;i<str.length();i++)
    //    {
    //        for(int j=0;j<str1.length();j++)
    //        {
    //            if(dp[i][j] >max)
    //            {
    //                max = dp[i][j];
    //            }
    //        }
    //    }
    //    return str.length()-max;
    //
    //}
    //
    //public String reverse(String str)
    //{
    //    char [] chr = str.toCharArray();
    //    int start = 0;
    //    int end = chr.length-1;
    //    while (start<=end)
    //    {
    //        char temp = chr[start];
    //        chr[start]= chr[end];
    //        chr[end] = temp;
    //        start++;
    //        end--;
    //    }
    //    return String.valueOf(chr);
    //}
    //
    //
    //public int[][] construted_dp(String str, String str1)
    //{
    //    int [][]dp = new int[str.length()][str1.length()] ;
    //    char [] ch1 = str.toCharArray();
    //    char [] ch2 = str1.toCharArray();
    //    for(int j = 0;j<ch1.length;j++)
    //    {
    //        if(ch2[0]==ch1[j])
    //            dp[j][0] = 1;
    //    }
    //    for(int i = 1;i<ch1.length;i++)
    //    {
    //        if(ch2[i]==ch1[0])
    //            dp[0][i] = 1;
    //    }
    //    for(int i =1;i<ch1.length;i++)
    //    {
    //        for(int j = 1;j<ch2.length;j++)
    //        {
    //            if(ch1[i] == ch2[j])
    //                dp[i][j] = dp[i-1][j-1]+1;
    //        }
    //    }
    //    return dp;
    //}

    //翻转字符串，求两个字符串的最长子序列，不连续。是一个字符串是回文序列的最小删除字符数。
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
        String str = sc.nextLine();
        String str1 = new constructed_huiwenStr().reverse(str);
        int [][]dp = new constructed_huiwenStr().construted_dp(str, str1);
        System.out.println(str.length()-dp[str.length()-1][str.length()-1]);
    }
}

    public int deleteminNUm(String str)
    {
        if(str==null||str.equals(""))
            return 0;
        String str1 = reverse(str);

        int [][]dp = construted_dp(str, str1);

        return str.length()-dp[str.length()-1][str.length()-1];

    }

    public String reverse(String str)
    {
        char [] chr = str.toCharArray();
        int start = 0;
        int end = chr.length-1;
        while (start<=end)
        {
            char temp = chr[start];
            chr[start]= chr[end];
            chr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chr);
    }


    public int[][] construted_dp(String str, String str1)
    {
        int [][]dp = new int[str.length()][str1.length()] ;
        char [] ch1 = str.toCharArray();
        char [] ch2 = str1.toCharArray();
        dp[0][0] = ch1[0]==ch2[0]?1:0;

        for(int i = 1;i<ch1.length;i++)
        {
            dp[i][0] = Math.max(dp[i-1][0],ch1[i]==ch2[0]?1:0);
        }
        for(int j = 1;j<ch1.length;j++)
        {
            dp[0][j] = Math.max(dp[0][j-1],ch1[0]==ch2[j]?1:0);
        }
        for(int i =1;i<ch1.length;i++)
        {
            for(int j = 1;j<ch2.length;j++)
            {
                dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                if(ch1[i]==ch2[j])
                    dp[i][j]=Math.max(dp[i][j], dp[i-1][j-1]+1);
            }
        }
        return dp;
    }


}