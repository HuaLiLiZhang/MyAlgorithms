package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/29.
 */
public class getArr_win1 {
    //暴力递归的时间复杂度是：O(2^N)
    //空间复杂度是O(N)
    public int win1(int[]arr)
    {
        if(arr==null||arr.length==0)
        {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length-1), s(arr, 0 ,arr.length-1));
    }

    public int f(int []arr, int i, int j)
    {
        if(i==j)
            return arr[i];
        return Math.max(arr[i]+s(arr, i+1,j), arr[j]+s(arr, i,j-1));
        //在取了arr[i]，或者arr[j]，第一个取的时候都会保证，后一个在取i+1,j  和i，j-1的之后取最大值。
    }

    public int s(int []arr, int i, int j)
    {
        if(i==j)
            return 0;
        return Math.min(f(arr, i+1,j), f(arr, i,j-1));
        //后者在取得时候，肯定会让第一个取得人下一次取得的数最小，即i+1,j和i，j-1
    }



    //动态规划 , 生成两个NXN的矩阵 f 和 s ,时间复杂度是：O(N2) ， 空间复杂度是：O(N2)
    public int win2(int[]arr)
    {
        if(arr ==null ||arr.length==0)
            return 0;
        int [][] f = new int [arr.length][arr.length];
        int [][] s = new int [arr.length][arr.length];
        for(int j =0;j<arr.length;++j)
        {
            f[j][j]= arr[j];
            for(int i = j-1;i>=0;i--)
            {
                f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
            }
        }
        return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
    }
}