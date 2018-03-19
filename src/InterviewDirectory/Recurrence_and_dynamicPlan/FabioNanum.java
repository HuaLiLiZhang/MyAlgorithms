package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/18.
 */
public class FabioNanum {
    //时间复杂度为：O(2^n) ，暴力递归
    public int f1(int n)
    {
        if(n<0)
            return 0;
        if(n==1||n==0)
            return 1;
        return f1(n-1)+f1(n-2);
    }

    //O(N)方法： 从当前结点往下加
    public int f2(int n)
    {
        if(n<1)
            return 0;
        if(n==1||n==0)
            return 1;
        int res = 1;  //当前值
        int pre = 1;  //前一个值。
        int tmp = 0;
        for(int i = 2;i<=n;++i)
        {
            tmp = res;
            res = res+pre;
            pre = tmp;
        }
        return res;
    }


    //O(logn)的方法
    public int f3(int n)
    {
        if(n<0)
            return 0;
        if(n==0|n==1)
        {
            return 1;
        }
        int [][]base = {{1,1,},{1,0}};
        int [][]res = matrixPower(base,n-1);
        return res[0][0]+res[1][0];
    }
    //计算矩阵m 的p次方,时间复杂度为：O(logN) ，10的75次方= 10^64+10^8+10^2+10^1,75的二进制位：1001011；
    //                                                      =75的二进制为1 的位数。
    public int [][] matrixPower(int[][]m,int p)
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
                res=muliMatrix(res,tmp);
            tmp = muliMatrix(tmp,tmp);
        }
        return res;
    }

    public int[][]muliMatrix(int[][]m1,int[][]m2)
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