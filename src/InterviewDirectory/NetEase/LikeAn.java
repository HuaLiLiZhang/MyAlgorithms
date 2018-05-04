package InterviewDirectory.NetEase;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/3.
 */
public class LikeAn {
    //小易非常喜欢拥有以下性质的数列:
    //1、数列的长度为n
    //2、数列中的每个数都在1到k之间(包括1和k)
    //3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
    //例如,当n = 4, k = 7
    //那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
    //但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
    //输入描述:
    //输入包括两个整数n和k(1 ≤ n ≤ 10, 1 ≤ k ≤ 10^5)
    //
    //
    //输出描述:
    //输出一个整数,即满足要求的数列个数,因为答案可能很大,输出对1,000,000,007取模的结果。


    //思路:
    //
    //state[i][j]表示整个状态空间，
    // 其中i(1<=i<=n)表示数列的长度，j(1<=j<=k)表示数列长度为i且以数字j结尾。
    //递推关系有：state[i][j] += state[i-1][m] (1<=m<=k, 并且(m,j)是个合法的数列)，
    // 但是直接按照递推关系，用三层for循环会超时。
    // 为此可以先将长度为i-1的合法数列求和(记为sum)。然后对于数列长度为i的每一个j，
    // 求出数列长度为i-1时非法的序列个数（记为invalid）,即有state[i][j] = sum - invalid。
    //对于invalid求取，可以参照素数筛选。算法的时间复杂度大概为O(nkloglogk)

    public static void main(String[]args) {
        final int mod = 1000000007;
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext()) {
            int n = sr.nextInt();
            int k = sr.nextInt();
            int [][] dp = new int [n+1][k+1];
            dp[0][1] = 1;
            for(int i=1;i<=n;i++)
            {
                int sum = 0;
                for(int j=1;j<=k;j++)
                {
                    sum = (sum+dp[i-1][j])%mod;  //在只有1个元素的时候，有K中选法。所以j从1-k。
                }
                for(int j=1;j<=k;j++)
                {
                    int invalid = 0;
                    int p = 2;
                    while (p*j<=k)
                    {
                        invalid=(invalid+dp[i-1][p*j])%mod;
                        p++;
                    }
                    dp[i][j] = (sum-invalid+mod)%mod;
                }
            }
            int sum = 0;
            for(int i=1;i<=k;i++)
            {
                sum = (sum+dp[n][i])%mod;
            }
            System.out.println(sum);

        }
        sr.close();
    }

//    就是dp，但是普通的做法会超时。
//超时的做法：用f(k, n)表示数字k打头， 长度为n的数列的个数，那么有
//f(k,n)=∑f(j,n−1),j≥k || k mod j≠ 0
//
//然后三重循环自底向上求解。
//上面做法超时的原因在于对于f(k, n)来说，
// 长度为n - 1的情况大部分都是要加上去的，
// 因为j % k == 0的情况毕竟是稀疏的，所以对不同的k来说，用往f(k, n)上累加合法情况的做法重复计算很多。
//既然不合法的状况是稀疏的，我们可以对所有长度为n的序列统一计算sum(f(j, n - 1))，
// 然后根据不同的k从中剔除掉不符合的f(j, n - 1)即可。
// 然而用k打头的状态定义循环不太好写，因为要固定k，循环j找到所有的k % j == 0。
//如果用另一种状态表示：g(k, n)表示结尾数字为k，长度为n的数列个数，那么状态转移方程就是:
//g(k,n)=∑1≤j≤kg(j,n−1)−∑i=multiple kg(i,n−1)
//
//其中对g(j, n - 1)求和的部分，即∑1≤j≤kg(j,n−1)，对所有长度为n的数列都可以复用，节省计算量。
// 给定结尾数字j之后，不符合的情况就是k前面的数字是2j, 3j, 4j, ….所有不超过k的j的倍数。
}