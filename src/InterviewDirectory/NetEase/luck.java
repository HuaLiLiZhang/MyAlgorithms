package InterviewDirectory.NetEase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/21.
 */
public class luck {
//    一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。
// 如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
//例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
//你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，
// 要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
//输入描述:
//第一行输入一个正整数n(n ≤ 1000)
//第二行为n个数正整数xi(xi ≤ 1000)
//
//
//输出描述:
//输出可以产生的幸运的袋子数
//
//输入例子1:
//3
//1 1 1
//
//输出例子1:
//2

    static int ans = 0;
    static int n=0;
    static int []arr;
    static int sum =0;
    static int multi = 1;
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            n = sr.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sr.nextInt();
            }
            Arrays.sort(arr);
            //System.out.println(find(arr, 0, sum, muti));
            dfs(0);

            System.out.println(ans);

        }
        sr.close();

    }

    private static void dfs( int index) {
        for(int i=index ;i<n;i++)
        {
            sum +=arr[i];
            multi*=arr[i];
            if(sum>multi)   //因为是经过排序的，所以从小到大的顺序。
            {
               ans++;
               dfs(i+1);
            }
            else if(arr[i]==1)
                //如果不满足和大于积的话，就判断是否为1，
                // 因为满足和大于积，必定有一个元素为1
            {
                dfs(i+1);
            }
            else {
                sum -=arr[i];
                multi/=arr[i];   //不满足的话，就不满足和大于积。所以跳出。
                break;
            }
            sum-=arr[i];
            multi/=arr[i];
            for (; i < n - 1 && arr[i] == arr[i + 1]; i++);
        }
    }

    //private static int find(int[] arr, int index, long sum, long muti) {
    //    int count = 0;
    //    for(int i= index ;i<arr.length;i++)
    //    {
    //        sum +=arr[i];
    //        muti*=arr[i];
    //        if(sum>muti)
    //        {
    //            count += 1+find(arr, i+1, sum, muti);
    //        }else if(arr[i]==1)
    //        {
    //            count +=find(arr, i+1,sum,muti);
    //        }
    //        else {
    //            break;
    //        }
    //        sum -=arr[i];
    //        muti/=arr[i];
    //        while (i<arr.length-1&&arr[i]==arr[i+1])
    //            i++;
    //    }
    //    return count;
    //
    //}
}