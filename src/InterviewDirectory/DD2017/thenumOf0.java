package InterviewDirectory.DD2017;

import java.util.Scanner;

/**
 * Created by huali on 2018/6/7.
 */
public class thenumOf0 {
    //输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
    //输入描述:
    //输入为一行，n(1 ≤ n ≤ 1000)
    //
    //
    //输出描述:
    //输出一个整数,即题目所求
    //
    //输入例子1:
    //10
    //
    //输出例子1:
    //2
    public static void main(String []args) {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int count =0;
        while ((n/=5)!=0)
            count+=n;
        System.out.println(count);



    }

}