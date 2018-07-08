package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/6.
 */
public class canCompleteCircuit1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||gas.length<=0)
            return -1;
        int sum = 0;
        for(int i=0;i<gas.length;i++)
        {
            if(gas[i]<cost[i])
                continue;

            int j = (i+gas.length)%gas.length;
            while (true)
            {
                sum += gas[j]-cost[j];
                if(sum<0)
                    break;
                j = (j+1)%gas.length;
                if(j==i)
                    return i;
            }
            sum = 0;
        }
        return -1;
    }
}