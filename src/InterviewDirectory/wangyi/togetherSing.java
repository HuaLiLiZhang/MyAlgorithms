package InterviewDirectory.wangyi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/4/23.
 */
public class togetherSing {
    //动态规划题
    //
    //1.dp[i][j]（永远有i > j）表示某一个人最近唱的音为第i个，另一个人最近唱的是第j个时最小的难度
    //2. 由于只由一个人唱完肯定不是最优解。因此先在一个for循环内确定以下两种情况的初值
    //          dp[i][0]：第二个人唱第一个音，第一个人唱后面所有音
    //          dp[i][i-1]：第一个人唱最近的一个音，第二个人唱前面所有音
    //3.dp[i][j]转移方程
    //      每当交换唱歌次序，两人最近一次唱的音符一定是相邻的，所以底下分相邻和不相邻讨论：
    //(1). 当j == i - 1，即交换唱歌次序，dp[i][i-1]时，表明第一个人上一个音可能在第k个音（0 <= k < i-1）,由唱了最近的第i个，第二个人仍然留在第i-1个音。
    //dp[i][i-1] = 对所有k求min(dp[i-1][k] + abs(arr[i] - arr[k]) ) 其中（0 <= k < i-1）
    //(2). 当j < i - 1，即不交换唱歌次序时，只可能由唱到i-1音符的人续唱
    //dp[i][j] = dp[i-1][j] + abs(arr[i] - arr[i-1])
    //
    //最后求出所有dp[len-1][]里的最小值即为全局最优解
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int n = sr.nextInt();
            int []arr = new int[n];
            for(int i =0 ;i<n;i++)
                arr[i] = sr.nextInt();
            if(n>2000||n<1)
                break;
            if(n<3)  //n小于3的话，只有两个，一个人分担一个，就没有音差了。
                System.out.println("0");
            else
            {
                int []acc = new int[n];
                int [][] dp = new int [n][n];
                dp[0][0] = 0-Math.abs(arr[1]-arr[0]);

                for(int i = 1;i<n;i++)
                {
                    acc[i] = acc[i-1]+Math.abs(arr[i]-arr[i-1]);   //acc代表总难度增加总和。
                    // //第一个人只唱了第i个音符，第二个人唱了【0，i-1】的音符，
                    //所以第一个人难度为0，第二个人难度为【0，i-1】的累计难度，即acc[i-1]
                    dp[i][i-1] = acc[i-1];
                    for(int j=0;j<i-1;j++)
                    {
                        //a:当 j=i-1 时 例如: dp[4][3]（3=4-1）
                        // 则若小Q当前弹的是第4个音调，牛博士此前刚弹完的是第3个音调，
                        // 那么小Q之前弹的音调的可能情况有：2、 1、 0  （或者一个也没弹）四种可能，
                        // 那么dp[4][3]= min(dp[3][2],dp[3][1],dp[3][0]，一个音也没弹过)。
                        //
                        //b:当 j!=i-1时，则dp[i][j]一定是由dp[i-1][j]转移得到的，
                        // 譬如说：dp[4][2] 一定是由dp[3][2] 转移得到的，因为牛博士此前刚弹完的是第2个音调，
                        // 而小Q当前要弹的是第4个音调，那么小Q之前弹的音调一定是第3个音调。
                        dp[i][j] = dp[i-1][j] + acc[i] -acc[i-1];//当j<i-1时
                        dp[i][i-1] = Math.min(dp[i][i-1], dp[i-1][j]+Math.abs(arr[i]-arr[j]));
                        //当j=i-1的情况，用j代表之前公式中的k
                        //不用再写一个for循环去遍历k找最小的难度，优化代码，就是思维有点跳跃
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

        //ThreadLocal t1 = new ThreadLocal();
    //    泛型
    //    List<String> list = new LinkedList<>();
    //    List<Object> list1 = new LinkedList<>();
        //list1 = list;//编译错误，不能，因为两边都有泛型且指定的类型不相同
    //    解决办法：
        //
        //方法一:从 LinkedList<string>逐个取值,添加到LinkedList<Object> 里.
        //
        //方法二:去掉其中任意1个List的泛型
        //方法三:把LinkedList<Object>修改成LinkedList<? extends Object>
        //
        //方法四: 创建LinedList<Object>时,把 LinkedList<string>list1作为参数传进去

        //Object o = list;  //可以赋值给一个object的变量。


    }



}