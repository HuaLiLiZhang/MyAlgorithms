package InterviewDirectory.LeetCode;

import java.util.ArrayList;

/**
 * Created by huali on 2018/7/7.
 */
public class minimumTotalArrayList {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

        if(triangle==null||triangle.size()<=0)
            return 0;
        int []dp = new int[triangle.size()];
        int nrow = triangle.size();
        int cols = triangle.get(nrow-1).size();
        for(int i=0;i<triangle.get(nrow-1).size();i++)
        {
            dp[i]=triangle.get(nrow-1).get(i);
        }
        for(int i = triangle.size()-2;i>=0;i--)
        {
            ArrayList<Integer> arr = triangle.get(i);
            for(int j=0;j<arr.size();j++)
                dp[j] = Math.min(arr.get(j)+dp[j],arr.get(j)+dp[j+1]) ;
        }
        return dp[0];
    }

    public static  void  main(String[]args)
    {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ArrayList<Integer> a3 = new ArrayList<>();
        a1.add(-1);
        a2.add(3);
        a2.add(2);
        a3.add(1);
        a3.add(-2);
        a3.add(-1);
        arr.add(0, a1);
        arr.add(1, a2);
        arr.add(2, a3);

        minimumTotalArrayList min = new minimumTotalArrayList();
        int minsum = min.minimumTotal(arr);
        System.out.println(minsum);


    }
}