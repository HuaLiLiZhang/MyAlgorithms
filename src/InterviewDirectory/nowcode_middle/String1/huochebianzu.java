package InterviewDirectory.nowcode_middle.String1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/10/10.
 */
public class huochebianzu {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext())
        {
            list.add(sc.nextInt());
        }
        int maxindex = findmaxindexx(list);
        if(maxindex==0)
        {
            for(int i = 2;i<list.size();i++)
            {
                if(list.get(i-1)<=list.get(i))
                {
                    System.out.println("Yes");
                    break;
                }
            }
        }
        System.out.println("No");


    }
    private static int findmaxindexx(List<Integer> list) {
        int indexmin = 0;
        int min = list.get(0);
        for(int i =1;i< list.size();i++)
        {
            if(min>list.get(i))
            {
                min = list.get((i));
                indexmin = i;
            }
        }
        return indexmin;
    }
}