package MultiThread.ThreadProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/7/22.
 */
public class pingduoduopiaoxuan {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String [] str = new String[M];
        for(int i=0;i<M;i++)
        {
            str[i] = sc.next();
        }
        String []strnew = new String[N];
        for(int i =0;i<N;i++)
        {
            char [] m = new char[M];
            for(int j = 0;j<M;j++)
            {
                m[j] = str[j].charAt(i);
            }
            Arrays.sort(m);
            strnew[i] = new String(m);
        }
        //使用比较字符串的大小，判断是否存在球星，如果有最大值且大于一个，则不存在球星。
        int max = 0;

        for (int i = 1; i < N; i++) {
            if (strnew[max].compareTo(strnew[i]) > 0) {
                max = i;
            }
            else if (strnew[max].compareTo(strnew[i]) == 0) {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(max);
        sc.close();
    }



}