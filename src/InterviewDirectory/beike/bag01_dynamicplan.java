package InterviewDirectory.beike;


/**
 * Created by huali on 2018/8/19.
 */
public class bag01_dynamicplan {
    public static void main(String[] args)
    {
        int[] price={40,42,25,12}; //每个东西的价格
        int[] weight={4,7,5,3};  //每个东西的重量
        int maxweight=16;               //最多存储重量
        int num = weight.length;
        int[][]dp = new int[num+1][maxweight+1];

        for(int i =0;i<=num;i++)
        {
            for(int j =0;j<=maxweight;j++)
            {
                if(i==0||j==0)
                    dp[i][j]=0;
                else {
                    if(j<weight[i-1])
                    {
                        dp[i][j]=dp[i-1][j];
                    }else {
                        int value = price[i-1];
                        int weights = weight[i-1];
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights]+value);

                    }
                }
                System.out.println("dp"+"["+i+"]"+"["+j+"]"+dp[i][j]);
            }
        }
        //寻找那些物品放在背包。
        int m = num;
        int n = maxweight;
        int all = dp[m][n];
        while (all>0)
        {
            if(m>0&&dp[m][n]==dp[m-1][n])
                m = m-1;
            else if(m>0)
            {
                System.out.println(weight[m-1]+"加入背包");
                m = m-1;
                if(m==0)
                    return;
                else {
                    n = n-weight[m];
                    all -= price[m];
                }
            }
        }

    }
}