package InterviewDirectory.Tencent2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by huali on 2018/7/15.
 */
public class arrangeMachine {
    public static void main(String[] args)
    {
        int []cnt = new int[105];
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int m = sr.nextInt();
        node [] e = new node[n];
        node [] f = new node[m];
        for(int i=0;i<n;i++)
        {
            e[i] = new node(sr.nextInt(),sr.nextInt());
        }
        for(int i=0;i<m;i++)
        {
            f[i] = new node(sr.nextInt(),sr.nextInt());
        }
        Arrays.sort(e, new Comparator<node>() {
        @Override
        public int compare(node a, node b) {
            if(a.t==b.t)
                return b.w-a.w;
            return b.t-a.t;
        }
        });
        Arrays.sort(f,new Comparator<node>() {
        @Override
        public int compare(node a, node b) {
            if(a.t==b.t)
                return b.w-a.w;
            return b.t-a.t;
        }
    });
        int num = 0;
        long ans = 0;
        int i,j,k;
        for(i=0,j=0;i<m;i++)
        {
            while (j<n&&e[j].t>=f[i].t)
            {
                cnt[e[j].w]++;
                j++;
            }
            for(k = f[i].w;k<=100;k++)
            {
                if(cnt[k]!=0)
                {
                    num++;
                    cnt[k]--;
                    ans = ans+200*f[i].t+3*f[i].w;
                    break;
                }
            }
        }
        System.out.println(num+" "+ans);

    }
    boolean cmp(node a, node b)
    {
        if(a.t==b.t)
            return a.w>b.w;
        return a.t>b.t;
    }

}
class node{
    int t;
    int w;
    node(int t, int w)
    {
        this.t = t;
        this.w = w;
    }
}