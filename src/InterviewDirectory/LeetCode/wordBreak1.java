package InterviewDirectory.LeetCode;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by huali on 2018/7/5.
 */
public class wordBreak1 {
    private ArrayList<String> mresult = new ArrayList<>();
    private ArrayList<String> mtemp = new ArrayList<>();
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if(s.equals("")||s.length()<=0)
            return mresult;
        wordsget(s, dict);
        return mresult;
    }

    private void wordsget(String s, Set<String> dict) {
        int len = s.length();
        if(len<1)
        {
            StringBuilder builder = new StringBuilder();
            for(int i=mtemp.size()-1;i>=0;i--)
            {
                builder.append(mtemp.get(i)).append(" ");
            }
            builder.deleteCharAt(builder.length()-1);//删除最后一个空格
            mresult.add(builder.toString());
        }
        for(int i=len-1;i>=0;i--)
        {
            String sub = s.substring(i,len);
            if(dict.contains(sub))
            {
                mtemp.add(sub);
                wordsget(s.substring(0,i), dict);
                mtemp.remove(mtemp.size()-1);
            }
        }
    }
}