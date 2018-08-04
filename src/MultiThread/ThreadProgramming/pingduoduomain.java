package MultiThread.ThreadProgramming;

import java.util.*;

/**
 * Created by huali on 2018/7/22.
 */
public class pingduoduomain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int n = sc.nextInt();
            String [] str = {"A","B","C","D"};
            print(str, n);
        }
        sc.close();
    }

    private static void print(String[] str, int n) {
        int sum = 4;
        int k = 2;
        while (sum<n)
        {
            k++;
            sum += Math.pow(2, k);
        }
        int average = (int) Math.pow(2, k-2);
        if(sum-n>=3*average)
            System.out.println(str[0]);
        else if(sum-n>=2*average)
            System.out.println(str[1]);
        else if(sum-n>=average)
            System.out.println(str[2]);
        else
            System.out.println(str[3]);
    }
}