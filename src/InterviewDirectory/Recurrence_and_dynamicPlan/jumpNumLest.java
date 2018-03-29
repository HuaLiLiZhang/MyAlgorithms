package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/29.
 */
public class jumpNumLest {
    public int jump1(int []arr)
    {
        if(arr==null||arr.length==0)
            return 0;
        int jump = 0;
        int cur = 0;
        int next =0;
        for(int i=0;i<arr.length;i++)
        {
            if(cur<i)
            {
                jump++;
                cur = next;
            }
            next = Math.max(next, i+arr[i]);
        }
        return jump;
    }
}