package InterviewDirectory.pingduoduo2019_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by huali on 2018/8/30.
 */
public class Main4 {
    //


    static char[][] s = new char[1010][1010];
    static int n,l;
    static char [] output = new char[100];
    static Set<String> se = new HashSet<>();
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<n;i++) {
            String x = sc.nextLine();
            se.add(x);
            for (int j = 0; j < l; j++) {
                s[j][i] = x.charAt(j);
            }
        }
        for(int i=0;i<l;i++)
            Arrays.sort(s[i],0, n);
        boolean ok = dfs(0);
        if(ok)
        {
            int lk = 0;
            while (lk<l&&output[lk]!=0)
            {
                System.out.print(output[lk++]);
            }

            System.out.println();
        }
        else
            System.out.println("-");

//3 4
//COKE
//TARN
//SHOW


    }

    public static boolean dfs(int now)
    {
        if(now == l)
        {
            output[now] = '\0';
            if(se.contains(Arrays.toString(output)))
                return false;
            else
                return true;
        }
        char last = '#';
        for(int i=0;i<n;i++)
        {
            if(last == s[now][i])
                continue;
            last = s[now][i];
            output[now] = last;
            boolean ok = dfs(now + 1);
            if(ok)
                return true;
        }
        return false;
    }
}