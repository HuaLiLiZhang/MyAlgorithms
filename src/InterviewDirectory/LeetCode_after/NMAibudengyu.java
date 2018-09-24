package InterviewDirectory.LeetCode_after;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/11.
 */
public class NMAibudengyu {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n =    sc.nextInt();
        int m = sc.nextInt();

        System.out.println(count(n+1,m));
    }

    private static int count(int n, int m) {
        if(n<=2)
            return m-1;
        if(m<=1)
            return 0;
        return (m-1)*count(n-2,m-2);

    }
}