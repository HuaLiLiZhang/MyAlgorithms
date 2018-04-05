package InterviewDirectory.tenth_sortalgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by huali on 2018/4/5.
 */
public class BucketSort {
//     桶排序的平均时间复杂度为线性的O(N+C)，
// 其中C=N*(logN-logM)。
// 如果相对于同样的N，桶数量M越大，其效率越高，
// 最好的时间复杂度达到O(N)。
// 当然桶排序的空间复杂度 为O(N+M)，
// 如果输入数据非常庞大，而桶的数量也非常多，则空间代价无疑是昂贵的。此外，桶排序是稳定的。

    public static void bucketSort(int[] arr) {
        if(arr == null && arr.length == 0)
            return ;

        //int bucketNums = 10; //这里默认为10，规定待排数[0,100)
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(); //桶的索引

        for(int i=0; i<10; i++) {
            buckets.add(new LinkedList<Integer>()); //用链表比较合适
        }

        //划分桶
        for(int i=0; i<arr.length; i++) {
            buckets.get(f(arr[i])).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i=0; i<buckets.size(); i++) {
            if(!buckets.get(i).isEmpty()) {
                Collections.sort(buckets.get(i)); //对每个桶进行快排
            }
        }

        //还原排好序的数组
        int k = 0;
        for(List<Integer> bucket : buckets) {
            for(int ele : bucket) {
                arr[k++] = ele;
            }
        }
    }


    public static int f(int x) {
        /**
         * 映射函数
         * @param x
         * @return
         */
        return x / 10;
    }

}