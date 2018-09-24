package InterviewDirectory.beike;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/18.
 */
public class pukepai_20 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String  s = sc.nextLine();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<ch.length;i++)
        {
            if(map.isEmpty())
                map.put(ch[i],1);
            else if(!map.containsKey(ch[i]))
                map.put(ch[i],1);
            else
                map.replace(ch[i], map.get(ch[i]+1));
        }

        for(int i = 0;i<map.size();i++)
        {

        }


    }
}