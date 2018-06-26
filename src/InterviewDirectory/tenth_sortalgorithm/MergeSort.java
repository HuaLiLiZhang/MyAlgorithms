package InterviewDirectory.tenth_sortalgorithm;

/**
 * Created by huali on 2018/4/5.
 */
public class MergeSort {
    // 空间复杂度为O(n)，时间复杂度为O(nlogn),最坏时间复杂度：O(nlogn)。

    //归并排序是稳定的排序算法，其时间复杂度为O(nlogn)，
    // 如果是使用链表的实现的话，空间复杂度可以达到O(1)，
    // 但如果是使用数组来存储数据的话，在归并的过程中，
    // 需要临时空间来存储归并好的数据，所以空间复杂度为O(n)

    //归并排序是另一种不同的排序方法，
    // 因为归并排序使用了递归分治的思想，所以理解起来比较容易。
    // 其基本思想是，先递归划分子问题，然后合并结果。
    // 把待排序列看成由两个有序的子序列，然后合并两个子序列，
    // 然后把子序列看成由两个有序序列。。。。。倒着来看，
    // 其实就是先两两合并，然后四四合并。。。最终形成有序序列。

    public void mergesort(int []arr)
    {
        mSort(arr, 0, arr.length-1);
    }



    public void mSort(int[]arr ,int left ,int right)
    {
        /**
         * 递归分治
         * @param arr 待排数组
         * @param left 左指针
         * @param right 右指针
         */
        //递归分治的思想
        if(left>=right)
            return ;
        int mid = (left+right)/2;
        mSort(arr, left ,mid);
        mSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
    public void merge(int []arr, int left ,int mid, int right)
    {
        /**
         * 合并两个有序数组
         * @param arr 待合并数组
         * @param left 左指针
         * @param mid 中间指针
         * @param right 右指针
         */
        //中间数组，占用内存O(N)
        int []temp = new int [right-left+1];
        int i = left;
        int j = mid+1;
        int k =0;
        while (i<=mid&&j<=right)
        {
            if(arr[i]<=arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++]=arr[j++];
        }
        while (i<=mid)
        {
            temp[k++]=arr[i++];
        }
        while (j<=right)
        {
            temp[k++] = arr[j++];
        }
        for(int p = 0;p<temp.length;p++)
        {
            arr[left+p] = temp[p];
        }
    }

    public static void main(String[]args)
    {
        int[]arr ={5,3,4,7,8,1,9,0,2};
        new MergeSort().mergesort(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

}