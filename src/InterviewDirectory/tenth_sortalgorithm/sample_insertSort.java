package InterviewDirectory.tenth_sortalgorithm;

/**
 * Created by huali on 2018/4/5.
 */
public class sample_insertSort {
    //插入排序：时间复杂度是O(N^2) ，空间复杂度为O(1)
    //基本思想：
    //在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，
    // 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
    public void insertsort1(int []arr)
    {
        if(arr==null||arr.length==0)
            return ;
        for(int i =1;i<arr.length;i++)
        {
            for(int j=i; j>0;j--)
            {
                if(arr[j]<arr[j-1])
                {
                    swap(arr, j, j-1);
                }else {
                    break;
                }
            }
        }
    }
    public void swap(int[]arr, int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}