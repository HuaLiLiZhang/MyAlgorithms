package offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by huali on 2018/6/26.
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (input == null || input.length <= 0 || k <= 0 || k > input.length)
            return arr;
        int index = partation(input, 0, input.length - 1);
        int start = 0;
        int end = input.length-1;
        while (index != k - 1)
        {
            if(index>k-1)
            {
                end = index-1;
                index = partation(input, start, end);
            }
            else
            {
                start = index+1;
                index = partation(input, start, end);
            }
        }
        for(int i=0;i<k;i++)
        {
            arr.add(input[i]);
        }
        return arr;
    }

    private int partation(int[] input, int start, int end) {
        int l = start;
        int r = end;
        int temp = input[l];
        while (l<r)
        {
            while (l<r&&input[r]>temp)
                r--;
            if(l<r)
            {
                input[l]=input[r];
                l++;
            }

            while (l<r&&input[l]<temp)
                l++;
            if(l<r)
            {
                input[r] = input[l];
                r--;
            }
        }
        input[l] = temp;
        return l;
    }

//    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        if(input==null||input.length<=0||k<=0||k>input.length)
//            return arr;
//        mergesort(input, 0,input.length-1);
//        for(int i=0;i<k;i++)
//        {
//            arr.add(input[i]);
//        }
//        return arr;
//    }
//    public void mergesort(int []arr, int start, int end)
//    {
//        if(start>=end)
//            return ;
//        int mid = (start+end)/2;
//        mergesort(arr, start, mid);
//        mergesort(arr, mid+1, end);
//        merge(arr, start, mid ,end);
//    }
//    public void merge(int[]arr, int start, int mid, int end)
//    {
//        int i= start;
//        int j = mid+1;
//        int []temp =  new int[end-start+1];
//        int k=0;
//        while(i<=mid&&j<=end)
//        {
//            if(arr[i]<arr[j])
//                temp[k++] = arr[i++];
//            else
//                temp[k++] = arr[j++];
//        }
//        while(i<=mid)
//        {
//            temp[k++] = arr[i++];
//        }
//        while(j<=end)
//        {
//            temp[k++] = arr[j++];
//        }
//        for(int m=0;m<temp.length;m++)
//        {
//            arr[start+m] = temp[m];
//        }
//    }

    //对于海量数据
    public ArrayList<Integer> GetLeastNumbers_Solution12(int [] input, int k)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (input == null || input.length <= 0 || k <= 0 || k > input.length)
            return arr;

        for(int i=0;i<input.length;i++)
        {
            if(arr.size()<k)
            {
                arr.add(input[i]);
            }
            else
            {
                Collections.sort(arr);
                if(input[i]<arr.get(k))
                {
                    arr.remove(k);
                    arr.add(input[i]);
                }
            }
        }
        return arr;
    }
}