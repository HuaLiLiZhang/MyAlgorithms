package InterviewDirectory.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huali on 2018/8/1.
 */
public class Permutations_duplicates {
    public static void main(String[] args)
    {
        List<List<Integer>> list = new ArrayList<>();
        int [] nums = {2,4,4};
        Arrays.sort(nums);
        backtrackpdup(list, new ArrayList<Integer>() , nums,new boolean[nums.length]);
        System.out.println(list);
        System.out.println(list.size());
    }

    private static void backtrackpdup(List<List<Integer>> list, ArrayList<Integer> temp,
                                      int[] nums, boolean[] userd) {
        if (temp.size()==nums.length)
            list.add(new ArrayList<>(temp));
        else
        {
            for(int i = 0;i<nums.length;i++)
            {
                if(userd[i]||i>0&&nums[i]==nums[i-1]&&!userd[i-1])
                    continue;
                userd[i] = true;
                temp.add(nums[i]);
                backtrackpdup(list,temp, nums, userd);
                userd[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

}