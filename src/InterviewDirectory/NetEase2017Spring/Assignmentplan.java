package InterviewDirectory.NetEase2017Spring;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/5.
 */
public class Assignmentplan {
    private static  int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //表示n个人，1-6
        String [] arr = new String[n];

        for(int i = 0;i<n;i++)
        {
            arr[i] = sc.next();
        }


        backTracing(arr, 0, new HashSet<Integer>());
        System.out.println(count);
        sc.close();
    }

    private static void backTracing(String[] arr, int index, HashSet<Integer> set)
    {
        if(index>=arr.length)
        {
            count++;
            return;
        }
        String str = arr[index];
        for(int i = 0;i<str.length();i++)
        {
            int work = str.charAt(i)-'0';
            if(!set.contains(work))
            {
                set.add(work);
                backTracing(arr, index+1, set);
                set.remove(work);
            }
        }
    }

}