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

            if(sleep[i]==1){
                result+=minScore[i];
            }
        }

        int s = 0;
        int addmaxNum = 0;
        for(;s<n-k+1;s++)
        {
            int tempmax = 0;
            for(int i = 0;i<k;i++)
            {
                if(sleep[s+i]!=1)
                {
                    tempmax +=minScore[s+i];
                }
            }
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