package InterviewDirectory.LeetCode_after;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/25.
 */
public class npailie {
    //3
    //123
    //132
    //213
    //231
    //312
    //321
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        String s = "";
        for(int i = 0;i<n;i++)
        {
            s +=String.valueOf(i+1);
        }
        backtrackPermute(list, new ArrayList<>() , s);
        for(int i = 0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }

    private static void backtrackPermute(List<String> list, List temp,
                                         String nums) {
        if (temp.size() == nums.length()) {
            String t0 = new String();
            for(Object ch : temp)
            {
                t0 += ch;
            }
            list.add(t0);
        } else{
            for(int i=0;i<nums.length();i++)
            {
                if(temp.contains(nums.charAt(i)))//元素已经存在。
                    continue;
                temp.add(nums.charAt(i));
                backtrackPermute(list, temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}