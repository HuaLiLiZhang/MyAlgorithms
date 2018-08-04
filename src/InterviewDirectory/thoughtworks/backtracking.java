package InterviewDirectory.thoughtworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huali on 2018/8/1.
 */
public class backtracking {
    static List<List<Integer>> result=new ArrayList<List<Integer>>();
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<Integer>();
        backtrackings(n,k,1,list);
        System.out.println(result);
        return result;
    }

    private static void backtrackings(int n, int k, int start, List<Integer> list) {
        if(k<0)
            return;
        else if(k==0)
        {
            result.add(new ArrayList<>(list));
        }
        else
        {
            for(int i = start;i<=n;i++)
            {
                list.add(i);
                backtrackings(n, k-1, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args)
    {
           combine(4, 2);
    }
}