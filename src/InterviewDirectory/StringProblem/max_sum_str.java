package InterviewDirectory.StringProblem;

import java.util.HashMap;

/**
 * Created by huali on 2018/4/13.
 */
public class max_sum_str {
    //9fil3dj11P0jAsf11j
    public int  sum_str(String str)
    {
        char[] chars = str.toCharArray();
        int cur = 0;
        int [] count = new int[256];
        for(int i =0;i<chars.length;i++)
        {
            if(chars[i]>='0'&&chars[i]<='9')
            {
                cur = cur*10 +(chars[i]-'0');
            }
            else {
                if(cur!=0)
                {
                    count[cur]++;
                }
                cur=0;
            }

        }
        if(cur!=0)
            count[cur]++;
        int max =0;
        int index =0 ;
        for(int i =0 ;i<count.length;i++)
        {
            if(count[i]>max)
            {
                max= count[i];
                index = i;
            }
        }
        return max*index;
    }
}