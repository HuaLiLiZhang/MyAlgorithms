package InterviewDirectory.xunlei2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/12.
 */
public class calGougushuabc {
    //计算勾股数，输入数字N，计算所有小于N的数字组成的素勾股数，就是质数
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
                        if(used[a]!=0)
                        {
                            used[a]=1;
                            cntused++;
                        }
                        if(used[b]!=0)
                        {
                            used[b]=1;
                            cntused++;
                        }
                        if(used[c]!=0)
                        {
                            used[c]=1;
                            cntused++;
                        }
                    }
                    for(int k=2; k*c<=n; k++)
                    {
                        if(used[k*a]!=0)
                        {
                            used[k*a]=1;
                            cntused++;
                        }
                        if(used[k*b]!=0)
                        {
                            used[k*b]=1;
                            cntused++;
                        }
                        if(used[k*c]!=0)
                        {
                            used[k*c]=1;
                            cntused++;
                        }
                    }
                }

            }
        }
        //System.out.println(cnt+" "+(n-cntused));
        System.out.println(cnt);

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