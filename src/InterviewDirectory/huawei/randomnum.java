package InterviewDirectory.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by huali on 2018/4/19.
 */
public class randomnum {
    public static void main(String [] args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNextInt())
        {
            TreeSet<Integer> set = new TreeSet<Integer>();
            int n = sr.nextInt();
            if(n>0&&n<1000)
            {
                for(int i=0;i<n;i++)
                {
                    int num = sr.nextInt();
                    while (num>1000||n<0)
                    {
                        num = sr.nextInt();
                    }
                    set.add(num);

                }
                for(Integer i:set)
                {
                    System.out.println(i);
                }
            }
        }
        sr.close();

    }
}