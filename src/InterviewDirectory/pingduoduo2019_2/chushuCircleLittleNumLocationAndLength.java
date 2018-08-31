package InterviewDirectory.pingduoduo2019_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/30.
 */
public class chushuCircleLittleNumLocationAndLength {
    //给出被除数和除数，求出循环小数的开始位置，（小数点之后的位数）和循环长度。

    //输入：1 3一个被除数和一个除数
    //输出：输出两个数，一个是循环开始的位置，一个是循环长度。

    //1 3
    //0 1

    //思路：每次以余数判断，若有余数相等，那么以后每次余数都会以同样的再出现一次，
    // 所以有余数相等的话，就停止，记录余数结束的位置和开始的位置，就知道余数长度和开始位置。
    public static void main(String[] args)
    {
        Scanner sc  =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        //a/b
        int []arr = new int[1000000];//记录余数出现的大小与频次
        int n = 1;//记录索引
        int start = 0;
        int len = 0;
        a = a%b;
        while (true)
        {
            if(a==0)
            {
                start = arr[a];
                len = n-start;
                break;
            }
            if(arr[a]!=0)
            {
                start = arr[a];
                len = n-start;
                break;
            }
            arr[a] = n;
            n++;
            a = (a*10)%b;
        }
        System.out.println(start-1+" "+len);
    }


    //45 7
        //0 6



//25 6
//1 1
//    static int max = (int) Math.pow(10,6)+10;
//    static int [] ok = new int[max];
//    public static void main(String[] args)
//    {
//        Scanner sc  =new Scanner(System.in);
//        Arrays.fill(ok,-1);
//        int b = sc.nextInt();
//        int a = sc.nextInt();
//        b= b%a;
//        int n  = 0;
//        int c,d;
//        while (true)
//        {
//            if(b==0)
//            {
//                c=n;
//                d= 0;
//                break;
//            }
//            if(ok[b]!=-1)
//            {
//                c= ok[b];
//                d = n-c;
//                break;
//            }
//            ok[b] = n;
//            n++;
//            b = (b*10)%a;
//        }
//        System.out.printf("%d %d\n",c,d);
//    }

}