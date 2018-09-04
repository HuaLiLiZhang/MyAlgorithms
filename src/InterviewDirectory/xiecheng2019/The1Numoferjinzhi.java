package InterviewDirectory.xiecheng2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/4.
 */
public class The1Numoferjinzhi {
    //二进制中1的个数，就是利用本身与本身减-1相与，那么每次1的个数都会少1个。
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count =0 ;
        while (n!=0){
            count++;
            n = (n-1)&n;
        }
        System.out.println(count);
    }

}