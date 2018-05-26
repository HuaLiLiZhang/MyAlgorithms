package InterviewDirectory.JD;

/**
 * Created by huali on 2018/5/26.
 */


//这个问题需要再加一个条件：
// n为偶数，应为如果n为偶数，先拿的必胜，如果n为奇数，那么先拿的必输。
//  思路：假设n为偶数，那么先拿的可以决定后拿每次拿的硬币在原硬币位置中下标为奇数或者为偶数，
// 那么先拿的可以比较硬币在奇数位置的面额之和 和 偶数位置的面额之和，从而使得自己每次拿奇数还是偶数。
public class themaxcone {
    public static void  main(String[]args)
    {
        //int v[] = {3,6,0,1,4,7,9,2,6,8}; //24
        //int v[] = {3,6,7,0,2,5};  //14
        //int[]v = {1,1,1,1,0,1,1,1,1};  //4
        int []v = {5,3,4};  //8

        int max = MaxValue(v, v.length);
        System.out.println(max);
    }

    private static int MaxValue(int[] v, int n) {
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum +=v[i];
        }
        int max = thefirstone(v, 0,n-1);
        return max;   //>sum-max?max:sum-max;
    }

    private static int thefirstone(int[] v, int start, int end) {

        if (start == end)
            return v[start];
        if(start<end) {

            return Math.max(v[start] + thesecondone(v, start + 1, end),
                    v[end] + thesecondone(v, start, end - 1));
        }
        return 0;
    }

    private static int thesecondone(int[] v, int i, int end) {
        if(i==end)
            return 0;
        return Math.min(thefirstone(v,i+1, end), thefirstone(v,i,end-1));
    }


//动态规划版本
//动态规划 , 生成两个NXN的矩阵 f 和 s ,时间复杂度是：O(N2) ， 空间复杂度是：O(N2)
        public int themax(int[]arr)
        {
            if(arr ==null ||arr.length==0)
                return 0;
            int [][] f = new int [arr.length][arr.length];
            int [][] s = new int [arr.length][arr.length];
            for(int j =0;j<arr.length;++j)
            {
                f[j][j]= arr[j];
                for(int i = j-1;i>=0;)
                {
                    f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
                    s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
                    i--;
                }
            }
            return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
}



}

