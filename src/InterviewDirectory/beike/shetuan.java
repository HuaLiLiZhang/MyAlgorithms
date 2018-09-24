package InterviewDirectory.beike;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/18.
 */
public class shetuan {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [][] arr = new int[N][4];
        for(int i =0;i<N;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = i+1;
            arr[i][3] = 0;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int count = 1;
        if(arr[0][1]>arr[N-1][1])
            System.out.println(0);
        else
        {
            int temp = 0;
            for(int i =1;i<N;i++)
            {
                if(temp<N&&arr[temp][1]<=arr[i][0])
                {
                    count++;
                    temp = i;

                }
                else  if(arr[temp][1]>arr[i][1]){
                    temp = i;

                } else if(arr[temp][1]<arr[i][1])
                {
                    arr[i][3] = 1;
                }
            }
        }

        if(count==N)
        {
            System.out.println(count);
            for(int i =1;i<=N;i++)
                System.out.print(i+" ");
        }
        else if(N-count==1)
        {
            System.out.println(N - count);
            for(int i=0;i<N;i++)
            {
                if(arr[i][3]==1)
                    System.out.print(arr[i][2]+" ");
            }
        } else if(N-count>1)
            System.out.println(0);

    }
}