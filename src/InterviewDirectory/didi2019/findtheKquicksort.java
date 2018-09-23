package InterviewDirectory.didi2019;

/**
 * Created by huali on 2018/9/23.
 */
public class findtheKquicksort {
//    利用快排寻找最大的前K的最大数
    public static void main(String[] args)
    {
         int k = 4;
         int arr [] = {7,4,9,5,6,2,8,3,1};
         sort(arr,0,arr.length-1,k);

         for(int i = 0;i<k;i++)
         {
             System.out.print(arr[i]+" ");
         } //最小的前K个

    }

    private static void sort(int[] arr, int start, int end,int k) {
        int i = start;
        int j = end;
        int temp = arr[i];
        while (i<j)
        {
            while (i<j&&arr[j]>=temp)
            {
                j--;
            }
            if(arr[j]<temp)
            {
                arr[i] = arr[j];
                i++;
            }
            while (i<j&&arr[i]<=temp)
                i++;
            if(arr[i]>temp)
            {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = temp;
        int kth = i;
        if(kth<k-1)
        {
            sort(arr,kth+1,end,k);
        }
        else if(kth>k-1)
        {
            sort(arr,start,kth-1,k);
        }if(kth==k)
            return;

    }
}