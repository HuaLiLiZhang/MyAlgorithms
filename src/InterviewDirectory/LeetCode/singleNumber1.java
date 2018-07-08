package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/6.
 */
public class singleNumber1 {
    public int singleNumber(int[] A) {
        if(A==null||A.length<=0)
            return 0;

        int result = 0;
        for(int i=0;i<32;i++)
        {
            int bitnum = 0;
            for(int j=0;j<A.length;j++)
            {
                bitnum +=A[j]>>i&1;
            }
            result |=bitnum%3<<i;
        }
        return result;
    }
}