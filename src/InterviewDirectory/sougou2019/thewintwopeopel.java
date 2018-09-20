package InterviewDirectory.sougou2019;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by huali on 2018/9/14.
 */
public class thewintwopeopel {
    //题目：
    //6题目描述：有一正整数序列，两个人小萌和BOSS轮流从序列的任意一端取数，
    // 取得的数累加到积分，知道取完所有的分数。两个人取数都是最优策略，问最后两人得分。
    //如： 4 7 2 9 5 2
    //最后得分为：18 11


    //4 7 2 9 5 2
    //18 11
    //18 11

    //解题思路：这题是个博弈问题，每取一个数需要使得对方在剩下的数中得分最少。
    //1.递归复杂度O(2^N)，空间复杂度O(N^2)

    // 可以使用动态规划求解，状态转换方程为：
    //maxScore[i][j] = max(sumOfPreN[j] - sumOfPreN[i - 1] - maxScore[i][j - 1],
    //sumOfPreN[j] - sumOfPreN[i - 1] - maxScore[i + 1][j]);
    //maxScore[i][j] 为i终点为j中先取的人能拿到的最大分数，sumOfPreN[j]为前j个数的和。

    //测试：
    //4
    //41 2 1 55
    //57 42差值： 15
    //57 42差值： 15
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] arr = new int[N+1];
        int [] sum = new int[N+1];
        int[][] maxscore = new int[N+1][N+1];
        for(int i = 1;i<=N;i++){
            arr[i] = in.nextInt();
            sum[i] = sum[i-1] + arr[i];
            maxscore[i][i] = arr[i];
        }


        //考虑在序列a1, a2, a3, ... an上的博弈，如果先手取走a1，问题转化为在a2, a3, ... an上的博弈。
        // 此时，我们可以将后手看做在a2, a3, ...an上博弈的先手。
        // 如果先手取走an，问题转化为在a1, a2, ... an-1上的博弈问题。
        // 并且，在序列其中任何一段上的博弈不会受到序列之外的元素影响。
        //
        //考虑到该问题最优子结构和无后效性，我们尝试采用动态规划*来解决。
        //设f(i, j)表示两个人在序列ai, ai+1, ... aj上博弈时，先手可以拿到的最大价值。
        // 注意到一个很重要的问题，如果先手在序列ai, ai+1, ... aj上拿到f(i, j)的价值，
        // 那么后手一定可以得到sum(i, j) - f(i, j)的价值。其中sum(i, j)表示ai + ai+1 + ... + aj。

        //如果先手拿走ai，那么先手可以得到的最大的价值是：
        //a(i) + sum(i + 1, j) - f(i + 1, j) => sum(i, j) - f(i + 1, j)
        //因为先手拿走a(i)后，后手就会在i + 1, j中取元素，因此双方都要按照最佳的策略取，
        // 因此后手也会在ai+1, ... aj的序列上取得最大值，
        // 这个时候我们可以把在ai, ai+1, ... aj上的后手看做在i + 1, ...j上的先手能取得最大的价值。
        //
        //同理，如果先手拿走aj，那么先手可以得到的最大的价值是：
        //a(j) + sum(i, j - 1) - f(i, j - 1) => sum(i, j) - f(i, j - 1)
        //
        //由此我们推出状态转移方程：
        //f(i, j) = max{sum(i, j) - f(i + 1, j), sum(i, j) - f(i, j - 1)}
        //=>
        //f(i, j) = sum(i, j) - min{f(i + 1, j), f(i, j - 1)}
        //0 <= i <= j <= L
        //其中L表示序列的总长度
        //f(i, j) = sum(i, j) 当 i == j时
        //
        //最后，关于sum(i, j)的计算其实不需要使用二维数组来存储，
        // 因此这样非常浪费存储空间，类似的存储通常会采用下列的方式：
        //sum'(k)表示从数列开始(通常建议从1开始)到k位置的所有的元素的和
        //sum'(k) = sum'(k - 1) + a[k] (k >= 1, sum'[0] = 0_
        //那么sum(i, j) = sum'(j) - sum'(i - 1) (i >= 1)
        for(int i= N-1;i>0;i--)
        {
            for(int j = i+1;j<=N;j++)
            {
                maxscore[i][j] = Math.max(sum[j]-sum[i-1]-maxscore[i][j-1], sum[j]-sum[i-1]-maxscore[i+1][j]);
                                         //这里表示ai.....aj,之间的和，减去取j位置上的元素的
                //                            或者 ai.....aj,之间的和，减去取i位置上的元素,这两者之间要求个最大值。
            }
        }
        //最终动态规划求的最后的最大值。

        System.out.println(maxscore[1][N]+" "+(sum[N] - maxscore[1][N])+"差值： "+(maxscore[1][N]-(sum[N] - maxscore[1][N])));

        //int win = Math.max(f(1,arr.length-1,arr),s(1,arr.length-1,arr));
        //System.out.println(win+" "+(sum[N]-win)+"差值： "+(win-(sum[N]-win)));
    }


    //
    /*private static int f(int start, int end, int[] arr) {  //第一个人第一次取
        if(start==end)
            return arr[start];
        return Math.max(arr[start]+s(start+1,end,arr),arr[end]+s(start,end-1,arr));
    }

    private static int s(int start, int end, int[] arr) {  //第一个人第二次取，那么之前的第二个人第一次取，
        // 一定会使得第一个人第二次取的数最小。
        if(start==end)
            return 0;
        return Math.min(f(start+1,end,arr),f(start,end-1,arr));
    }*/













   /* public static void main(String[] args) {
        //int[] arr={1,55,41,2};
        int[] arr={4,7,2,9,5,2};
//int[] arr={4,7,2,9};
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int max[]=maxMethod(arr,0,arr.length-1,arr.length%2);
        System.out.println(max[0]+" "+max[1]);
        System.out.println(Math.abs(max[0]-max[1]));
    }


    private static int[] maxMethod(int[] arr, int i, int j,int m) {
        int[] result=new int[2];
        if(i>j){
            return result;
        }
        if(i==j){
            result[1-m]=arr[i];
            return result;
        }
        if(i==j-1){
            result[m]=Math.max(arr[i], arr[j]);
            result[1-m]=Math.min(arr[i],arr[j]);
            return result;
        }
        if((j-i)%2==1-m){
            int max=arr[i]+maxMethod(arr,i+1,j,m)[0];
            int s=i+1;
            int e=j;
            int t=arr[j]+maxMethod(arr,i,j-1,m)[0];
            if(max<t){
                max=t;
                s=i;
                e=j-1;
            }
            result[0]=max;
            result[1]=maxMethod(arr,s,e,m)[1];
        }
        if((j-i)%2==m){
            int max=arr[i]+maxMethod(arr,i+1,j,m)[1];
            int s=i+1;
            int e=j;
            int t=arr[j]+maxMethod(arr,i,j-1,m)[1];
            if(max<t){
                max=t;
                s=i;
                e=j-1;
            }
            result[1]=max;
            result[0]=maxMethod(arr,s,e,m)[0];
        }
        return result;

    }
*/
}