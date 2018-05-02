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

    //思路：
//
//dp[i][j] = (dp[i - 1][j - 1] * (i - j) + dp[i - 1][j] * (j + 1)) % 2017;
//dp[i][j]表示有i个数字及j个小于号所能组成的数量(大于号数量当然是i - j - 1次，后面需要使用)
//而加入第i + 1个数字时，分以下四种情况：
//1.如果将i+1插入当前序列的开头，即有了1<2，加入后成为3>1<2，会发现等于同时加入了一个大于号！(此时可以无视1与2之间的关系，因为i+1>i)
//2.如果将i+1插入当前序列末尾,即1<2变成了 1<2<3，会发现等于同时加入了一个小于号！ (此时可以无视1与2之间的关系，因为i+1>i)
//3.如果将i+1加入一个小于号之间，即已经有 1<2了，向中间加入3,会发现变成了1<3>2，等于同时加入了一个大于号！
//4.如果将i+1加入一个大于号中间，即有了2>1，变成了2<3>1，等于同时加入了一个小于号！
//综上所述，dp[i][j]等于以上四种情况之和：
//dp[i - 1][j] 将i加在开头等于加入一个大于号，即要求i-1个数时已经有了j个小于号
//dp[i - 1][j - 1] 将i加在末尾等于加入一个小于号，即要求i-1个数时已经有了j-1个小于号
//dp[i - 1][j] * j 将i加在任意一个小于号之间，等于加入了一个大于号；即要求i-1个数时已经有了j个小于号，每个小于号都可以进行这样的一次插入
//dp[i - 1][j - 1] * (i- j - 1) 将i加载任意一个大于号之间，等于加入了一个小于号；即要求i-1个数时有了j-1个小于号，而此时共有
//(i - 1) - (j - 1)- 1个大于号，每个大于号都要进行一次这样的操作合并同类项即为
//dp[i][j] = (dp[i - 1][j - 1] * (i - j) + dp[i - 1][j] * (j + 1))
//最后要记得取模
}