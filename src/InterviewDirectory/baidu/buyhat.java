package InterviewDirectory.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/4/30.
 */
public class buyhat {
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        if(n<3)
            System.out.println(-1);
        else
        {
            int []arr = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sr.nextInt();
            }
            Arrays.sort(arr);
            int count = 1;
            int i =1;
            for(;i<n;i++)
            {
                if(arr[i-1]!=arr[i])
                    count++;
                if(count==3)
                    break;
            }

            if(i<n)
                System.out.println(arr[i]);
            else
                System.out.println(-1);
        }

    }

}