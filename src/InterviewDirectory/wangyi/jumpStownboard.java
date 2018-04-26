package InterviewDirectory.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by huali on 2018/4/25.
 */
public class jumpStownboard {
    public static void  main(String[] args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int n = sr.nextInt();
            int m = sr.nextInt();

            int [] mark = new int[m+1];//记录到达每一个位置的步数
            for(int i =n+1;i<=m;i++)
            {
                mark[i] = Integer.MAX_VALUE;
            }

            for(int i =n;i<m-1;i++)
            {
                if(mark[i] == Integer.MAX_VALUE)
                    continue;
                ArrayList<Integer> list = allFactor(i);
                for(int j=0;j<list.size();j++)
                {
                    int tmp = i+list.get(j);
                    int count = mark[i]+1;
                    if(tmp<=m&&mark[tmp]>count)
                        mark[tmp]=count;
                }
            }

            int r = mark[m];
            if(r==Integer.MAX_VALUE)
                r=-1;
            System.out.println(r);
        }
        sr.close();

    }
    public static ArrayList<Integer> allFactor(int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                list.add(i);
                if(i!=n/i)
                    list.add(n/i);
            }

        }
        return list;
    }
}