package InterviewDirectory.neteaseGame;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/25.
 */
public class themaxSum {
//    在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，
// 四种方向的直线连续D个数字的和里面最大的值
//输入描述:
//每个测试输入包含1个测试用例，第一行包括两个整数 N 和 D :
//3 <= N <= 100
//1 <= D <= N
//接下来有N行，每行N个数字d:
//0 <= d <= 100
//
//
//输出描述:
//输出一个整数，表示找到的和的最大值
//
//输入例子1:
//4 2
//87 98 79 61
//10 27 95 70
//20 64 73 29
//71 65 15 0
//
//输出例子1:
//193


    public static void  main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
           int N = sr.nextInt();
           int D = sr.nextInt();
           int [][]arr = new int[N][N];
           for(int i=0;i<N;i++)
           {
               for(int j=0;j<N;j++)
               {
                   arr[i][j] = sr.nextInt();
               }
           }
           int max= 0;

            //这个是一行一行的求求最大值。
            for (int i = 0; i < N; ++i)
            {
                for (int start = 0; start <= N-D; ++start)
                //对列进行移动，每移动一次，就计算D个数的和，直到N-D为止。
                {
                    int sum=0;
                    for (int k = 0; k < D; ++k)
                    {
                        sum+=arr[i][start+k];
                    }
                    max = Math.max(max, sum);
                }
            }

            //一列一列的求最大值。
            for (int i = 0; i < N; ++i)
            {
                for (int start = 0; start <= N-D; ++start)
                {
                    //对行进行移动，每移动一次，就计算D个数的和，直到N-D为止。
                    int sum=0;
                    for (int k = 0; k < D; ++k)
                    {
                        sum+=arr[start+k][i];
                    }
                    max = Math.max(max, sum);
                }
            }

            //按照负对角线进行相加。//
            for(int i=0;i<N;i++)
            {
                //按照列

                for(int j=0;j<N;j++)
                {
                    int temp = 0;
                   if(i+D-1>=0&&i+D-1<N&&j-D+1>=0&&j-D+1<N)
                   {
                       for (int k = 0; k < D; ++k)
                       {
                           temp += arr[i+k][j-k];
                       }
                       max = Math.max(max, temp);
                   }
                }
                //max = Math.max(max, temp);
            }


            //根据正的对角线进行相加。00 11 22 33   \\
            for(int i=0;i<N;i++)
            {
                //按照列
                //int temp = 0;
                for(int j=0;j<N;j++)
                {
                    int temp = 0;
                    if(i+D-1>=0&&i+D-1<N&&j+D-1>=0&&j+D-1<N)
                    {
                        for (int k = 0; k < D; ++k)
                        {
                            temp += arr[i+k][j+k];
                        }
                        max = Math.max(max, temp);
                    }
                }
                //max = Math.max(max, temp);
            }



            System.out.println(max);

        }
        sr.close();
    }
}