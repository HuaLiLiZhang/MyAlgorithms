package InterviewDirectory.baidu;

        import java.util.Arrays;
        import java.util.Scanner;

/**
 * Created by huali on 2018/5/1.
 */
public class FannySort {

    //
    ////  思路是这样的，这串数字可以分为两类：一类是不动数另一类是动数。动数的个数就是算法要移动的次数。
    // 
    ////  不动数满足两个条件：1.后面的数都大于该数。并且,2.前面最小动数大于该数。
    // 
    ////  动数和不动数刚好相反：1.后面的数至少有一个数大于该数。或者2.前面最小动数小于该数。
    // 
    ////  不是不动数的数就是动数。只需要找到所有动数个数，就能得到算法移动次数。
    //public static void main(String []args)
    //{
    //    Scanner sr = new Scanner(System.in);
    //    //4
    //    //19 7 8 25
    //    int n = sr.nextInt();
    //    int []arr = new int[n];
    //    for(int i=0;i<n;i++)
    //    {
    //        arr[i] = sr.nextInt();
    //    }
    //
    //    int move_count = 0;
    //    int min_move_value = 1001;
    //    for(int i =0;i<n;i++)
    //    {
    //        if(min_move_value<arr[i])
    //        {
    //            move_count++;
    //            continue;
    //        }
    //        for(int j = i+1;j<n;j++)
    //        {
    //            if(arr[i]>arr[j])
    //            {
    //                move_count++;
    //                min_move_value = arr[i];
    //                break;
    //            }
    //        }
    //    }
    //    System.out.println(move_count);
    //}


    //或者方法二：
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int []arr = new int[n];
        int[] sortArr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sr.nextInt();
            sortArr[i] = arr[i];
        }

        Arrays.sort(sortArr);

        int count = 0;
        int j = 0;
        for(int i =0;i<n;i++)
        {
            if(arr[i]==sortArr[j])
            {
                count++;
                j++;
            }
        }
        System.out.println(n-count);
    }
}