package InterviewDirectory.xunlei2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/12.
 */
public class AB17make7xiaoyu0 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int sum = 0;
            int idx = 0;
            for(int i = 6;i>=0;i--)
            {
                if(i*A+(7-i)*B<0)
                {
                    idx = i;
                    break;
                }
            }
            //10 -68
            //14
            //10 -61
            //28
            //30 -15
            //15
            sum = (A*idx+B*(7-idx))*2;
            if(idx>=3)
                sum += 3*A;
            else
                sum += idx*A+(3-idx)*B;
            System.out.println(sum);
        }


        //int[] dp = new int[17];
        //
        //B = -B;
        //int count = B/A>6?6:(B/A);
        //
        //if(B%A==0&&B/A==6){
        //    count=5;
        //}
        //for(int i = 0;i<count;i++){
        //    dp[i] = A;
        //}
        //dp[count] = -B;
        //int sum = count*A-B;
        //while(count<16){
        //    count++;
        //    if(count>=7){
        //        int ttt = sum+A-dp[count-7];
        //        if(ttt<0){
        //            dp[count] = A;
        //            sum = sum+A-dp[count-7];
        //        }else{
        //            dp[count] = -B;
        //            sum = sum-B-dp[count-7];
        //        }
        //    }else{
        //        if(sum+A<0){
        //            dp[count] = A;
        //            sum = sum+A;
        //        }else{
        //            dp[count] = -B;
        //            sum = sum-B;
        //        }
        //    }
        //
        //}
        //
        //int sunum = 0;
        //for(int i = 0;i<17;i++){
        //    sunum+=dp[i];
        //}
        //System.out.println(sunum);
    }
}