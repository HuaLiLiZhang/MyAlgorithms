package InterviewDirectory.xunlei2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/12.
 */
public class calGougushuabc {
    //计算勾股数，输入数字N，计算所有小于N的数字组成的素勾股数，就是质数
    //题意：给你一个n，让你找出一些勾股数组，a^2+b^2=c^2 ，
    // 需要满足a<b<c<=n 。
    // 对于每个case题目首先需要你输出这些勾股数组中素勾股数T的个数，
    // 然后再输出一个数字，这个数字是n-所有勾股数组用掉的数字个数
    //本题就是要求在n范围内的素勾股数

    //如果 (a, b, c) 是勾股数，它们的正整数倍数，
    // 也是勾股数，即 (na, nb, nc) 也是勾股数。
    // 若果 a, b, c 三者互质（它们的最大公因数是 1），它们就称为素勾股数。

    //思路：
    //以下的方法可用来找出勾股数。设 m > n 、 m 和 n 均是正整数，
    //
    //a = m * m - n * n;
    //
    //b = 2 * m * n;
    //
    //c = m * m + n * n;
    //满足： a*a+b*b=c*c
    //若 m 和 n 是互质，而且 m 和 n 至少有一个是偶数，
    // 计算出来的 a, b, c 就是素勾股数。
    // （若 m 和 n 都是奇数， a, b, c 就会全是偶数，不符合互质。）


    static int n;
    static int[] used ;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        int a,b,c;
        int cnt = 0;
        int cntused = 0;
        used = new int[100000+10];
        Arrays.fill(used,0);
        for(int i=1; i<=Math.sqrt(n+0.5); i++)
        {
            for(int j=i+1; j*i<=n; j+=2)
            {
                if(gcnum(i,j)==1)
                {
                    a=j*j-i*i;
                    b=2*i*j;
                    c=i*i+j*j;
                    if(c<=n)
                    {
                        cnt++;
                        if(used[a]!=1)
                        {
                            used[a]=1;
                            cntused++;
                        }
                        if(used[b]!=1)
                        {
                            used[b]=1;
                            cntused++;
                        }
                        if(used[c]!=1)
                        {
                            used[c]=1;
                            cntused++;
                        }
                    }
                    for(int k=2; k*c<=n; k++)
                    {
                        if(used[k*a]!=1)
                        {
                            used[k*a]=1;
                            cntused++;
                        }
                        if(used[k*b]!=1)
                        {
                            used[k*b]=1;
                            cntused++;
                        }
                        if(used[k*c]!=1)
                        {
                            used[k*c]=1;
                            cntused++;
                        }
                    }
                }

            }
        }
        System.out.println(cnt+" "+(n-cntused));
        //System.out.println(cnt);

        int numCount = 0, sumNum = 0;
        int [] vis = new int[1000005];
        Arrays.fill(vis,0);
        int aa,bb,cc;
        double m = Math.sqrt(n+0.5);
        for(int i = 1;i<=m;i++)   //i,j肯定小于n，并且i,j<=sqrt(n+0.5).那么j*j+i*i只要小于n就满足勾股定理
        {
            for(int j = i+1;j*i<=n;j+=2)
            {
                if(gcb(i, j)==1)  //满足这个肯定满足i,j一个为偶数一个为奇数
                {
                    aa = j*j-i*i;
                    bb = 2*j*i;
                    cc = j*j+i*i;
                    //if(cc<=n)
                    //{
                    //    numCount++;
                    //    if(vis[aa]!=1)
                    //    {
                    //        vis[aa] = 1;
                    //        sumNum++;
                    //    }
                    //    if(vis[bb]!=1)
                    //    {
                    //        vis[bb] = 1;
                    //        sumNum++;
                    //    }
                    //    if(vis[cc]!=1)
                    //    {
                    //        vis[cc] = 1;
                    //        sumNum++;
                    //    }
                    //}
                    //for(int k = 2;cc*k<=n;k++)
                    //{
                    //    if(vis[aa*k]!=1)
                    //    {
                    //        vis[k*aa] = 1;
                    //        sumNum++;
                    //    }
                    //    if(vis[bb*k]!=1)
                    //    {
                    //        vis[k*bb] = 1;
                    //        sumNum++;
                    //    }
                    //    if(vis[cc*k]!=1)
                    //    {
                    //        vis[k*cc] = 1;
                    //        sumNum++;
                    //    }
                    //}
                    if (cc <= n) {
                        numCount++;
                        vis[aa] = vis[bb] = vis[cc] = 1;
                    }
                    for (int k = 2; cc * k <= n; k++)
                        vis [k * aa] = vis[k * bb] = vis[k * cc] = 1;

                }
            }
        }
        int num = 0;
        for(int i = 1;i<=n;i++)
        {
            if(vis[i]==1)
                num++;
        }
        //System.out.println((numCount)+" "+(n-(sumNum)));
        System.out.println(numCount+" "+(n-num));

    }

    private static int gcb(int a, int b) {
        return a%b==0?b:gcb(b,a%b);//判断两个数是否互为质数。除了1和本身，没有其他公因子
    }

    private static long gcnum(int x, int y) {
        if(x%y==0)
        {
            return y;
        }
        else
        {
            return gcnum(y,x%y);
        }
    }
}