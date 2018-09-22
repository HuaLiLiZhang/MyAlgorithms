package InterviewDirectory.xiaomi2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/21.
 */
public class TrainingRainWater {
//    Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it is able to trap after raining.

    //array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
    // 6 units of rain water (blue section) are being trapped.

//    first method
//    left[] ：记录从左到右，左边最大值
//    right[] : 记录从右到左，右边最大值

    //0,1,0,3,1,0,1,3,2,1,2,1
    //9

    //0,1,0,2,1,0,1,3,2,1,2,1
    //6
    //如果arr[i]即当前的高度，left[i] right[i]右边和左边的左高高度。
    //那么left[i],right[i] 的最小值如果大于arr[i]的话，那么此位置就是可以存水的，
    // 存水量就是left[i],right[i] 的最小值 - arr[i]；
    /*public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String sl = sc.nextLine();
        String [] str = sl.split(",");
        int [] arr = new int[str.length];
        for(int i = 0;i<arr.length;i++)
        {
            arr[i] = Integer.valueOf(str[i]);
        }

        int [] left = new int[arr.length];
        int [] right = new int[arr.length];
        left[0] = right[0] = 0;
        int leftmax = 0;
        int rightmax = 0;
        for(int i = 1,j=arr.length-2;i<arr.length&&j>=0;i++,j--)
        {
            leftmax = Math.max(arr[i-1],leftmax);
            left[i] = leftmax;
            rightmax = Math.max(arr[j+1], rightmax);
            right[j] = rightmax;
        }
        int sum = 0;
        for(int i = 0;i<arr.length;i++)
        {
            int min = Math.min(left[i], right[i]);
            if(arr[i]<min)
                sum += (min - arr[i]);
        }
        System.out.println(sum);
    }*/


//    第二种方法：
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String sl = sc.nextLine();
        String [] str = sl.split(",");
        int [] arr = new int[str.length];
        for(int i = 0;i<arr.length;i++)
        {
            arr[i] = Integer.valueOf(str[i]);
        }
        int leftmax = 0;
        int rightmax = 0;
        int i = 0,j=arr.length-1;
        int sumwater = 0;
        while (i<j)
        {
            leftmax = Math.max(arr[i],leftmax);
            rightmax = Math.max(arr[j],rightmax);
            if(leftmax<rightmax)
            {
                sumwater += leftmax - arr[i];
                i++;
            }else {
                sumwater += rightmax - arr[j];
                j--;
            }
        }
        System.out.println(sumwater);
    }
}