package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/4/2.
 */
public class Nqueue {
    //N皇后问题，不能同行同列同一条斜线。
    //使用时间复杂度是：O(N)
    //空间复杂度是：O(N)
    public int num1(int n)
    {
        if(n<1)
            return 0;
        int []record = new int[n];
        return process1(0,record ,n);
    }
    public int process1(int i, int[]record, int n)
    {
        if(i==n)
            return 1;
        int res = 0;
        for(int j=0;j<n;j++)
        {
            if(isValid(record, i,j))
            {
                record[i]=j;
                res+=process1(i+1, record, n);   //i+1, 每行每行的验证就不会出现同行的冲突，
                // 然后解决同列，同一个斜线
            }
        }
        return res;
    }
    //思路：   用数组x[n]表示n后问题的解。
    //
    //其中，x[i]表示皇后i放置在棋盘的第i行的第x[i]列。
    // 由于不容许将2个皇后放在同一列上，所以解向量中的x[i]互不相同。
    // 2个皇后不能放在同一斜线上是问题的隐约束。对于一般的n后问题，
    // 这一隐约束条件可以化成显约束的形式。
    // 如果将n*n 格的棋盘看做二维方阵，其行号从上到下，列号从左到右依次编号为1,2，...n。
    // 从棋盘左上角到右下角的主对角线及其平行线（即斜率为-1的各斜线）上，
    // 2个下标值的差（行号-列号）值相等。
    // 同理，斜率为+1的每条斜线上，2个下标值的和（行号+列号）值相等。
    // 因此，若2个皇后放置的位置分别是（i,j）和（k,l）,且 i-j = k -l 或 i+j = k+l，
    // 则说明这2个皇后处于同一斜线上。以上2个方程分别等价于i-k = j-l 和 i-k =l-j。
    // 由此可知，只要|i-k|=|l-j|成立，就表明2个皇后位于同一条斜线上。
    public boolean isValid(int[]record, int i, int j)
    {
        for(int k=0;k<i;k++)
        {
            if(j==record[k]||Math.abs(record[k]-j)==Math.abs(i-k))
                return false;
        }
        return true;
    }


    //位运算
    public int num2(int n)
    {
        if(n<1||n>32)
            return 0;
        int upperLim = n==32?-1:(1<<n)-1;
        return process2(upperLim, 0, 0, 0);
    }
    public int process2(int upperLim ,int colLim, int leftDiaLim, int rightDiaLim)
    {
        if(colLim == upperLim)
            return 1;
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLim&(~(colLim|leftDiaLim|rightDiaLim));
        int res = 0;
        while (pos!=0)
        {
            mostRightOne = pos&(~pos+1);
            pos = pos - mostRightOne;
            res += process2(upperLim, colLim|mostRightOne,
                    (leftDiaLim|mostRightOne)<<1,(rightDiaLim|mostRightOne)>>>1);
        }
        return res;
    }

}