package InterviewDirectory.toutiao2019;

import java.util.*;

/**
 * Created by huali on 2018/8/12.
 */

//"""
//两个长度为n的序列a，b。问有多少个区间[l,r]满足max(a[l,r])<min(b[l,r])
//即a区间的最大值小于b区间的最小值
//n<le5
//a,b<le9
//输入：
//第一行一个整数n
//第二行n个数，第i个为ai
//第三行n个数，第i个为bi
//输出：
//一行一个整数，表示答案
//示例：
//3
//3 2 1
//3 3 3
//输出：
//3
//"""
//
//"""
//思路：
//1.首先将ab分块，剔除对应位置a>b的，因为这些位置不可能出现在结果中。
//2.如果一个小块满足Max(miniA) < min(miniB).说明这个小块任意组合都满足要求，个数为n(n+1)//2
//3.如果不满足任意组合，那么选区miniA的最大值，查看那个最大值能出现的最长长度。然后将序列分成了两块。
//  最大值左边的一块和最大值右边的一块，相当于把带有最大值的部分都剔除了。然后继续将左右两部分进行”2、3“操作。
//"""
//# a = [3, 2, 1]
//# b = [3, 3, 3]
//
//# a = [1, 2, 5, 4, 3]
//# b = [3, 6, 3, 1, 4]
//
//a = [8, 10, 2, 5, 7]
//b = [3, 11, 7, 6, 9]
//    结果 ：5.

//    8
//7 5 12 9 3 7 10 6
//13 2 9 8 10 15 11 11
//    结果
//9
public class minsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        int [] b = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        sc.nextLine();
        int [] res = new int[n];
        for(int i=0;i<n;i++)
        {
            b[i] = sc.nextInt();
            res[i] = b[i]-a[i];
        }
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int i=0;
        while (i<n)
        {
            start = i;
            while (i<n&&res[i]>0)
            {
                i++;
            }
            if(i>0&&a[i-1]<b[i-1]&&start<=i)
            {
                list.add(start);
                list.add(i-1);
            }
            i++;
        }

        int count = 0;
        for(int j=0;j<list.size();j+=2)
        {
            if(j+1<list.size()&&list.get(j+1)-list.get(j)==0)
                count +=1;
            else if(j+1<list.size())
                count +=numsubsequence(list.get(j),a, b, list.get(j+1));

        }
        System.out.println(count);

    }

    private static int numsubsequence(int start, int[] a, int[] b, int end ) {
        int maxaindex = 0;
        int maxa = 0;
        int minb = Integer.MAX_VALUE;

        if(start==end)
            return 1;
        if(start>end)
            return 0;
        for(int i =start;i<=end;i++)
        {
            if(a[i]>maxa)
            {
                maxa = a[i];
                maxaindex = i;
            }
            if(b[i]<minb)
            {
                minb = b[i];
            }
        }
        if(maxa<minb)
        {
            return countlistall(end-start+1);
        }
        int left = maxaindex -1 ;
        int right = maxaindex +1;
        int tempbmin = b[maxaindex];
        while (right<=end&&maxa< Math.min(tempbmin, b[right]))
        {
            tempbmin = Math.min(tempbmin, b[right]);
            right++;
        }
        while (left>=start&&maxa< Math.min(tempbmin, b[left]))
        {
            tempbmin = Math.min(tempbmin, b[left]);
            left--;
        }

        int counttemp = countlistall(right-left-1)-countlistall(right-maxaindex-1)-countlistall(maxaindex - left-1);

        return counttemp + numsubsequence(start, a, b, maxaindex-1) + numsubsequence(maxaindex+1, a, b, end);

    }

    private static int countlistall(int n) {
        return n*(n+1)/2;
    }
}