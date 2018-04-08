package InterviewDirectory.StringProblem;

import java.util.Arrays;

/**
 * Created by huali on 2018/4/8.
 */
public class LowestString {
    public String lowestString(String[] strs)
    {
        if(strs==null||strs.length==0)
            return "";
        String res = "";
        Arrays.sort(strs, new MyComparator());
        for(int i =0;i<strs.length;i++)
        {
            res += strs[i];
        }
        return res;
    }

}

