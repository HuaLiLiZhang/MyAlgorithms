package InterviewDirectory.Tencent2016;

import java.util.*;
/**
 * Created by huali on 2018/5/10.
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<gifts.length;i++)
        {
            if(!map.containsKey(gifts[i]))
                map.put(gifts[i],1);
            else
                map.replace(gifts[i], map.get(gifts[i])+1);
        }

        for (Map.Entry<Integer,Integer> m:map.entrySet())
        {
            if(m.getValue()>n/2)
                return m.getKey();
        }
        return 0;
    }
}