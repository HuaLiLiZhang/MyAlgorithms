package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/6.
 */
public class singleNumber2 {
    public  int singlenumber(int []A)
    {
        if(A==null||A.length<=0)
            return 0;
        int result = A[0];
        for(int i=0;i<A.length-1;i++)
        {
             result = result^A[i+1];
        }
        return result;
    }
}