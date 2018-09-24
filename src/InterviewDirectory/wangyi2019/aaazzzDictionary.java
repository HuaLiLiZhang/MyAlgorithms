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
    //    时间复杂度太高，只通过了20%，不能先列出来在得到某个位置的数，复杂度高，空间复杂度也高。
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


            //改进的方法：直接找规律
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
            return (int)ret;  //k超过了最多的字符串排序的个数。
        }
    static String solve(int a, int z, int k){
        String out = "";
        int n = a + z, i, s;
        s = check(a + z, a, (long)k);
        if(s != -1) return out;
        //s ==-1就没有超过就继续判断。
        for(i = 0; i < n; i++){
            if(a == 0 || z == 0) break;
            s = check(a - 1 + z, a - 1, (long)k);
            if(s == -1){  //如果去掉一个a，K依然小于总数的话，那么这一位就是a
                out += "a";
                a--;
            } else { //如果去掉一个a，K大于总数的话，那么这一位就是Z，同时要减去以Z开头的所有组合。
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