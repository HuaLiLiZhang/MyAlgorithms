package InterviewDirectory.neteaseGame;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/25.
 */
public class runhose {
//    在一条无限长的跑道上，有N匹马在不同的位置上出发开始赛马。
// 当开始赛马比赛后，所有的马开始以自己的速度一直匀速前进。
// 每匹马的速度都不一样，且全部是同样的均匀随机分布。
// 在比赛中当某匹马追上了前面的某匹马时，被追上的马就出局。
// 请问按以上的规则比赛无限长的时间后，赛道上剩余的马匹数量的数学期望是多少
//输入描述:
//每个测试输入包含1个测试用例
//输入只有一行，一个正整数N
//1 <= N <= 1000
//
//
//输出描述:
//输出一个浮点数，精确到小数点后四位数字，表示剩余马匹数量的数学期望
//
//输入例子1:
//1
//2
//
//输出例子1:
//1.0000
//1.5000



    //其实这道题是数学题，因为赛道是无限长的所以这些马中速度最快的一定可以留下，
    // 如果只有一匹马那结果肯定是1，如果有两匹马，就需要出发的时候，
    // 速度快的在前，慢的在后，其概率是1/2，所以留下的马的期望是1+1/2；
    // 如果三匹马则按速度的快慢，第一快的马在赛道期望是1，
    // 第二快的有两种情况，期望是1/2，第三快的有三种情况：
    // 在1马前；在1马2马之间；在2马之后，则其期望是1/3 …………………………
    //
    //如果n匹马，则期望是1+1/2+1/3+......+1/n
    public static void  main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int N = sr.nextInt();
            double ex = 1;
            if(N==1)
                System.out.println(String.format("%.4f", ex));
            else
            {
                for(double i=2.0;i<N+1;i++)
                {
                    ex += 1/i;
                }
                System.out.println(String.format("%.4f", ex));
            }

        }
        sr.close();
    }
}