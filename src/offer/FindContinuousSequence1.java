package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by huali on 2018/6/30.
 */
public class FindContinuousSequence1 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> array=new ArrayList<ArrayList<Integer>>();
        if(sum<3) {
            return array;
        }
        int small = 1;
        int big = 2;
        int middle = (1+sum)/2;
        int cursum = small+big;
        while (small<middle)
        {
            if(cursum==sum)
                printContiniousSequence(small,big,array);
            while (cursum>sum&&small<middle)
            {
                cursum-=small;
                small++;
                if(cursum==sum)
                    printContiniousSequence(small, big, array);
            }
            big++;
            cursum+=big;
        }
        return array;
    }

    private void printContiniousSequence(int small, int big, ArrayList<ArrayList<Integer>> array) {
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=small;i<=big;i++)
        {
            //System.out.println(i+",");
            arr.add(i);
        }
        array.add(arr);

        char[] ch = {'1','2'};
    }
}