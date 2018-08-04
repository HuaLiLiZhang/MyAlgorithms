package InterviewDirectory.thoughtworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huali on 2018/8/1.
 */
public class Permutations {
    public static void main(String[] args)
    {
        List<List<Integer>> list = new ArrayList<>();
        int [] nums = {2,45,8,4,9};
        backtrackPermute(list, new ArrayList<Integer>() , nums);
        System.out.println(list);
    }

    private static void backtrackPermute(List<List<Integer>> list, ArrayList<Integer> temp,
                                         int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else{
            for(int i=0;i<nums.length;i++)
            {
                if(temp.contains(nums[i]))//元素已经存在。
                    continue;
                temp.add(nums[i]);
                backtrackPermute(list, temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}