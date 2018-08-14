package InterviewDirectory.wangyi2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/1.
 */
public class aaazzzDictionary {
    public static void main(String[] args)
    {
    //    时间复杂度太高，只通过了20%
    //    Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt();
    //    int m = sc.nextInt();
    //    char[]ch = new char[m+n];
    //    for(int i=0;i<n;i++)
    //    {
    //        ch[i] = 'a';
    //    }
    //    for(int i=n;i<n+m;i++)
    //    {
    //        ch[i] = 'z';
    //    }
    //    List<List<String>> list = new ArrayList<>();
    //    Arrays.sort(ch);
    //    backtrackpdup(list, new ArrayList<String>() , ch,new boolean[ch.length]);
    //    //Collections.sort(list);
    //    int k = sc.nextInt();
    //    System.out.println(list);
    //    String s = "";
    //    for(int i = 0;i<list.get(k-1).size();i++)
    //    {
    //        s += list.get(k-1).get(i)+"";
    //    }
    //    System.out.println(s);
    //}
    //
    //private static void backtrackpdup(List<List<String>> list, ArrayList<String> temp,
    //                                  char[] nums, boolean[] userd) {
    //    if (temp.size()==nums.length)
    //        list.add(new ArrayList<>(temp));
    //    else
    //    {
    //        for(int i = 0;i<nums.length;i++)
    //        {
    //            if(userd[i]||i>0&&nums[i]==nums[i-1]&&!userd[i-1])
    //                continue;
    //            userd[i] = true;
    //            temp.add(""+nums[i]+"");
    //            backtrackpdup(list,temp, nums, userd);
    //            userd[i] = false;
    //            temp.remove(temp.size()-1);
    //        }
    //    }

        //StringBuffer str = new StringBuffer();
        //str.append(2);
        //str.append("afdfsg");
        //str.append("10.08948");
        //System.out.println(str);
        //str.reverse();
        //
        //System.out.println(str);


            //改进的方法：
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            String ans = solve(n,m,k);
            if(ans.length()==0)
                System.out.println(-1);
            else
                System.out.println(ans);

    }
    static int check(int a, int b, long lim){
        long ret = 1;
        if(b * 2 > a)
            b = a - b;
        for(int i = 0; i < b; i++) {
            ret *= (a - i);
            ret /= (i + 1);
            if(ret >= lim) return -1;
        }
        if(ret >= lim) return -1;
        return (int)ret;
    }
    static String solve(int a, int z, int k){
        String out = "";
        int n = a + z, i, s;
        s = check(a + z, a, (long)k);
        if(s != -1) return out;
        for(i = 0; i < n; i++){
            if(a == 0 || z == 0) break;
            s = check(a - 1 + z, a - 1, (long)k);
            if(s == -1){
                out += "a";
                a--;
            } else {
                k -= s;
                out += "z";
                z--;
            }
        }
        for(i = 0; i < a; i++)
            out += "a";
        for(i = 0; i < z; i++)
            out += "z";
        return out;
    }

}