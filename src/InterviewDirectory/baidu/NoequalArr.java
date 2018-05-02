package InterviewDirectory.baidu;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/1.
 */
public class NoequalArr {
    static int dp[][];

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        dp = new int[n][k+1];

        for(int i = 1;i<n;i++){
            dp[i][0] = 1;      //初始化，i个数子女，0个小于号。没有小于号只能顺序排列，只有一中方法
        }

        System.out.print(permutationAmount(n,k));
    }

    public static int permutationAmount(int n ,int k){
        if(n == 2 && k == 0){
            dp[n-1][k] = 1;
            return dp[n-1][k];  //没有小于号只能顺序排列，只有一中方法
        }
        if(n == 2 && k == 1){
            dp[n-1][k] = 1;
            return dp[n-1][k];//两个数，只有一个小于号，也只有一中方法。
        }

        if(n<=k)
            return 0;
        if(dp[n-1][k] != 0)   //小于号大于1的个数，如果不等于0，辣么返回。
            return dp[n-1][k];

        dp[n-1][k] = (permutationAmount(n-1,k-1)*(n-k)+permutationAmount(n-1,k)*(k+1))%2017;

        return dp[n-1][k];
    }
}