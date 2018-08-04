package InterviewDirectory.offerTwice;

/**
 * Created by huali on 2018/7/25.
 */
public class pingduoduobeautynumber {

//
//题目四: 变成靓号的最少代价
//
//题意简单，号码长度为n，每个数字范围是0-9，同样的数字的个数大于等于k，则为靓号，
// 找出成本最小且字典序最小的靓号。
//代码如下，因为是最后一道，写的有些仓促，代码有点不忍直视。
// 主要思路就是首先用number数组记录每个数字出现的次数，
// 然后遍历10种可能，就是将每个数字为靓号，共10种可能。用anscost和ansstr记录结果，
// 然后每个数字比较字典序。重点在于如何修改，才能使得成本最低。
//比如，对于要使得7的个数大于等于k，那么首先进行广度优先遍历，dif = 1..9，
// 即往7的左右两边遍历，显然先替换大于7的会使得字典序更小，
// 因此先7+dif，再计算7-dif，直到数字7的个数==k，
// 然后记录原号码中每个数字中有多少个数要替换为7。然后从左往右替换大于7的数字，
//再从右往左替换小于7的数字即可。

}