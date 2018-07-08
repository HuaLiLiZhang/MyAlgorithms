package InterviewDirectory.LeetCode;

import java.util.ArrayList;

/**
 * Created by huali on 2018/7/7.
 */
public class getRowPascal {
    public ArrayList<Integer> getRow(int rowIndex) {
        if (rowIndex < 0){
            return null;
        }
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
        for(int i=0;i<rowIndex+1;i++)
        {        //rowindex从0开始，所以要加1.
            ArrayList<Integer> current = new ArrayList<>();
            current.add(1);
            if(i>1)
            {
                for(int j=1;j<i;j++)
                {
                    current.add(rst.get(i-1).get(j-1)+rst.get(i-1).get(j));
                }
            }
            if(i>0)
                current.add(1);
            rst.add(current);
        }
        return rst.get(rowIndex);

    }
}