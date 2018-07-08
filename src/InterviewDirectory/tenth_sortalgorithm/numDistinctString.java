package InterviewDirectory.tenth_sortalgorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by huali on 2018/7/7.
 */
public class numDistinctString {
    public int numDistinct(String S, String T) {

        //Map<String,String> map = new HashMap<>();
        //Set<Map.Entry<String,String>> it = map.entrySet();

        int len = T.length();
        int []arr = new int[len+1];
        arr[0] = 1;
        for(int i=1;i<=S.length();i++)
        {
            for(int j=Math.min(i,len);j>0;j--)
            {
                if(S.charAt(i-1)==T.charAt(j-1))
                    arr[j] = arr[j]+arr[j-1];
            }
        }
        return arr[len];



    }
}