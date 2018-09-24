package InterviewDirectory.haoweilai2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/28.
 */
public class numStringcanchuyi3Num {

    //题目：

    //一个数字串可以被拆成多个数字串，列如12345拆成12 3 45或者123 45，
    // 给定一个正整数的数字串n,求n拆开后的数能被3整除的最大数量m是多少（0,也算能被3整除）
    //12 3 45 m = 3;
    //123 45 m= 2; 最大m=3

    //思路：
    // 一个数字串能被3整除，从第一个数字开始，如果能被3整除就继续循环移动到下一个数字，
    // 如果不能被3整除，那就看前两位的位数相加，比如（12）能被3整除，或者是第二位能被3整除（13），那么结果数就加1，i+1,继续循环
    //如果前两位不能被3整除，那么往后移动一位肯定，前三位肯定能被3整除，比如前两位被3整除余数的情况为：
    //1 1  若第3位是1，整个前三位的数构成的数，能被3整除， 若第3位是2，那么后两位构成的数能被3整除。
    //1 2  能被3整除
    //2 1  能被3整除
    //2 2  若第3位是1，后两位构成的数，能被3整除， 若第3位是2，那么后三位构成的数能被3整除。
    //故只要前两个数不满足被3整除，那么前三个数一定满足能被3整除。
    public static void main(String[] args)
    {
        //31473
        //3

        //12345
        //3
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int count = 0;
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if((ch-'0')%3==0)
            {
                count++;
            }else {
                if(i+1<s.length()) {
                    char ch1 = s.charAt(i + 1);
                    if(((ch-'0')+(ch1-'0'))%3==0||(ch1-'0')%3==0)
                    {
                        i++;
                        count++;
                    }else if(i+2<s.length())
                    {
                        i+=2;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }


    //public static void main(String[] args)
    //{
    //    Scanner in = new Scanner(System.in);
    //    String s = in.nextLine();
    //
    //    int count = 0;
    //    for(int  i = 0;i<s.length();i++){
    //        char ch = s.charAt(i);
    //        if((ch-'0')%3==0){
    //            count++;
    //        }else{
    //            if(i+1<s.length()){
    //                char cht = s.charAt(i+1);
    //                if(((ch-'0')+(cht-'0'))%3==0||(cht-'0')%3==0){
    //                    i++;
    //                    count++;
    //                }else{
    //                    if(i+2<s.length()){
    //                        i+=2;
    //                        count++;
    //                    }
    //                }
    //            }
    //        }
    //    }
    //    System.out.println(count);
    //}
}