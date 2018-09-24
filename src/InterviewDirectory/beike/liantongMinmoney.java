package InterviewDirectory.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/18.
 */
public class liantongMinmoney {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] arr = new int[N];
        int sum = 0;
        for(int i = 0;i<N;i++)
        {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i = 1;i<arr.length;i++)
        {
            sum +=arr[i];
        }
        System.out.println(sum);
    }
}