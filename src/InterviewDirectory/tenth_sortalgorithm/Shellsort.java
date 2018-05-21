package InterviewDirectory.tenth_sortalgorithm;

/**
 * Created by huali on 2018/4/5.
 */
public class Shellsort {
    //希尔排序的平均时间复杂度是：O(nlogn)，最坏的时间复杂度，O(n^s)1，空间复杂度是：O(1)

    //希尔排序是插入排序的一种高效率的实现，也叫缩小增量排序
    //也叫缩小增量排序。简单的插入排序中，
    // 如果待排序列是正序时，时间复杂度是O(n)，
    // 如果序列是基本有序的，使用直接插入排序效率就非常高。
    // 希尔排序就利用了这个特点。
    // 基本思想是：先将整个待排记录序列分割成为若干子序列分别进行直接插入排序，
    // 待整个序列中的记录基本有序时再对全体记录进行一次直接插入排序
    public static void main(String []args)
    {
        int []arr = {9,1,5,8,3,7,4,6,2};
        shellsort(arr);
    }
    public static void shellsort(int []arr)
    {
        if(arr == null || arr.length == 0)
            return ;
        int d = arr.length/2;
        while (d>=1)  //希尔排序每次讲距离d减小，减小到1就可以排序成功。
        {
            shellsort1(arr, d);
            d/=2;
        }
    }



    public static void shellsort1(int []arr, int d)
    {
        /**
         * 希尔排序的一趟插入
         * @param arr 待排数组
         * @param d 增量
         */
        for(int i=d;i<arr.length;i++)
        {
            int j = i-d;
            int temp = arr[i];//记录要插入的数据
            while (j>=0&&arr[j]>temp)//从后向前，找到比其小的数的位置
            {
                arr[j+d]=arr[j]; //向后挪动
                j-=d;
            }
            if(j!=i-d)
                arr[j+d] =temp;
        }
    }

}