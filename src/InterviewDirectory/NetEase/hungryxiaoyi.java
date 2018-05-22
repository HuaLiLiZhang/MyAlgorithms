package InterviewDirectory.NetEase;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/21.
 */
public class hungryxiaoyi {
//    小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。
// 最开始小易在一个初始位置x_0。
// 对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。
// 因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。
// 贝壳总生长在能被1,000,000,007整除的位置
// (比如：位置0，位置1,000,000,007，位置2,000,000,014等)。
// 小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
//输入描述:
//输入一个初始位置x_0,范围在1到1,000,000,006
//
//
//输出描述:
//输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
//
//输入例子1:
//125000000
//
//输出例子1:
//1

    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int count = 0;
            int n = sr.nextInt();
            //int [] arr = new int[Integer.MAX_VALUE];
            if(n==0||n%1000000007==0)
                System.out.println(0);
            else {
            //    一般思路 4 * x + 3或者8 * x + 7
                // 都是2*x+1 做两次2（2*x+1）+1=4 * x + 3或者做三次2*(2（2*x+1）+1)+1 = 8 * x + 7
            //    可以统计做了多少次2*x+1，在求3和2的和的最小值
                while (n!=0&&count<=300000)
                {
                    n = (2*n+1)%1000000007;
                    count++;
                }
                int time = (count+2)/3;
                System.out.println(time>100000 ?-1:time);

            }

        }
        sr.close();

    }



}