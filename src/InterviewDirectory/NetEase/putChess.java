package InterviewDirectory.NetEase;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/3.
 */
public class putChess {
    //小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。
    // 同一个格子允许放置多个棋子。
    // 每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。
    // 小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.
    //
    //输入描述:
    //输入包括三行,第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数
    //第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
    //第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)

    //public static void main(String[] args) {
    //    Scanner sr = new Scanner(System.in);
    //
    //    while (sr.hasNext())
    //    {
    //        int n = sr.nextInt();
    //        int[] x = new int[n];
    //        int[] y = new int[n];
    //        for(int i =0;i<n;i++)
    //        {
    //            x[i] = sr.nextInt();
    //        }
    //        for(int i =0;i<n;i++)
    //        {
    //            y[i] = sr.nextInt();
    //        }
    //
    //        int count = 0;
    //        for(int j= 0;j<n;j++)
    //        {
    //            if(j==0)
    //                System.out.print(j);
    //            else
    //            {
    //                count=0;
    //                double xequal = e(x, j);
    //                double yequal = e(y, j);
    //                for(int i=0;i<=j;i++)
    //                {
    //                    count += Math.abs(x[i]-xequal)+Math.abs(y[i]-yequal);
    //                }
    //                System.out.print(" "+count);
    //            }
    //        }
    //
    //    }
    //    sr.close();
    //}
    //
    //
    //public static double e(int []x, int i)
    //{
    //    double sum = 0;
    //    for(int j=0;j<=i;j++)
    //    {
    //        sum+=x[j];
    //    }
    //    return Math.round(sum/(i+1));
    //}


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] x = new int[size];
            int[] y = new int[size];
            for (int i = 0; i < size; i++) {
                x[i] = in.nextInt();
            }
            for (int i = 0; i < size; i++) {
                y[i] = in.nextInt();
            }
            int[] res = minOPs(size, x, y);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < size; i++) {
                result.append(String.valueOf(res[i]) + " ");
            }
            System.out.println(result.toString().trim());
        }
        in.close();
    }

    public static int[] minOPs(int size, int[] x, int[] y) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    pq.add(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
                }
                int resI = 0;
                int sum = 0;
                while (!pq.isEmpty()) {
                    sum += pq.poll();
                    res[resI] = Math.min(res[resI], sum);
                    resI++;
                }
                System.out.println(Arrays.toString(res));
            }
        }
        return res;
    }

}