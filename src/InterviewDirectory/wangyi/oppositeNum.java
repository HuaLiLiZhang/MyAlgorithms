package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/20.
 */
public class oppositeNum {
    public static  void  main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int num = sr.nextInt();
            if(num<1||num>100000)
                break;
            int []  arr = new int[10];
            int i;
            for(i =0;num!=0;i++)
            {
                arr[i] = num%10;
                num = num/10;
            }
            int start = 0;
            int end = i-1;
            while (start<=i-1&&end>=0)
            {
                num += (arr[start]+arr[end])*(Math.pow(10, end));
                start++;
                end--;
            }
            System.out.println(num);

        }sr.close();
    }
}