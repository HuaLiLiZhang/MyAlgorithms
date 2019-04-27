package InterviewDirectory.aaaa_practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by huali on 2019/4/18.
 */
public class zhengfucross {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine())
        {
            String sl = sc.nextLine();
            String [] str = sl.split(" ");
            Queue<Integer> zheng = new LinkedList<>();
            Queue<Integer> fu = new LinkedList<>();
            for(int i = 0;i<str.length;i++)
            {
                if(Integer.valueOf(str[i])>0)
                    zheng.add(Integer.valueOf(str[i]));
                else
                    fu.add(Integer.valueOf(str[i]));
            }
            while (!zheng.isEmpty()&&(!fu.isEmpty()))
            {
                System.out.print(zheng.poll());
                System.out.print(" ");
                System.out.print(fu.poll());
                System.out.print(" ");
            }
            while (!zheng.isEmpty())
            {
                System.out.print(zheng.poll());
                System.out.print(" ");
            }
            while (!fu.isEmpty())
            {
                System.out.print(fu.poll());
                System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();
    }
}