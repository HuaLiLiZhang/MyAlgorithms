package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/22.
 */
public class generateLIS {
    //计算矩阵的最大递增矩阵序列。
    //时间复杂度为O(N2)
    //
    public int [] list1(int []arr)
    {
        if(arr==null||arr.length==0)
            return null;
        int []dp = getdp1(arr);
        return generateLIS(arr,dp);
    }
    public int[] getdp1(int []arr)
    {
        int [] dp = new int [arr.length];
        for(int i=0;i<arr.length;i++)
        {
            dp[i] = 1;
            for(int j =0;j<i;++j)
            {
                if(arr[i]>arr[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        return dp;
    }

    public int[] generateLIS(int[]arr,int []dp)
    {
        int len = 0;
        int index =0;
        for(int i=0;i<dp.length;++i)
        {
            if(dp[i]>len)
            {
                len=dp[i];
                index = i;
            }
        }
        int []list1 = new int[len];
        list1[--len]=arr[index];
        for(int i=index;i>=0;--i)
        {
            if(arr[i]<arr[index]&&dp[i]==dp[index]-1)
            {
                list1[--len]=arr[i];
                index = i;
            }
        }
        return list1;
    }
}