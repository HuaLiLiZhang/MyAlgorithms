package InterviewDirectory.baidu2016;

import java.util.Scanner;

/**
 * Created by huali on 2018/6/2.
 */
public class Criminal_transfer {
//    C市现在要转移一批罪犯到D市，C市有n名罪犯，
// 按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。
// 现在为了方便管理，市长决定转移入狱时间连续的c名犯人，
// 同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式？
//
//输入描述:
//第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，
// 第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)
//
//
//输出描述:
//一行输出答案。
//
//输入例子1:
//3 100 2
//1 2 3
//
//输出例子1:
//2

    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int n= sr.nextInt();
            int t = sr.nextInt();
            int c = sr.nextInt();
            int []arr = new int[n];
            int count = 0;
            int sum = 0;
            for(int i=0;i<n;i++)
            {
                arr[i]=sr.nextInt();
            }

            for(int i=0;i<=c-1;i++)
            {
                sum +=arr[i];
            }
            for(int i= c;i<n;i++)
            {
                if(sum<=t)
                {
                    count++;
                }
                sum = sum+arr[i]-arr[i-c];
            }
            if(sum<=t)
                count++;
            System.out.println(count);

        }
        sr.close();
    }
}