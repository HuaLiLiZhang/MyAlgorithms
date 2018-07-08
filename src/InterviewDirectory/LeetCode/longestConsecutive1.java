package InterviewDirectory.LeetCode;

import java.util.HashMap;

/**
 * Created by huali on 2018/7/6.
 */
public class longestConsecutive1 {
    public int longestConsecutive(int[] num) {
        if(num==null||num.length==0)
            return 0;
        HashMap<Integer,Boolean>map = new HashMap<>();
        for(int i=0;i<num.length;i++)
        {
            if(!map.containsKey(num[i]))
                map.put(num[i],false);
        }
        int sum = 1;
        int max = 0;
        for(int i=0;i<num.length;i++)
        {
            int temp = num[i];
            while (map.containsKey(--temp))
            {
                map.remove(temp);
                sum++;
            }
            temp = num[i];
            while (map.containsKey(++temp))
            {
                map.remove(temp);
                sum++;
            }
            max = Math.max(sum,max);
            sum = 1;
        }
        return max;
    }
    public static void main(String[]args)
    {
        int []num = {100,4,200,1,3,2};
        longestConsecutive1 longl = new longestConsecutive1();
        System.out.println(longl.longestConsecutive(num));
    }
}