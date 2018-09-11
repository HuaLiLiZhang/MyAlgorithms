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
