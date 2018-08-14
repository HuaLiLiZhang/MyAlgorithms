package InterviewDirectory.wangyi2019;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/11.
 */
//测试用例：
//10
//1 6 3 8 87 343 34 68 12 10
//6
//34 56 124 3 15 889
//5
//5
//6
//2
//4
public class applemain {
    //时间复杂度太高只通过30%。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] num = new int[n];
        int [] sum = new int[n];
        sum[0]=0;
        for(int i=0;i<n;i++)
        {
            num[i] = sc.nextInt();
            if(i==0)
                sum[i]=num[i];
            else
                sum[i] = sum[i-1]+num[i];
        }
        int m = sc.nextInt();
        int[] qe = new  int [m];
        for(int i = 0;i<m;i++)
        {
            qe[i] = sc.nextInt();
        }
        int k = 0;
        long timestart = System.currentTimeMillis();
        for(int j = 0;j<m;j++)
        {
            if(qe[j]>sum[n-1])
            {
                System.out.println(-1);
                continue;
            }
            while (k<n)
            {
                if(qe[j]<=sum[k])
                {

                    System.out.println(k+1);
                    break;
                }
                else
                    k++;
            }
            k=0;
        }
        double timeend = System.currentTimeMillis();
        System.out.println(timeend-timestart);

        //测试结果与时间：
        //5
        //5
        //6
        //2
        //4
        //-1
        //1.0
        //5
        //5
        //6
        //2
        //4
        //-1
        //0.0

        //下面改进，二分法
        int low = 0;
        int high = n;
        long timestart1 = System.currentTimeMillis();
        for(int i = 0;i<m;i++)
        {
            if(qe[i]>sum[high-1])
            {
                System.out.println(-1);
                continue;
            }
            while (low<high)
            {
                int mid = (low+high)/2;
                if(qe[i]>sum[mid]&&high-low>1)
                    low=mid;
                else if(qe[i]==sum[mid])
                {
                    System.out.println(mid+1);
                    break;
                }else if(qe[i]<sum[mid]&&high-low>1){
                    high = mid;
                } else {
                    System.out.println(high+1);
                    break;
                }
            }
            low = 0;
            high = n;
        }
        double timeend1 = System.currentTimeMillis();
        System.out.println(timeend1-timestart1);



//5
//1 3 6 9 10
//4 4 6 17 30
        //2
        //3
        //4
        //-1
    }

}