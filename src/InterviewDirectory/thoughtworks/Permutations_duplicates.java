package InterviewDirectory.thoughtworks;

import java.util.*;

/**
 * Created by huali on 2018/8/1.
 */
public class Permutations_duplicates {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[]ch = new char[m+n];
        for(int i=0;i<n;i++)
        {
            ch[i] = 'a';
        }
        for(int i=n;i<n+m;i++)
        {
            ch[i] = 'z';
        }
        List<List<String>> list = new ArrayList<>();
        Arrays.sort(ch);
        backtrackpdup(list, new ArrayList<String>() , ch,new boolean[ch.length]);
        //Collections.sort(list);
        int k = sc.nextInt();
        System.out.println(list);
        String s = "";
        for(int i = 0;i<list.get(k-1).size();i++)
        {
            s += list.get(k-1).get(i)+"";
        }
        System.out.println(s);
    }

    private static void backtrackpdup(List<List<String>> list, ArrayList<String> temp,
                                      char[] nums, boolean[] userd) {
        if (temp.size()==nums.length)
            list.add(new ArrayList<>(temp));
        else
        {
            for(int i = 0;i<nums.length;i++)
            {
                if(userd[i]||i>0&&nums[i]==nums[i-1]&&!userd[i-1])
                    continue;
                userd[i] = true;
                temp.add(""+nums[i]+"");
                backtrackpdup(list,temp, nums, userd);
                userd[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

}