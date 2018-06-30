package offer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by huali on 2018/6/29.
 */
public class FirstNotRepeatingChar1 {
    public int FirstNotRepeatingChar(String str) {
        char[] ch = str.toCharArray();
        Map<Character, Integer> map=new LinkedHashMap<>();
        if(str.equals(" ")||str.length()<=0)
            return -1;
        for(char c:ch)
        {
            if(!map.containsKey(c))
                map.put(c, 1);
            else
                map.replace(c, map.get(c),map.get(c)+1);
        }

        for(int i = 0;i<ch.length;i++)
        {
            if(map.get(str.charAt(i))==1)
                return i;
        }
        return -1;



        //char cre =0;
        //for(Entry<Character, Integer> m: map.entrySet())
        //{
        //    if(m.getValue()==1) {
        //        cre = m.getKey();
        //        break;
        //    }
        //}
        //int i=0;
        //for(;i<ch.length;i++)
        //{
        //    if(ch[i]==cre)
        //        break;
        //}
        //return i;

    }
}