package InterviewDirectory.nowcode_middle.LinkedList1;

import java.util.Arrays;

/**
 * Created by huali on 2018/10/14.
 */
public class Kdencifang {
    //求K的n次方
    public static void main(String[] args)
    {
         int n = 15;
         int K = 10;
         int binary = Integer.parseInt(Integer.toBinaryString(n));
         int len = Integer.toBinaryString(n).length();
         int [] arr = new int[len];
         Arrays.fill(arr,10);
         int y = 1;
         if((binary&1)==1)
             y = arr[0];
         for(int i = 1;i<len;i++)
         {
             arr[i] = arr[i-1]*arr[i-1];
             if(((binary>>i)&1)==1)
             {
                 y *= arr[i];
             }
         }

        System.out.println(y);

    }
}