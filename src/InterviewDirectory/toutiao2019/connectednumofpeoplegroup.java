package InterviewDirectory.toutiao2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/12.
 */
public class connectednumofpeoplegroup {

//    """
//相当于是一个求二值矩阵联通域的题。要求得出连通域个数和最大的连通域。
//使用的方法是：
//首先遍历数组，遇到一个“1”就将其位置的元素值标记为1。
//然后将1周围的8邻域遍历，寻找有没有值为“1”的，如果有，那么将其标记为1，并调用solve。
//"""
//"""

//10,10
//0,0,0,0,0,0,0,0,0,0
//0,0,0,1,1,0,1,0,0,0
//0,1,0,0,0,0,0,1,0,1
//1,0,0,0,0,0,0,0,1,1
//0,0,0,1,1,1,0,0,0,1
//0,0,0,0,0,0,1,0,1,1
//0,1,1,0,0,0,0,0,0,0
//0,0,0,1,0,1,0,0,0,0
//0,0,1,0,0,1,0,0,0,0
//0,1,0,0,0,0,0,0,0,0
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in) ;
        String[] stemp = sc.nextLine().split(",");
        int M = Integer.parseInt(stemp[0]);
        int N = Integer.parseInt(stemp[1]);
        int [][] arr = new int[M][N];
        for(int i = 0;i<M;i++)
        {
            stemp = sc.nextLine().split(",");
            for(int j=0;j<N;j++)
            {
                arr[i][j] = Integer.parseInt(stemp[j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        int countnum = 0;
        int max = 0;
        for(int i = 0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(arr[i][j]==1)
                {
                    int count = solve(arr, i,j);
                    list.add(count);
                    if(max<count)
                        max = count;
                    countnum++;
                }

            }
        }
        System.out.println(countnum+","+max);
    }

    private static int solve(int[][] arr,int i, int j) {

        if(arr[i][j]==0)
            return 0;
        int count= 1;
        arr[i][j] = 0;
        if(i+1<arr.length)
        {
            count += solve(arr, i+1, j);
        }
        if(i-1>=0)
        {
            count += solve(arr, i-1,j);
        }
        if(j-1>=0)
        {
            count += solve(arr, i,j-1);
        }
        if(j+1<arr[0].length)
        {
            count += solve(arr, i,j+1);
        }
        if(i+1<arr.length&&j+1<arr[0].length)
        {
            count += solve(arr, i+1,j+1);
        }
        if(i-1>=0&&j-1>=0)
        {
            count += solve(arr, i-1,j-1);
        }
        if(i-1>=0&&j+1<arr[0].length)
        {
            count += solve(arr, i-1,j+1);
        }
        if(i+1<arr.length&&j-1>=0)
        {
            count += solve(arr, i+1,j-1);
        }
        return count;
    }
}