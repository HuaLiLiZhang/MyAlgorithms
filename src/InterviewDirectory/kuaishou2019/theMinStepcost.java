package InterviewDirectory.kuaishou2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/10.
 */
public class theMinStepcost {

    //走楼梯的价值为cost[i]，可以从0或者1开始。
   // 以后每次可以走两步或者一步。
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String [] temp = s.split(",");
        int [] cost = new int[temp.length];
        for(int i =0;i<cost.length;i++)
        {
            cost[i] = Integer.parseInt(temp[i]);
        }
//1,2
//1
//
//1
//1
//

        if(cost.length==1)
            System.out.println(cost[cost.length-1]);
        else if(cost.length==2)
            System.out.println(Math.min(cost[cost.length-1],cost[0]));
        else {
            int []dp = new int[cost.length];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for(int i = 2;i<dp.length;i++)
            {
                dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];  //等于i-1或者i-2位置上的dp加上cost[i]
            }
            System.out.println(Math.min(dp[dp.length-3],dp[dp.length-2])+cost[cost.length-1]);
        }
    }

//100,1,1,1,1,100,1,1,100,1
//6
    /*public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String [] temp = s.split(",");
        int [] cost = new int[temp.length];
        for(int i =0;i<cost.length;i++)
        {
            cost[i] = Integer.parseInt(temp[i]);
        }


        if(cost.length==1)
            System.out.println(cost[cost.length-1]);
        else if(cost.length==2)
            System.out.println(Math.min(cost[cost.length-1],cost[0]));
        else
        {
            int start = 1;
            if(cost[0]<cost[1])
                start = 0;
            int costmin = findcostmin(cost, start);
            System.out.println(costmin);
        }
        //int costmin2 = findcostmin(cost,1);
        //System.out.println(Math.min(costmin,costmin2));
    }

    private static int findcostmin(int[] cost, int i) {
        if(i>=cost.length)
            return 0;
        int count1 = cost[i] ;
        count1 += findcostmin(cost,i+1);
        int count2 = cost[i];
        count2 += findcostmin(cost,i+2);
        return Math.min(count1,count2);
    }*/
}