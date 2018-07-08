package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/7.
 */
public class maxProfit_multiply {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=0)
            return 0;
        int sum = 0;
        for(int i=0;i<prices.length-1;i++)
        {
            if(prices[i]<prices[i+1])
                sum +=prices[i+1]-prices[i];

        }
        return sum ;
    }
}