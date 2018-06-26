package offer;

import InterviewDirectory.tenth_sortalgorithm.heapSort;

/**
 * Created by huali on 2018/6/24.
 */
public class aMoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length<=0)
            return 0;
        int start = 0;
        int end = array.length-1;
        int index = partition1(array, start, end);
        partionsort(array, start, index-1);
        partionsort(array, index+1, end);
        int number = array[array.length/2];
        int result =0;
        for(int i=0;i< array.length;i++)
        {
            if(array[i]==number)
                result++;
        }
        if(result> array.length/2)
            return number;
        return 0;

    }
    public int partition1(int []arr, int left, int right)
    {
        int l = left;
        int r =right;
        int temp = arr[l];
        //
        while (l<r)
        {
            while (l<r&&arr[r]>temp)
                r--;
            if(l<r)
            {
                arr[l] = arr[r];
                l++;
            }
            while (l<r&&arr[l]<temp)
                l++;
            if(l<r)
            {
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = temp;
        return l;
    }

    public void partionsort(int[] array, int start, int end) {
        if(array==null||array.length==0||start>=end)
            return ;
        int left = start;
        int right = end;
        int temp = array[left];
        while (left<right)
        {
            while (left<right&&array[right]>=temp)
                right--;
            if(left<right)
            {
                array[left] = array[right];
                left++;
            }
            while (left<right&&array[left]<temp)
                left++;
            if(left<right)
            {
                array[right] = array[left];
                right--;
            }

        }
        array[left] = temp;
        partionsort(array, start, left-1);
        partionsort(array, left+1, end);
    }

    //public void quicksort1(int[]arr, int l, int r)
    //{
    //    if(arr==null||arr.length==0||l>=r)
    //        return ;
    //    int left = l;
    //    int right = r;
    //    int pivot = arr[left]; //选择第一个数为key
    //    while (left<right)
    //    {
    //        while (left<right&&arr[right]>=pivot)
    //        {
    //            right--;
    //        }
    //        if(left<right)
    //        {
    //            arr[left] = arr[right];
    //            left++;
    //        }
    //        while (left<right&&arr[left]< pivot)
    //            left++;
    //        if(left<right)
    //        {
    //            arr[right]=arr[left];
    //            right--;
    //        }
    //    }
    //    arr[left] = pivot;
    //    quicksort1(arr, l, left-1);
    //    quicksort1(arr, left+1, r);
    //}

    public static void main(String []args)
    {
        int[] data5 = { 1,2,2,3,2,1,2,2,2,2 };
        System.out.println(new aMoreThanHalfNum_Solution().MoreThanHalfNum_Solution(data5));
        System.out.println("排序后的数组：");
        print(data5);
    }
    public    static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}