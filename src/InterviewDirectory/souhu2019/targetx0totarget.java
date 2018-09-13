package InterviewDirectory.souhu2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/13.
 */
public class targetx0totarget {
    //有个无限长的x轴，
    // 你站在原点x=0处，要去往的目标点是x轴上的任意一个整数点，
    // 但是每次移动，只能向左或者向右，而且第N次移动就移动N的距离
    //现给定一个目标点target，要求为了到达目标点，移动最少的次数。
    //举例说明：
    //target ：3 ，最少移动2次，第一次到1，第二次到3
    //target ：2 ，最少移动3次，第一次到1，第二次到-1，第三次到3.

    //测试用例：
    //通过：
    //3
    //2

    //2
    //3

    //4
    //4

    //5
    //6

    //6
    //3

    //8
    //7

    //7
    //5
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int N = sc.nextInt();
            int sum = 0;
            int count = 0;
            for(int i = 1;;i++)
            {
                if(sum==N)
                {
                    System.out.println(count);
                    break;
                }
                if(sum+i<=N)
                {
                    sum +=i;
                    count++;
                }else {
                    sum -=i;
                    count++;
                }
            }
            //if(sum!=N)
            //    System.out.println(-1);
        }
    }
}