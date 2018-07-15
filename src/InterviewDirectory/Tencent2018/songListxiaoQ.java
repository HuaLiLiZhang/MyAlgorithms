package InterviewDirectory.Tencent2018;

import java.util.Scanner;

/**
 * Created by huali on 2018/7/15.
 */
public class songListxiaoQ {
    //对于K，如果从X个A中取出i个A之后的差刚好能够除以B，并且（K-A*i）/B结果小于B的个数Y的话，
    // 那么就可以取。结果的个数为：组合C(X,i)*C(Y,（K-A*i）/B)
    //此时算的C就是杨辉三角的计算方法。对于每一行n和每一列m来说，就是从n个中取出m个的组合个数。
    public static void main(String[] args)
    {
        Scanner sr = new Scanner(System.in);
        int K = sr.nextInt();
        int A = sr.nextInt();
        int X = sr.nextInt();
        int B = sr.nextInt();
        int Y = sr.nextInt();
        long [][] c = new long[105][105];
        c[0][0] = 1;
        for(int i=1;i<=100;i++)
        {
            c[i][0] = 1;
            for(int j=1;j<=100;j++)
            {
                c[i][j] = (c[i-1][j-1]+c[i-1][j])%1000000007;
            }
        }
        long sum = 0;
        for(int i=0;i<=X;i++)
        {
            if(i*A<=K&&(K-A*i)%B==0&&(K-A*i)/B<=Y)
                sum = (sum+(c[X][i]*c[Y][(K-A*i)/B])%1000000007)%100000007;
        }
        System.out.println(sum);
        //System.out.println(Long.MAX_VALUE);

    }
}