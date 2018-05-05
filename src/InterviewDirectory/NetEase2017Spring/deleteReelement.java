package InterviewDirectory.NetEase2017Spring;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/5.
 */
public class deleteReelement {
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);

        while(sr.hasNext())
        {
            int n= sr.nextInt();
            int []arr = new int[n];
            for(int i  =0;i<n;i++)
            {
                arr[i] = sr.nextInt();
            }
            List<Integer> list = new ArrayList<>();
            for(int i =n-1;i>=0;i--)
            {
                if(!list.contains(arr[i]))
                    list.add(arr[i]);
            }
            for(int i =list.size()-1;i>=0;i--)
            {
                System.out.print(list.get(i));
                if(i!=0)
                    System.out.print(" ");
            }
        }
        sr.close();

    }
}