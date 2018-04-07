package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/7.
 */
public class getNum_01 {
    //0左边必有1的二进制字符串数量
    //第一种暴力解方法。
    //时间复杂度O(2^N)。
    public int getNUm1(int n )
    {
        if(n<1)
            return 0;
        return  process1(1,n);
    }
    public int process1(int i, int n)
    {
        if(i ==n-1)
            return 2;
        if(i==n)
            return 1;
        return process1(i+1, n)+process1(i+2, n);
    }

    //菲波那切数列，O(N) ，空间复杂度O(1)
    public int getnum2(int n)
    {
        if(n<1)
            return 0;
        if(n==1)
            return 1;
        int pre = 1;
        int cur = 1;
        int tmp =0;
        for(int i=2;i<n+1;i++)
        {
            tmp = cur ;
            cur+=pre;
            pre = tmp;
        }
        return cur;
    }

    //动态规划
    public int getnum3(int n)
    {
        if(n<0)
            return 0;
        //只有一位1.
        if(n==0|n==1)
        {
            return 1;
        }
        int [][]base = {{1,1,},{1,0}};
        //这个是矩阵，计算出来的。（f(n),f(n-1)） = (f(n-1),f(n-2))x|a,b|,算出a, b, c, d
        //                                                       |c,d|
        int [][]res = matrixPower3(base,n-1);
        return res[0][0]+res[1][0];
    }



    //计算矩阵m 的p次方,时间复杂度为：O(logN) ，10的75次方= 10^64+10^8+10^2+10^1,75的二进制位：1001011；
    //                                                =75的二进制为1 的位数。
    public int [][] matrixPower3(int[][]m,int p)
    {
        int[][]res = new int [m.length][m[0].length];
        //先把res设为单位矩阵，相当于整数中的1；
        for(int i=0;i<res.length;++i)
        {
            res[i][i]=1;
        }
        int[][]tmp = m;
        for(;p!=0;p>>=1)
        {
            if((p&1)!=0)
                res=muliMatrix3(res,tmp);
            tmp = muliMatrix3(tmp,tmp);
        }
        return res;
    }

    public int[][]muliMatrix3(int[][]m1,int[][]m2)   //二维矩阵的乘法
    {
        int[][]res = new int  [m1.length][m2[0].length];
        for(int i = 0;i<m1.length;++i)
        {
            for(int j = 0;j<m2[0].length;j++)
            {
                for(int k = 0;k<m2.length;k++)
                {
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }
}