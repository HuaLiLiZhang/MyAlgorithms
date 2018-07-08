package InterviewDirectory.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huali on 2018/7/5.
 */
public class wordBreaktrue {
    private ArrayList<String> mtemp = new ArrayList<>();
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.equals("")||s.length()<=0||dict.size()<=0)
            return false;
        boolean result = wordpanduan(s, dict);
        return result;

    }

    private boolean wordpanduan(String s, Set<String> dict) {
        int len = s.length();
        if(len<1)
        {
            //StringBuilder builder = new StringBuilder();
            for(int i = 0;i<mtemp.size();i++)
            {
                if(!dict.contains(mtemp.get(i)))
                    return false;
            }
            return true;

        }
        for(int i=len-1;i>=0;i--)
        {
            String sub = s.substring(i,len);
            if(dict.contains(sub))
            {
                mtemp.add(sub);
                boolean result = wordpanduan(s.substring(0,i),dict);
                if(result)
                {
                    return true;
                }
                mtemp.remove(mtemp.size()-1);
            }
        }
        return false;
    }


    public static void main(String []args)
    {
        String s= "a";
        Set<String> set = new HashSet<>();
        set.add("a");
        System.out.println(new wordBreaktrue().wordBreak(s, set));
    }
}