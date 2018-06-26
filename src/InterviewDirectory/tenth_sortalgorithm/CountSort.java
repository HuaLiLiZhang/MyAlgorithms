package InterviewDirectory.tenth_sortalgorithm;

import java.util.Arrays;

/**
 * Created by huali on 2018/4/5.
 */
public class CountSort {
    //如果在面试中有面试官要求你写一个O(n)时间复杂度的排序算法，
    // 你千万不要立刻说：这不可能！
    // 虽然前面基于比较的排序的下限是O(nlogn)。
    // 但是确实也有线性时间复杂度的排序，
    // 只不过有前提条件，就是待排序的数要满足一定的范围的整数，
    // 而且计数排序需要比较多的辅助空间。
    // 其基本思想是，用待排序的数作为计数数组的下标，统计每个数字的个数。
    // 然后依次输出即可得到有序序列。

    //得到数组的最大整数值。
    public static int max(int[]arr)
    {
        int Max = Integer.MIN_VALUE;//整数最小值
        for(int ev : arr)
        {
            if(Max<ev)
                Max = ev;  //找到数组中最大值，然后创建数组的大小。
        }
        return Max;
    }

    //
    public static void countSort1(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;

        int max_v = max(arr);

        int[] count = new int[max_v+1];
        Arrays.fill(count, 0);  //将count数组以0值填充

        for(int i=0; i<arr.length; i++) {
            count[arr[i]] ++;
        }

        int k = 0;
        for(int i=0; i<=max_v; i++) {
            for(int j=0; j<count[i]; j++) {
                //count[]数组的某个值大于0，辣么就表示i这个值出现在arr数组中。辣么arr就加入i
                arr[k++] = i;
            }
        }

    }

    public static void main (String[]args)
    {
        int []arr = {5,3,1,7,9,8,0,2,4,6,12};
        countSort1(arr);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");

    }
}