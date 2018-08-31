package InterviewDirectory.haoweilai2019;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/31.
 */
public class MaxASCsequence_OfArr {
//    最大升序的子序列怎么求，
//    输入： 5 1 3 4 9 7 6 8
//    输出： 1 3 4 7 8
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while (in.hasNext()) {
            try {
                list.add(in.nextInt());
            } catch (Exception e) {
                break;
            }
        }
        int [] dp = new int[list.size()];
        List<Integer> li = new ArrayList<>();
        for(int i = 0;i<list.size();i++)
        {
            dp[i] = 1;
            for(int j = 0;j<i;j++)
            {
                if(list.get(j)<list.get(i))
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
//5 1 3 4 9 7 6 8
//5 个
//[1, 3, 4, 6, 8]


        //有点不对，算了,还是坚持写一下，写了一天代码，头晕，啊哈哈哈
        //5 2 3 8 4 6 9 5 6 8 7
        //^D
        //6
        //[2, 3, 4, 6, 9, 5, 6, 7] 错的

        //5 2 3 8 4 6 9 5 6 8 7
        //^D
        //6
        //[2, 3, 4, 6, 6, 7]  //现在对了 。。哈哈


        int res = 0;
        for(int i = 0;i<list.size();i++)
        {
            int index = i;
            while (i<list.size()-1&&(dp[index]==dp[i+1]||dp[index]>=dp[i+1]))
            {
                i++;
            }
            li.add(list.get(i));
            if(res<dp[i])
                res = dp[i];
        }
        System.out.println(res);
        System.out.println(li);

    }














 /*   public static void main(String[] args)
    {
        int[]arr = {5,1,3,4,9,7,6,8};

        int [] dp = new int[arr.length];
        for(int i = 0;i<arr.length;i++)
        {
            int count = 0;
            dp[i] = 1;
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i])
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                else {
                    count = dp[i];
                }
            }
        }
        int maxlength =0;
        for(int i =0;i<dp.length;i++)
        {
            if(maxlength<dp[i])
                maxlength = dp[i];
        }
        System.out.println(maxlength);
    }*/

}