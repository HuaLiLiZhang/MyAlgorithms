package InterviewDirectory.yuanjingnengyuan2019;

/**
 * Created by huali on 2018/8/27.
 */
public class Main2 {
    //
    //Given an array of integers, every element appears three times except for one. Find that single one.
    //
    //Note:
    //Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    //
    //
    //
    //这道题是之前那道 Single Number 单独的数字 的延伸，那道题的解法就比较独特，是利用计算机按位储存数字的特性来做的，
    // 这道题就是除了一个单独的数字之外，数组中其他的数字都出现了三次，那么还是要利用位操作 Bit Operation 来解此题。
    // 我们可以建立一个32位的数字，来统计每一位上1出现的个数，
    // 我们知道如果某一位上为1的话，那么如果该整数出现了三次，对3去余为0，我们把每个数的对应位都加起来对3取余，
    // 最终剩下来的那个数就是单独的数字。代码如下：



    public static void main(String[] args)
    {
        //int [] arr = {2,2,2,9,3,4,4,4,3,3};
        //int result = singleNumber(arr);
        //System.out.println(result);

        int [] arr = {2,2,5,10,100,100,8,5,4,4,3,3,8};
        int result = singletwonum(arr);
        System.out.println(result);

    }

    //此方法是测试数组除了一个单独的数字之外，数组中其他的数字都出现了两次
    private static int singletwonum(int[] arr) {
        int res = 0;

        for(int j = 0;j<arr.length;j++)
        {
            res ^= arr[j];
        }
        return res;

    }

    //数组中是除了一个单独的数字之外，数组中其他的数字都出现了三次
    public static int singleNumber(int[] A) {
        int res = 0;
        for(int i = 0;i<32;i++)
        {
            int sum = 0;
            for(int j = 0;j<A.length;j++)
            {
                sum +=(A[j]>>i)&1;
            }
            res |=(sum%3) <<i;
        }
        return res;

    }
}