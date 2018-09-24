package InterviewDirectory.Keep2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/6.
 */
public class medicine_bag01 {
//10 5
//1 5
//2 4
//3 3
//4 2
//5 1
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        int [][] arr = new int[N][2];
        for(int i = 0;i<N;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            sc.nextLine();
        }
        //Arrays.sort(arr, new Comparator<int[]>() {
        //    @Override
        //    public int compare(int[] o1, int[] o2) {
        //        return o1[1]-o2[1];  //按第二列价值排个序。
        //    }
        //});
        int [][] dp = new int[N+1][sum+1];
        int [][] path = new int[N+1][sum+1];
        for(int i = 1;i<=N;i++)
        {
            for(int j = 1;j<=sum;j++)
            {
               if(j<arr[i-1][0])
                   dp[i][j] = dp[i-1][j];
               else
               {
                   if(dp[i-1][j]<dp[i-1][j-arr[i-1][0]]+arr[i-1][1])
                       path[i][j] = 1;
                   dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i-1][0]]+arr[i-1][1]);
               }
            }
        }
        System.out.println(dp[N][sum]);

        int i = N;
        int j = sum;
        while (i>0&&j>0)
        {
            if(path[i][j]==1)
            {
                System.out.print(1+" ");
                j -=arr[i-1][0];
            }
            else
            {
                i--;
                System.out.print(0+" ");
            }
        }


    //    改进版。只使用一维数组。
    //    int [] f = new int[sum+1];
    //    for(int i = 0;i<N;i++)
    //    {
    //        for (int j = sum;j>=0;j--)
    //        {
    //           if(j>=arr[i][0])
    //               f[j] = Math.max(f[j], f[j-arr[i][0]]+arr[i][1]);
    //        }
    //    }
    //    System.out.println(f[sum]);

    }
}