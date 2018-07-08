package InterviewDirectory.LeetCode;

import java.util.Arrays;

/**
 * Created by huali on 2018/7/6.
 */
public class candy1 {
    public int candy(int[] ratings) {

        if(ratings==null||ratings.length<=0)
        {
            return 0;
        }
        int sum = 0;
        int [] num = new int[ratings.length];
        Arrays.fill(num,1);
        for(int i=1;i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
                num[i] = num[i-1]+1;
        }
        for(int i=ratings.length-1;i>0;i--)
        {
            if(ratings[i-1]>ratings[i]&&num[i-1]<=num[i])
                num[i-1] = num[i]+1;
        }
        for(int i=0;i<num.length;i++)
        {
            sum +=num[i];
        }
        return sum;
    }

    public static void main(String[]args)
    {
        int []arr = {4,2,3,4,1};
        candy1 c = new candy1();
        int sum = c.candy(arr);
        System.out.println(sum);
    }
}