package InterviewDirectory.didi2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/18.
 */
public class PQRtongsenoclose {
    //P，Q，R,三种小球的数量分别为np,nq,nr，这些小球排成一条线，但不允许相同类的小球相邻，问有多少种排列方式。
    //np = 2,nq = 1,nr = 1 ,公有6种，PQRP,QPRP,PRQP,RPQP,PRPQ,PQPR,如果没有组合方式，则输出0.

    //2 1 1
    //6

    //3 1 1
    //2

    //2 3 2
    //38

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int np = sc.nextInt();
        int nq = sc.nextInt();
        int nr = sc.nextInt();
        String s = "";
        for(int i = 0;i<np+nq+nr;i++)
        {
            if(i<np)
                s += "P";
            else if(i<np+nq)
                s += "Q";
            else
                s += "R";
        }

        List<List<Character>> list = new ArrayList<>();
        backTracing(list,new ArrayList<Character>(),  s,new boolean[s.length()]);
        System.out.println(list.size());

    }

    private static void backTracing(List<List<Character>> list,
                                    ArrayList<Character> tempList,
                                    String s, boolean[] used) {
        if (tempList.size() == s.length()&&noequallist(tempList)) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (used[i] || i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(s.charAt(i));
                backTracing(list, tempList, s, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static boolean noequallist(ArrayList<Character> tempList) {
        for(int i = 1;i<tempList.size();i++)
        {
            if(tempList.get(i-1)==tempList.get(i))
                return false;
        }
        return true;
    }












    /*static int n ,cur,sum;
    static int mod = 1000000007;
    static int [] a = new int[2005];
    static int [] fac = new int[2005];
    static int [][] c = new int[2005][2005];
    static int [][] f = new int[3][2005];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = 3;
        //a = new int[n];
        a[1] = sc.nextInt();
        a[2] = sc.nextInt();
        a[3] = sc.nextInt();
        Pre();
        sum = 0; cur = 0;
        f[cur][0] = 1;
        for(int i = 1; i <= n; i ++){
            cur ^= 1;
            for(int t = 0; t <= a[i]+sum+1; t ++)
                f[cur][t] = 0;
            for(int k = 1; k <= a[i] && k <= sum+1; k ++)
                for(int j = 0; j <= sum; j ++)
                    for(int l = 0; l <= k && l <= j; l ++){
                        f[cur][j-l+a[i]-k] +=
                                f[cur^1][j]*c[a[i]-1][k-1]%mod*(c[j][l]*c[sum+1-j][k-l]%mod)%mod;
                        f[cur][j-l+a[i]-l] %= mod;
                    }
            sum += a[i];
        }

        System.out.println(f[cur][0]);
    }

    private static void Pre() {
        fac[0] = 1;
        for(int i = 1; i <= n; i ++)
            fac[i] = i*fac[i-1] % mod;
        c[0][0] = 1;
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j < i; j ++)
                c[i][j] = ( c[i-1][j] + c[i-1][j-1] ) % mod;
            c[i][0] = c[i][i] = 1;
        }
        return;
    }*/
}