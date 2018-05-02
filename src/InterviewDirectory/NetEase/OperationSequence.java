package InterviewDirectory.NetEase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/2.
 */
public class OperationSequence {

    //小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
    //1、将a_i放入b序列的末尾
    //2、逆置b序列
    //小易需要你计算输出操作n次之后的b序列。

    public static void main(String[] args)
    {
        Scanner sr = new Scanner(System.in);

        while (sr.hasNext())
        {
            int n = sr.nextInt();
            int []arr = new int[n];
            for(int i = 0;i<n;i++)
            {
                arr[i] = sr.nextInt();
                //if(i>=1)
                //{
                //    reverse(arr, 0, i);
                //}
            }
            //System.out.println(Arrays.toString(arr));  //[4, 2, 1, 3]
            //System.out.println(Arrays.asList(arr));
            //for(int j=0;j<n;j++)
            //{
            //    if(j==n-1)
            //        System.out.print(arr[j]);
            //    else
            //        System.out.print(arr[j]+" ");
            //}
            for(int i =n-1;i>=0;i-=2)
            {
                System.out.print(arr[i]+" ");
            }
            for(int i=n%2;i<n-2;i+=2)
            {
                System.out.print(arr[i]+" ");
            }
            System.out.print(arr[n-2]);
        }
        sr.close();
    }
    //public static void reverse(int []arr ,int start, int end)
    //{
    //    while (start<end)
    //    {
    //        int temp = arr[start];
    //        arr[start] = arr[end];
    //        arr[end] = temp;
    //        start++;
    //        end--;
    //    }
    //}




}