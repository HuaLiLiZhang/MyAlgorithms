package InterviewDirectory.yuanjingnengyuan2019;

/**
 * Created by huali on 2018/9/5.
 */
public class minNumberInRotateArray {
    public static void main(String[] args)
    {
        int []array = {2,2,2,2,2,1,2,2};
        int mid ;
        int low = 0;
        int high = array.length-1;
        while(array[low]>=array[high])
        {
            mid = (low+high)/2;
            if(high - low ==1)
            {
                low=high;
                break;
            }

            if(array[low]<=array[mid])
            {
                low = mid;
            }
            else if(array[mid]<=array[high])
            {
                high = mid;
            }

        }
        System.out.println(array[low]);
    }
}