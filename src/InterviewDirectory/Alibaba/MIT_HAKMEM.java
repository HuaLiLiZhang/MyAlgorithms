package InterviewDirectory.Alibaba;

/**
 * Created by huali on 2018/4/14.
 */
public class MIT_HAKMEM {
    //这个算法的思路就是多项式消权，并且贯穿了整个算法推导和优化的过程。
    // 而第二步的必要条件则是对取模和幂运算关系的了解。
    // 优化的第一步用到了“提取公因式”思想，第二步则回归到了多项式的基本运算。
    //该算法实现的功能就是用来统计n的二进制表示中1个数量。

    //注：二进制数字添加0b标记，八进制数字添加0，十六进制数字添加0x。（0是零）

    public static void bitcount(int num)  //0...代表八进制，后面每一个数代表三位。
                                            //0x:代表十六进制。后面一位代表四位。比如：13 ：1101
    {
        int tmp = num - ((num>>1)&033333333333); //0... :代表八进制,033333333333
                        //011 011 011 011 011 011 011 011 011 011 011

        //System.out.println(num>>1);
        //System.out.println((num>>1)&033333333333);//0...：代表八进制

        tmp = tmp-((num>>2)&011111111111);  //代表 ：001 001 001 001 001 001 001 001 001 001 001

        //System.out.println(num>>2);
        //System.out.println((num>>2)&011111111111);

        tmp = (tmp + (tmp>>3))&030707070707;

        //System.out.println(tmp>>3);
        //System.out.println();
        tmp = tmp % 63;
        System.out.println(tmp);
    }

    //一般方法：
    public static void countbyte(int n)
    {
        int count =0;
        while (n!=0)
        {
            count += n&0x01;
            n>>=1;
        }
        System.out.println(count);

    }

    public static void countbyte1(int n)
    {
        int count =0;
        while (n!=0)
        {
            n = n&(n-1);
            count++;
        }
        System.out.println(count);

    }
}