package InterviewDirectory.wangyi2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/8/11.
 */
public class Mainwangyi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int result = 0;
        int[] sleep = new int[n];
        int[] minScore = new int[n];

        for(int i = 0;i<n ;i++){
            minScore[i] = in.nextInt();
        }
        for(int i = 0;i<n ;i++){
            sleep[i] = in.nextInt();

            //记录不睡觉时，能得到的 兴趣评分。
            if(sleep[i]==1){
                result+=minScore[i];
            }
        }

        int s = 0;
        int addmaxNum = 0;
        for(;s<n-k+1;s++)
        {
            int tempmax = 0;
            //唤醒小易一次，持续清醒的时间K，能获得的最大兴趣评分。
            for(int i = 0;i<k;i++)
            {
                if(sleep[s+i]!=1)
                {
                    tempmax +=minScore[s+i];
                }
            }
            //求唤醒一个窗口内兴趣值最大的评分。
            if(addmaxNum<tempmax)
                addmaxNum = tempmax;
        }
        //while(flag+k-1<n){
        //    int temp = 0;
        //    for(int i = 0;i<k;i++){
        //        if(sleep[flag+i]!=1){
        //            temp+=minScore[flag+i];
        //        }
        //    }
        //    if(temp>addNum){
        //        addNum = temp;
        //    }
        //    flag++;
        //}

        System.out.println(result+addmaxNum);
    }
}