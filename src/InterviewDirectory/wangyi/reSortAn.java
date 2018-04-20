package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/20.
 */
public class reSortAn {
    //思路：
    //
    //发现一个4的倍数可以带走两个位置， X个2可以带走 x-1个位置
    //
    //X 4 X  4 X
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int t = sr.nextInt();
        while (sr.hasNext())
        {
            int n = sr.nextInt();
            //int [] an = new int[n];
            int four = 0, two=0;
            for(int i =0;i<n;i++)
            {
                int num = sr.nextInt();
                if(num%4==0)
                    four++;   //能被4整除的，能带走2*four+1个位置
                else if(num%2==0)
                    two++;
            }
            two = Math.max(two-1,0);  //能被2整除的能带走two-1个位置
            if(four*2+1+two>=n)
                System.out.println("Yes");
            else
                System.out.println("No");
            t--;
            if(t==0)
                break;
        }sr.close();
    }
}