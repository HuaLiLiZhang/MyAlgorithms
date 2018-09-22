package InterviewDirectory.aqiyi2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/15.
 */
public class tihuanluckyID {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int [] arr = new int[s.length()];
        if(s.length()!=6)
        {
            System.out.println("error");
        }else {
            int right3 = 0;
            int left3 = 0;
            for(int i = 0;i<arr.length;i++)
            {
                arr[i] = s.charAt(i)-'0';
                if(i<3)
                    left3 +=arr[i];
                if(i>=3)
                    right3 += arr[i];
            }

            int dif = Math.abs(left3-right3);
            if(dif==0)
            {
                System.out.println(0);
            }else
            {
                int count = Math.min(tihuan(arr, 0, 2, right3),tihuan(arr, 3, arr.length-1, left3));
                System.out.println(count);
            }
        }

    }

    private static int tihuan(int[] arr, int start, int end, int target) {

        for(int i = start;i<=end;i++)
        {
            for(int j = i+1;j<=end;j++)
            {
                if(arr[i]+arr[j]>=target-9&&target-9>=0/*arr[start+3-i-j]*/)
                    return 1;
            }

        }

        for(int i = start;i<=end;i++)
        {
            if(arr[i]<target-18)
                return 3;
        }
        return 2;
    //    for(int i = start;i<=end;i++)
        //        {
        //            if(arr[i]>=target-18)
        //                return 2;
        //        }
        //
        //        return 3;
    }
}

/*package InterviewDirectory.aqiyi2019;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int [] arr = new int[s.length()];
        if(s.length()!=6)
        {
            System.out.println("error");
        }else {
            int right3 = 0;
            int left3 = 0;
            for(int i = 0;i<arr.length;i++)
            {
                arr[i] = s.charAt(i)-'0';
                if(i<3)
                    left3 +=arr[i];
                if(i>=3)
                    right3 += arr[i];
            }

            boolean flag = left3>right3?true:false;
            int dif = Math.abs(left3-right3);
            if(dif==0)
            {
                System.out.println(0);
            }else
            {
                int start = flag?3:0;
                int end = flag?arr.length-1:2;
                int count = tihuan(arr, start, end, dif);
                System.out.println(count);
            }

        }

    }

    private static int tihuan(int[] arr, int start, int end, int dif) {
        //if(start==end)
        int count = 0;
        Arrays.sort(arr,start,end+1);
        for(int i = end;i>=start;i--)
        {
            int temp = 9 -arr[i];

            if(dif<=0)
                return count;
            dif -= temp;
            count++;
        }
        return count;
    }
}*/