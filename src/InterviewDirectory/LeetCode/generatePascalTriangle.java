package InterviewDirectory.LeetCode;

import java.util.ArrayList;

/**
 * Created by huali on 2018/7/7.
 */
public class generatePascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        if(numRows<0)
            return arr;
        for(int i=0;i<=numRows;i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            if(i>1)
            {
                for(int j=1;j<i;j++)
                {
                    temp.add(arr.get(i-1).get(j)+arr.get(i-1).get(j-1));
                }
            }
            if(i>0)
                temp.add(1);
            arr.add(temp);
        }
        return arr;
    }
}