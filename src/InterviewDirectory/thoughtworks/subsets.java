package InterviewDirectory.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huali on 2018/8/1.
 */
public class subsets {
    public static void main(String[] args)
    {
        int [] nums = {2,9,4,4};
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        //backtrack(list, new ArrayList<>(), nums, 0);
        //包含重复元素就不行了,先排序
        Arrays.sort(nums);
        backtrackduplicate(list, new ArrayList<>(), nums, 0);
        System.out.println(list);

    }

    private static void backtrackduplicate(List<List<Integer>> list, ArrayList<Integer> arr,
                                           int[] nums, int start) {
        list.add(new ArrayList<>(arr));
        for(int i =start;i<nums.length;i++)
        {
            //去重复的，集合中不允许重复
            if(i>0&&nums[i]==nums[i-1])
                continue;
            arr.add(nums[i]);
            backtrackduplicate(list, arr, nums, i+1);
            arr.remove(arr.size()-1);
        }
    }

    private static void backtrack(List<List<Integer>> list, ArrayList<Integer> arr,
                                  int[] nums, int start) {
        list.add(new ArrayList<>(arr));//子集包括空集
        for(int i = start;i<nums.length;i++)
        {
            arr.add(nums[i]);
            backtrack(list, arr, nums, i+1);
            arr.remove(arr.size()-1);
        }
    }
}