package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/20.
 */
public class CoinsSUmNUm {
    /**
     * 暴力递归有很多重复计算。
     * 比如：当已经使用0张5元，和1张10元，要计算【25,1】组成的990的方法数。
     * 而当使用2张5元，0张10元，还要计算【25,1】组成的990的方法数。
     * 时间复杂度为：O(aim^n)
     * @param arr
     * @param aim
     * @return
     */
    public int coins1(int[]arr,int aim)
    {
        if(arr==null||arr.length==0||aim<0)
            return 0;
        return process1(arr,0,aim);
    }
    public int process1(int[]arr,int index ,int aim)
    {
        int res = 0;
        if(index == arr.length)
        {
            res=aim==0?1:0;
        }else
        {
            for(int i=0;arr[index]*i<=aim;++i)
            {
                res+=process1(arr,index+1,aim-arr[index]*i);
            }
        }
        return res;
    }
    //用map记住递归过程是否已经被计算过，已经计算过，直接取用，没有计算过，再次计算。
    //记忆搜索法：时间复杂度为：O(Nxaim^2)
    public int coins2(int[]arr, int aim)
    {
        if(arr==null||arr.length ==0||aim<0)
            return 0;
        int[][]map = new int [arr.length+1][aim+1];
        return process2(arr,0,aim,map);
    }
    public int process2(int[]arr,int index, int aim,int [][]map)
    {
        int res = 0;
        if(index == arr.length)
            res = aim==0?1:0;
        else {
            int mapValue = 0;
            for(int i =0;arr[index]*i<=aim;i++)
            {
                mapValue = map[index+1][aim-arr[index]*i];
                if(mapValue!=0)
                {
                    res+=mapValue==-1?0:mapValue;
                }else {
                    res+=process2(arr,index+1,aim-arr[index]*i,map);
                }
            }
        }
        map[index][aim] = res ==0?-1:res;
        return res;
    }

//动态规划 , 生成N行，aim+1列的dp，动态规划，
// 先看第0列，筹够0元，需要的钱只要一种方法。所以dp[i][0]都为1，
// 再看第0列，只有第一张钱arr[0]时候，筹够1-aim的方法数，只有是arr[0]的倍数，
// dp[0][arr[0]*j]=1,j=0 到arr[0]*j<=aim为止。
// 后面的规律就是，不用arr[i],只是用arr[i-1]货币时，方法数为，dp[i-1][j],
// 递推，使用k张arr[i],方法数为：dp[i-1][j-arr[i]*k]

    public int coins3(int[]arr,int aim)
    {
        if(arr==null||arr.length ==0||aim<0)
            return 0;

        int[][]dp = new int[arr.length][aim+1];
        for(int i =0;i<arr.length;++i)
        {
            dp[i][0]=1;
        }
        for(int j=1;arr[0]*j<aim;++j)
        {
            dp[0][arr[0]*j] = 1;
        }
        int num=0;
        for(int i=1;i<arr.length;++i)
        {
            for(int j=1;j<=aim;++j)
            {
                num = 0;
                for(int k=0;j-arr[i]*k>=0;++k)
                {
                    num+=dp[i-1][j-arr[i]*k];
                }
                dp[i][j]=num;
            }
        }
        return dp[arr.length-1][aim];

    }
}