package InterviewDirectory.haoweilai2019;

import javax.xml.transform.Source;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/31.
 */
public class MaxASCLength_ofArr {
    //暴力解法：
    public static void main(String[] args)
    {
        //数组最大升序序列的长度

        //方法 1 暴力搜索（超出时间限制）
        //
        //算法
        //最简单的方法是尝试寻找所有递增子序列，然后返回递增子序列的最大长度。
        // 为此，我们使用递归函数lengthofLIS，该函数返回从当前元素（curpos）向前（包括当前元素）的LIS长度。
        // 每次函数调用时，考虑两种情况：
        //当前元素比LIS中的前一个元素大。这种情况下，我们可以将当前元素纳入LIS。
        // 然后求出包含当前元素后的LIS长度。同时，我们也求出不包含当前元素的LIS长度。最后返回两个长度的最大值。
        //当前元素小于LIS中的前一个元素。这种情况下，不能将当前元素放入LIS中。因此，我们返回不包含当前元素的LIS长度。
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] temp = str.split(" ");
            int[] a = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                a[i] = Integer.parseInt(temp[i]);
            }

            int count  = LengthofLIS(a, Integer.MIN_VALUE, 0);
            System.out.println(count);

            count = findmanLength(a, a.length);
            System.out.println(count);
        }
    }
//2 7 4 6 7 1 8 9
//6
//6
//5 1 3 4 9 7 6 8
//5
//5
//最长升序子序列，长度为5
    private static int LengthofLIS(int[] a, int pre, int curindex) {
        if(curindex==a.length)
            return 0;
        int token = 0;
        if(a[curindex]>pre)
        {
            token = LengthofLIS(a, a[curindex], curindex+1)+1;
            //表示当前元素比前一个元素值大，把当前元素加入的情况。
        }
        int notoken = LengthofLIS(a, pre, curindex+1);
        return Math.max(token,notoken);

    }

//方法 3 动态规划（通过）
//典型动态规划题目。
//对于arr，生成dp，dp[i]表示在必须以arr[i]这个数结尾的情况下，arr[o...i]中的最大递增子序列长度。
//
//dp[0]=1
//对于dp[i],所有比arr[i]小的数都可以作为倒数第2个数，其中，哪个数的dp最大，则将其作为倒数第2个数
//dp[i]=max{dp[j]+1 (0<=j<1,arr[j]<arr[i])}
//返回dp中最大的数

    public static  int findmanLength(int []arr , int n)
    {
        int [] dp = new int[n];
        dp[0] = 1;
        for(int i = 0;i<n;i++)
        {
            int max = 0;
            int j = 0;
            while (j<i)
            {
                if(arr[j]<arr[i]&&dp[j]>max)
                {
                    max = dp[j];
                }
                j++;
            }
            dp[i] = max+1;
        }
        int res = 0;
        for(int i = 0;i<n;i++)
        {
            if(res<dp[i])
                res = dp[i];
        }
        return res;
    }


//    动态规划
public static int lis(int[] array){
    int length=array.length;
    if (length ==0)
        return 0;
    int maxCount=0;
    int[] dp=new int[length];
    for(int i =0;i<length;i++){
        dp[i]=1;
        for(int j =0;j<i;j++){
            if(array[j]<array[i])
                dp[i]=dp[i]>dp[j]+1?dp[i]:dp[j]+1;
            if(maxCount<dp[i])
                maxCount=dp[i];
        }
    }
    return maxCount;
}
}