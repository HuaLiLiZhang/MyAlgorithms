package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/7.
 */
public class maxProfit_stock {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=0)
            return 0;
        int shell1 = 0;
        int buy1 = Integer.MIN_VALUE;
        int shell2 = 0;
        int buy2 = Integer.MIN_VALUE;
        for(int i:prices)
        {
            buy1 = Math.max(buy1, -i);
            shell1 = Math.max(shell1, buy1+i);
            buy2 = Math.max(buy2,shell1-i);
            shell2 = Math.max(shell2, buy2+i);
        }
        return shell2;
    }

    public static void main(String[]args)
    {
        int [] prices = {10,22,5,75,65,80};
        int pro = new maxProfit_stock().maxProfit(prices);
        System.out.println(pro);
    }
}