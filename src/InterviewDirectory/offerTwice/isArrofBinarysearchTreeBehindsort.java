package InterviewDirectory.offerTwice;

/**
 * Created by huali on 2018/8/19.
 */
public class isArrofBinarysearchTreeBehindsort {
    public static void main(String[] args)
    {
        //int [] arr = {5,7,6,9,11,10,8};
        //int [] arr = {7,4,6,5};
        int [] arr = {2};
        if(arr.length<=0)
        {
            System.out.println(false);
            return ;
        }
        boolean result = isbehindTreesort(arr, 0, arr.length);
        System.out.println(result);
    }

    private static boolean isbehindTreesort(int[] arr, int start, int end) {

        //if(end<=0)
        //    return false;
        if(start==end)
            return  true;
        int i = start;
        int root = arr[end-1];
        for(;i<end-1;i++)
        {
            if(arr[i]>root)
                break;
        }
        int j = i;
        for(;j<end-1;j++)
        {
            if(arr[j]<root)
                return false;
        }
        boolean left = true;
        if(i>0)
            left = isbehindTreesort(arr, start, i);
        boolean right = true;
        if(i<end-1)
            right = isbehindTreesort(arr, i, end-1);
        return left&&right;
    }
}