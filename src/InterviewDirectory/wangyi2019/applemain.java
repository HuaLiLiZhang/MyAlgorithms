package InterviewDirectory.wangyi2019;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/11.
 */
public class applemain {
    //时间复杂度太高只通过30%。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] num = new int[n];
        int [] sum = new int[n];
        sum[0]=0;
        for(int i=0;i<n;i++)
        {
            num[i] = sc.nextInt();
            if(i==0)
                sum[i]=num[i];
            else
                sum[i] = sum[i-1]+num[i];
        }
        int m = sc.nextInt();
        int[] qe = new  int [m];
        for(int i = 0;i<m;i++)
        {
            qe[i] = sc.nextInt();
        }
        int i = 0;
        for(int j = 0;j<m;j++)
        {
            while (i<n)
            {
                if(qe[j]<=sum[i])
                {

                    System.out.println(i+1);
                    break;
                }
                else
                    i++;
            }
            i=0;
        }


        //LinkedList<Integer> list = new LinkedList<>();
        //list.add(1);
        //list.add(3);
        //list.add(2);
        //System.out.println(list.get(1));

    }
}