package InterviewDirectory.toutiao2019;

import java.util.*;

/**
 * Created by huali on 2018/8/14.
 */

//"""
//input:
//3
//10
//0 5 2 7 6 9
//ouput: 2
//input:
//3
//10
//0 3 3 7 7 0
//output:3
//"""

//    4 10
//0 4 0 2 3 7 7 9
//3
//    6 10
//0 4 0 2 0 1 1 2 2 7 6 9
//3
public class maxLiveNumber {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [][] arr = new int[N][2];
        for(int i = 0;i<N;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int max = 1;
        int j = 0;
        for(int i = 1;i<N;i++)
        {
            if(arr[j][1]<=arr[i][0])
            {
                max++;
                j = i;
            }else if(arr[j][1]>arr[i][1])
            {
                j = i;
            }
        }
        System.out.println(max);

    }

}