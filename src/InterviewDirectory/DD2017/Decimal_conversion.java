package InterviewDirectory.DD2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/6/7.
 */
public class Decimal_conversion {
//    给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
//输入描述:
//输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
//
//
//输出描述:
//为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
//
//输入例子1:
//7 2
//
//输出例子1:
//111
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        int num = sr.nextInt();
        int index = sr.nextInt();
        List<Character> list = new ArrayList<>();
        boolean isfu = num>=0;
        num = Math.abs(num);
        while (num!=0)
        {
            int i = num%index;
            if(i>=0&&i<=9)
                list.add((char)(i+48));
            else
                list.add((char)(i+65-10));
            num = num/index;
        }

        if(!isfu)
            System.out.print("-");
        for(int i=list.size()-1;i>=0;i--)
        {

            System.out.print(list.get(i));
        }
        System.out.println();
    }
}