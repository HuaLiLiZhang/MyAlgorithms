package InterviewDirectory.Alibaba;

/**
 * Created by huali on 2018/4/14.
 */
public class MIT_HAKMEM {
    //这个算法的思路就是多项式消权，并且贯穿了整个算法推导和优化的过程。
    // 而第二步的必要条件则是对取模和幂运算关系的了解。
    // 优化的第一步用到了“提取公因式”思想，第二步则回归到了多项式的基本运算。
    //该算法实现的功能就是用来统计n的二进制表示中1个数量。

    public static void bitcount(int num)
    {
        int tmp = num - ((num>>1)&033333333333)-((num>>2)&011111111111);
        tmp = (tmp + (tmp>>3))&030707070707;
        tmp = tmp % 63;
        System.out.println(tmp);
    }
}