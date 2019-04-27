package InterviewDirectory.nowcode_middle.String1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by huali on 2018/10/10.
 */
public class zuichangbuchongfusubstring {
    //最长无重读子串的长度
    //1.有一个hash表记载当前字符之前所在的位置,之后并更新
    //2.用一个pre变量记载以此字符结尾的最长无重复子串的长度。  并求最大值就可以了
    public static void main(String[] args)
    {
        String s = "abcdefszsc";
        int max = 0;
        Map<Character,Integer> map = new LinkedHashMap<>();
        int pre = 0;
        //int [] len = new int[s.length()];
        for(int i = 0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                int indexc = map.get(s.charAt(i));
                if(i-indexc<pre)
                {
                    pre = i-indexc;
                    //len[i] = pre;
                }
                else
                {
                    pre++;
                    //len[i] = pre;
                }
                map.replace(s.charAt(i),i);
                max = Math.max(pre,max);
            }
            else {
                pre++;
                map.put(s.charAt(i), i);
                //len[i] = pre;
                max = Math.max(pre,max);
            }
        }

        System.out.println(max);

    }
}