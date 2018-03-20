package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/20.
 */
public class CoinsSUmNUm {
    public int coins1(int[]arr,int aim)
    {
        if(arr==null||arr.length==0||aim<0)
            return 0;
        return process1(arr,0,aim);
    }
    public int process1(int[]arr,int index ,int aim)
    {
        int res = 0;
        if(index == arr.length)
        {
            res=aim==0?1:0;
        }else
        {
            for(int i=0;arr[index]*i<=aim;++i)
            {
                res+=process1(arr,index+1,aim-arr[index]*i);
            }
        }
    }
}