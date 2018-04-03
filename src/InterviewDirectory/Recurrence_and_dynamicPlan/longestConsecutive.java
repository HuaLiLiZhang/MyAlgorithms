package InterviewDirectory.Recurrence_and_dynamicPlan;

import java.util.HashMap;

/**
 * Created by huali on 2018/4/2.
 */
public class longestConsecutive {//数组的最长子序列{100,4,2333,3,2,1}；最长子序列为：1,2,3,4
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
                if(map.containsKey(arr[i]-1))
                {
                    max = Math.max(max, merge(map, arr[i]-1, arr[i]));
                }

                if(map.containsKey(arr[i]+1))
                {
                    max = Math.max(max, merge(map, arr[i],arr[i]+1));
                }

            }
        }
        return max;
    }

    public int merge(HashMap<Integer, Integer> map , int less , int more)
    {
        //less = less - map.get(less)+1,这里是序列最小值可以到几，就是说3 的话前面有两个，就是从1到3.
        //所以left 是1， right是3，
        //同理如果是比他大，那么最大值扩展。
        int left = less - map.get(less) +1;
        int right = more + map.get(more)-1;
        int len = right - left+1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}