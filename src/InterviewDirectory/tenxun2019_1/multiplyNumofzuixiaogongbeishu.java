package InterviewDirectory.tenxun2019_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/16.
 */
public class multiplyNumofzuixiaogongbeishu {
    //欧几里德算法
    //欧几里德算法又称辗转相除法，用于计算两个整数a,b的最大公约数。其计算原理依赖于下面的定理：
    //
    //定理：gcd(a,b) = gcd(b,a mod b)
    //
    //证明：a可以表示成a = kb + r，则r = a mod b
    //假设d是a,b的一个公约数，则有
    //d|a, d|b，而r = a - kb，因此d|r
    //因此d是(b,a mod b)的公约数
    //
    //假设d 是(b,a mod b)的公约数，则
    //d | b , d |r ，但是a = kb +r
    //因此d也是(a,b)的公约数
    //
    //因此(a,b)和(b,a mod b)的公约数是一样的，其最大公约数也必然相等，
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {// sc.hasNex t()判断是否有输入，有则为TRUE，反之则为FALSE
            int n = sc.nextInt();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for(int i = 1;i<=n+1;i++)
            {
                list2.add(i);
            }
            long bei1 = n+1;
            long bei2 = commonMultiple(list2);
            int i = n+1;
            while (true)
            {
                if(bei1==bei2)
                    break;
                i++;
                list1.add(i);
                list2.add(i);
                bei1 = commonMultiple(bei1,i);
                bei2 = commonMultiple(bei2,i);
            }
            System.out.println(i);
        }



    }

 /*   public static long mutipybeishu(List<Integer> list)
    {
        int max=0;
        for(int i=0;i<list.size();i++){
            if(max<list.get(i)){
                max=list.get(i);	//先找出这n个数的那个最大的数
            }
        }
        for(int i=max;;i++){
            boolean b=true;	//设置标记
            for(int j=0;j<list.size();j++){
                if(max%list.get(j)!=0){
                    b=false;
                    //只要有一个数不能整除max则令标记为false
                }
            }
            max++;
            if(b){	//如果标记为true说明该max可以整除这n个数
                //则max为最小公倍数
                //System.out.println(i);
                break;	//跳出循环
            }
        }
        return max;

    }*/

    public static long commonDivisor(long n, long m) {// 求两个数的最大公约数
// 辗转相除法是用大的除以小的，如果N<M,第一次相当N与M值交换(例如2%3，商0余2)
        while (n % m != 0) {
            long temp = n % m;
            n = m;
            m = temp;
        }
        return m;


    }


    public static long commonMultiple(long n, long m) {// 求两个数的最小公倍数
// 两个数相乘等于这两个数的最大公约数和最小公倍数的积。
        return n * m / commonDivisor(n, m);


    }


    public static long commonMultiple(List<Integer> list) {// 求多个数的最小公倍数
        long value = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            value = commonMultiple(value, list.get(i));
        }
        return value;


    }
}