package InterviewDirectory.huawei2019;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/15.
 */
public class huaweimain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] ch = s.toCharArray();
        int[] flags = new int[256];
        for(int i = 0;i<256;i++){
            flags[i] = 0;
        }
        StringBuffer str = new StringBuffer();

        for(int i = 0;i<ch.length;i++){
            if(flags[ch[i]]==0){
                flags[ch[i]]=1;
                str.append(ch[i]);
            }
        }
        System.out.println(str.toString());
    }

    //public static void main(String[] args)
    //{
    //       Scanner sc = new Scanner(System.in);
    //       String s = sc.nextLine();
    //       StringBuffer strb = new StringBuffer();
    //       HashMap<Character,Integer> map = new LinkedHashMap<>();
    //       for(int i = 0;i<s.length();i++)
    //       {
    //           if(map.isEmpty())
    //           {
    //               map.put(s.charAt(i), 1);
    //               strb.append(s.charAt(i));
    //           }
    //           else if(!map.containsKey(s.charAt(i)))
    //           {
    //               map.put(s.charAt(i), 1);
    //               strb.append(s.charAt(i));
    //           }
    //       }
    //    System.out.println(strb.toString());
    //}
//    1256sfdfhfgjssss455612
//1256sfdhgj4
//1256sfdhgj4
}