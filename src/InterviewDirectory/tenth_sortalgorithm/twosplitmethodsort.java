package InterviewDirectory.tenth_sortalgorithm;

/**
 * Created by huali on 2018/6/29.
 */
public class twosplitmethodsort {
    public int GetNumberOfK(int []array,int k)
    {
        if(array!=null&&array.length>0) {
            int length = array.length;
            int startKey = getStartKey(array, 0, length - 1, k);
            int endKey = getendKey(array, 0, length - 1, k);
            if (startKey > -1 && endKey > -1)
                return endKey - startKey + 1;
        }
        return 0;
    }

    private int getendKey(int[] array, int start, int end, int k) {
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        int midvalue = array[mid];
        if(midvalue==k)
        {
            if((mid<array.length-1&&array[mid+1]!=k)||mid==array.length-1)
                return mid;
            else
                start = mid+1;
        }else if(midvalue>k)
        {
            end = mid-1;
        }
        else
            start = mid+1;
        return getendKey(array, start, end, k);
    }

    private int getStartKey(int[] array, int start, int end, int k) {
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        int midvalue = array[mid];
        if(midvalue==k)
        {
            if((mid>0&&array[mid-1]!=k)||mid==0)
                return mid;
            else
                end = mid-1;
        }else if(midvalue>k)
        {
            end = mid-1;
        }
        else
            start = mid+1;
        return getStartKey(array, start, end, k);
    }
}