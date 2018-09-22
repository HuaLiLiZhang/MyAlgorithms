package InterviewDirectory.xiaomi2019;


import java.util.Scanner;

/**
 * Created by huali on 2018/9/20.
 */
public class jishui {
    //0,1,0,3,1,0,1,3,2,1,2,1
    //9

    //0,1,0,2,1,0,1,3,2,1,2,1
    //6
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int m = sc.nextInt();
        String[] str = s.split(",");
        int []arr = new int[str.length];
        for(int i = 0;i<str.length;i++)
        {
            arr[i] = Integer.parseInt(str[i]);
        }
        /*//求当前水池能够装水的最大值。
        int left = 0;
        int right = arr.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left<right)
        {
            if(arr[left]<arr[right])
            {
                leftMax = Math.max(arr[left],leftMax);
                res += leftMax - arr[left];
                left++;
            }else {
                rightMax = Math.max(arr[right],rightMax);
                res += rightMax - arr[right];
                right--;
            }
        }
        System.out.println(res);*/


       // 积水最大值，然后修墙，是的扩容后蓄水池容量最大。
       // 0,1,0,2,1,0,1,3,2,1,2,1  原来存水量是 6
       // 扩容最大的村水量为 12.
       // 思路是：先找出left[] 和right[] 数组。
        //    left[] ：记录从左到右，左边最大值
        //    right[] : 记录从右到左，右边最大值

       // 找出左边开始最大高度的位置或右边开始最大高度的位置
       // 这个最大高度 - m = arr[i] 的第一个位置所围成的面积，就是最大的积水面积。
        int rightmax = 0;
        int maxindex = 0;
        for(int j=arr.length-1;j>=0;j--)
        {
            if(arr[j]>rightmax)
            {
                maxindex = j;
            }
            rightmax = Math.max(rightmax,arr[j]);

        }
        int dif = arr[maxindex] - m;
        for(int i = 0;i<arr.length;i++)
        {
            if(arr[i]==dif)
            {
                arr[i] = arr[maxindex];
                break;
            }
        }


        int left = 0;
        int right = arr.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left<right)
        {
            if(arr[left]<arr[right])
            {
                leftMax = Math.max(arr[left],leftMax);
                res += leftMax - arr[left];
                left++;
            }else {
                rightMax = Math.max(arr[right],rightMax);
                res += rightMax - arr[right];
                right--;
            }
        }
        System.out.println(res);







       /* int area = 0;
        int level = 1;
        int left = -1;
        while (true)
        {
            left = -1;
            int levelarea = 0;
            for(int i = 0;i<arr.length;i++)
            {
                if(arr[i]>=level)
                {
                    if(left!=-1&&i-left>1)
                    {
                        levelarea += i-left-1;
                    }
                    left = i;
                }
            }
            if(levelarea==0)
                break;
            area += levelarea;
            level++;
        }
        System.out.println(area);*/
    }


}