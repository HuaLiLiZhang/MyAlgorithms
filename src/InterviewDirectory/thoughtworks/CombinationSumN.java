package InterviewDirectory.thoughtworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huali on 2018/8/1.
 */
public class CombinationSumN {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        int [] arr = {2,3,6,7};
        combinasumN(arr, 7, 0,list);
        System.out.println(result);
    }

    private static void combinasumN(int[] arr, int k, int start, List<Integer> list) {
        if(k<0)
            return;
        else if(k==0)
        {
            result.add(new ArrayList<>(list));
        }
        else
        {
            for(int i = start;i<arr.length;i++)
            {
                list.add(arr[i]);
                combinasumN(arr, k-arr[i], i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}