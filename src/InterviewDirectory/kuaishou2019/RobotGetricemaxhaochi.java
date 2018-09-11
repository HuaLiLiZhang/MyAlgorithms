package InterviewDirectory.kuaishou2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/10.
 */
public class RobotGetricemaxhaochi {
    //自动打饭机器人，我们假设午饭一共有N个菜，对于第i个菜，你和你的同伴对其定义了一个好吃程度A[i],
    // 由于技术限制，机器人只接受一个指令，两个数L,R——表示机器人将会去打第L-R一共R-L+1个菜。
    //希望通过最少的测试次数，找到最好吃的程度之和最大。
    //可以指导机器人打M次菜，打过一次菜是不能再打的，而且你也可以对机器人输入-1,表示一个菜也不打。
    //输入第一行N,M
    //第二行：A[1].....A[n]
    //例如：7 2
    //1 2 3 -2 3 -10 3
    //输出 10 表示[1 2 3 -2 3] -10 [3]

    //例如 7 4
    //1 2 3 -2 3 -10 3
    //输出：12
    //因为 [1 2 3] -2 [3] -10 [3]

    //
    ///*
    //1、先把整个数组改成正负交错的数组，去掉首尾的负数(相邻的正数合并成一个正数，负数合并成一个负数)
    //2、如果正数个数<=M，输出所有的正数之和
    //3、如果正数个数>M，将数组中[正负正]合并，该负数为数组中负数的最大值并且三者之和>三者最大值
    //4、直到3不满足或者正数个数<=M,输出最大的M个正数之和
    //*/

    /*
N, M = 7, 3
ns = [1, 2, 3, -2, 3, -10, 3]

new_ns = []
tmp = ns[0]
cnt_pos = 0  # 正数块的数量
for i in ns[1:] + [0]:  # trick
    if i != 0 and (tmp > 0) == (i > 0):  # 跳过 0
        tmp += i
    else:
        if tmp > 0:
            cnt_pos += 1
        new_ns.append(tmp)
        tmp = i

# new_ns.append(tmp)

print(new_ns)  # [6, -2, 3, -10, 3]
print(cnt_pos)  # 3

# 去掉首尾的负数块
if len(new_ns) >= 1 and new_ns[0] < 0:
    new_ns.pop(0)

if len(new_ns) >= 1 and new_ns[-1] < 0:
    new_ns.pop(-1)

print(new_ns)  # [6, -2, 3, -10, 3]

# 按奇偶划分奇数和偶数块
ns_pos = new_ns[0::2]
ns_neg = new_ns[1::2]
print(ns_pos)  # [6, 3, 3]
print(ns_neg)  # [-2, -10]

# 如果 M 的值小于正数块的数量则进行合并
updated = True
while updated and M < cnt_pos:
    """"""
    updated = False

    mx_i = 0
    # mx = max(ns_pos[mx_i] + ns_pos[mx_i+1] + ns_neg[mx_i], ns_pos[mx_i], ns_pos[mx_i])
    mx = float("-inf")
    for i in range(len(ns_neg)):
        tmp = ns_pos[i] + ns_pos[i+1] + ns_neg[i]
        if tmp < max(ns_pos[i], ns_pos[i+1]):
            continue
        if tmp > mx:
            updated = True
            mx = tmp
            mx_i = i

    if updated:
        # 更新合并后的数组
        ns_neg.pop(mx_i)
        ns_pos[mx_i] = mx
        ns_pos.pop(mx_i+1)
        cnt_pos -= 1

ns_pos.sort(reverse=True)
print(sum(ns_pos[:M]))*/
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); //打M次菜达到的最好次的程度之和。
        int []arr = new int[n];
        sc.nextLine();
        for(int i = 0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int [] dp = new int[arr.length];
        dp[0] = arr[0];

        System.out.println();
    }
}

//Python的解法：


/*
def max_sub_array(nums):
    n = len(nums)
    maxSum = [nums[0] for i in range(n)]
    for i in range(1, n):
        maxSum[i] = max(maxSum[i - 1] + nums[i], nums[i])
    return (maxSum.index(max(maxSum)), max(maxSum))
def min_sub_array(nums):
    n = len(nums)
    minSum = [nums[0] for i in range(n)]
    for i in range(1, n):
        minSum[i] = min(minSum[i - 1] + nums[i], nums[i])
    return (minSum.index(min(minSum)), min(minSum))

tmp = input().split()
N, M = int(tmp[0]), int(tmp[1])
tmp = input().split(' ')
levels = [int(i) for i in tmp]
backup_levels = [i for i in levels]
idxes = []
res = 0
k = 0
for i in range(M):
    idx, cur_max = max_sub_array(levels)
    if cur_max >= 0:
        cur_sum = 0
        left_idx = 0
        for j in range(idx, -1, -1):
            cur_sum += levels[j]
            if cur_sum == cur_max:
                left_idx = j
                idxes.append([left_idx, idx])
                break
        levels = levels[:left_idx] + levels[idx+1:]
        # print(cur_max)
        res += cur_max
        # print(res)
    else:

        # tmp = min_sub_array(backup_levels[idxes[i][0]:idxes[i][1] + 1])[1]
        idx, cur_min = min_sub_array(backup_levels[idxes[k][0]:idxes[k][1] + 1])
        if cur_min <= 0:
            cur_sum = 0
            left_idx = 0
            for j in range(idx, -1, -1):
                cur_sum += backup_levels[j]
                if cur_sum == cur_max:
                    left_idx = j
                    # idxes.append([left_idx, idx])
                    break
            # print(left_idx, idx)
        k += 1
        res += -cur_min if cur_min <= 0 else 0*/
