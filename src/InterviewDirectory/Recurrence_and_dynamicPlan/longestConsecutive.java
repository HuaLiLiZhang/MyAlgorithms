package InterviewDirectory.Recurrence_and_dynamicPlan;

import java.util.HashMap;

/**
 * Created by huali on 2018/4/2.
 */
public class longestConsecutive {
    public int longestConse(int[] arr)
    {
        if(arr==null||arr.length==0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for(int i = 0;i<arr.length;i++)
        {
            if(!map.containsKey(arr[i]))
            {
                map.put(arr[i], 1);
                if(map.containsKey(arr[i]+1))
                {
                    max = Math.max(max, merge(map, arr[i],arr[i]+1));
                }
                if(map.containsKey(arr[i]-1))
                {
                    max = Math.max(max, merge(map, arr[i]-1,arr[i]));
                }
            }
        }
        return max;
    }

    public int merge(HashMap<Integer, Integer> map , int less , int more)
    {
        int left = less - map.get(less) +1;
        int right = more + map.get(more)-1;
        int len = right - left+1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}