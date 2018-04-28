package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/28.
 */
public class MAXOddNUmber {
    //算法复杂度过高
    //public static void main(String []args)
    //{
    //    Scanner sr = new Scanner(System.in);
    //    while (sr.hasNext())
    //    {
    //        int x = sr.nextInt();
    //        int num = 0;
    //        for (int i = 1;i<=x;i++)
    //        {
    //            if(i%2!=0)
    //                num += i;
    //            else
    //                num +=f(i);
    //        }
    //        System.out.println(num);
    //    }
    //    sr.close();
    //}
    //
    //public static int f(int x)
    //{
    //    for(int i =2;i<=Math.sqrt(x);i+=2)
    //    {
    //        //x = x/2;
    //        if((x/i)%2!=0)
    //            return x/i;
    //    }
    //    return 1;
    //}



    //算法复杂度较低的
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        long num = sr.nextInt();
        long sum = 0;
        for (long i = num; i > 0; i = i / 2) {
            long temp = (i + 1) / 2;
            sum += temp * temp;
        }
        System.out.println(sum);
    }
    //总体思路：
    //因为奇数的最大奇数约数就是自己啊，对于偶数我们只能一直除2直到得到一个奇数即为最大奇数约数
    // 
    //比如1 2 3 4 5 6 7 8 9 10
    //即n=10 ，此时奇数有1 3 5 7 9 我们把这几个奇数相加然后n/2
    //得到第二轮序列序列 1 2 3 4 5 分别对应上次的2 4 6 8 10 五个偶数，这是我们再加1 3 5
    //依次类推
    // 
    //细节问题：
    //当n为偶数，就有n/2个奇数，根据等差数列求和公式 即(（首项+末项）*项数)/2,我们知道n/2个奇数和为((1+n-1)*n/2)/2,
    //即为(n/2) * (n/2),此时n为偶数，因此 (n/2) * (n/2) = ((n+1)/2)  *  ((n+1)/2)
    // 
    //当n为奇数，有(n+1)/2个奇数，此时奇数和为((n+1)/2)  *  ((n+1)/2)
    //因此两种情况可以用一个等式来总结

    ////找规律：假设n=16
    ////while第一次：sum+=1+3+5+7+9+11+13+15（所有奇数的最大奇约数为本身）,同时n减半（/2）为8
    ////while第二次：sum+=1+3+5+7（对应的是16,14,12,10的最大奇公约数）,同时n减半为4
    ////while第三次：sum+=1+3（对应的是8,6的最大奇公约数），同时n减半为2
    ////while第四次：sum+=1（对应的是4的最大奇公约数），同时n减半为1
    ////while第五次：sum+=1（对应的是2的最大奇公约数），同时n减半为0
}