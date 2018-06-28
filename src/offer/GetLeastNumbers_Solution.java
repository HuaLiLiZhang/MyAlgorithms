package offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by huali on 2018/6/27.
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (input == null || input.length <= 0 || k <= 0 || k > input.length)
            return arr;
        int start = 0;
        int end = input.length-1;
        int index = partition(input, start, end);
        while (index!=k-1)
        {
            if(index>k-1)
            {
                end = index-1;
                index = partition(input, start, end);
            }else {
                start = index+1;
                index = partition(input, start, end);
            }
        }
        for(int i=0;i<k;i++)
        {
            arr.add(input[i]);
        }
        Collections.sort(arr);
        return arr;
    }

    private int partition(int[] arr, int start, int end) {
        int l =start;
        int r = end;
        int temp = arr[start];
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
}