package InterviewDirectory.yuanjingnengyuan2019;

/**
 * Created by huali on 2018/9/6.
 */
public class rotateArrMIddleNum {
    public static void main(String[] args)
    {
        //int[] arr = {3,4,5,6,7,1,2,3};
        int[] arr = {1,2,2,2,2,1,1,1};
        int mid = 0;
        int low = 0;
        int high = arr.length-1;
        while (arr[low]>=arr[high])
        {
            if(high-low==1)
            {
                low = high;
                break;
            }
            mid = (low+high) /2;
            if(arr[low]<=arr[mid])
                low = mid;
            else if(arr[high]>=arr[mid])
                high = mid;
        }
        int minndex = low;
        if(arr.length%2==0)
        {
            int midfindex = 0;
            if(arr.length/2<=arr.length-1-minndex+1)
                midfindex  = minndex + arr.length/2-1;
            else
                midfindex = arr.length/2-(arr.length-1-minndex+1)-1;

            int midsindex = 0;
            if(arr.length/2+1<=arr.length-1-minndex+1)
                midsindex  = minndex + arr.length/2;
            else
                midsindex = arr.length/2+1-(arr.length-1-minndex+1)-1;//最后减1的作用是因为索引从0开始。
            System.out.println((arr[midfindex]+arr[midsindex])/2.0);
        }else
        {
            int midindex = 0;
            if(arr.length/2+1<=arr.length-1-minndex+1)
                midindex = minndex + arr.length/2;
            else
                midindex= arr.length/2+1-(arr.length-1-minndex+1)-1;
            System.out.println(arr[midindex]);
        }

    }
}