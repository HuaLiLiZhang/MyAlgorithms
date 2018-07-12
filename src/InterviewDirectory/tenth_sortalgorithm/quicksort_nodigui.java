package InterviewDirectory.tenth_sortalgorithm;

import java.util.Stack;

/**
 * Created by huali on 2018/7/12.
 */
public class quicksort_nodigui {
    public void quicksort(int []arr)
    {
        if(arr==null||arr.length<=0)
            return ;
        int start = 0;
        int end = arr.length-1;
        Stack<Integer> s = new Stack<>();
        s.add(start);
        s.add(end);
        int l = 0;
        int r = 0;
        while (!s.isEmpty())
        {
            r = s.pop();
            l = s.pop();
            if(l<r)
            {
                int mid = partition(arr, l,r);
                if(mid>l)
                {
                    s.add(l);
                    s.add(mid-1);
                }
                if(mid<r)
                {
                    s.add(mid+1);
                    s.add(r);
                }
            }
        }

    }

    public static void main(String []args)
    {
        int[] data5 = new int[] { 5, 3, 6, 0, 2, 1, 9, 4, 8, 7 };
        System.out.println("排序前的数组：");
        for( int a : data5)
        {
            System.out.print(a+" ");
        }
        System.out.println();
        new quicksort_nodigui().quicksort(data5);
        System.out.println("排序后的数组：");
        for( int a : data5)
        {
            System.out.print(a+" ");
        }


    }

    private int partition(int[] arr, int start, int end) {
        int l = start;
        int r = end;
        int temp = arr[start];
        while (l<r)
        {
            while (l<r&&arr[r]>=temp)
                r--;
            if(l<r)
            {
                arr[l] = arr[r];
                l++;
            }
            while (l<r&&arr[l]<=temp)
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