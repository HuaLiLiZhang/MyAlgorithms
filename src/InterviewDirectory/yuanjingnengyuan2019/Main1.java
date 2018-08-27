package InterviewDirectory.yuanjingnengyuan2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/8/27.
 */
public class Main1 {
    //LeetCode上面的题，
    //实现下一个排列，重新排列数字，使它们按字典序下一大的排列。
    //
    //如果没有下一大的排列，那么就排成字典序最小的排列。
    //
    //必须在原数组上就地排列，不能分配额外的内存空间。

    //3 1<br/>2 3 1<br/>3 1<br/>3 2 1<br/>10 2<br/>1 2 3 4 5 6 7 8 9 10

    //3 1
    //2 3 1
    //3 1 2
    //3 1
    //3 2 1
    //1 2 3
    //10 2
    //1 2 3 4 5 6 7 8 9 10
    //1 2 3 4 5 6 7 9 8 10
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int num [] = new int[n];
            for(int i = 0;i<n;i++)
            {
                num[i] = sc.nextInt();
            }

            for(int i = 0;i<k;i++)
            {
                nextPermutation(num);
            }
            for(int i : num)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        sc.close();

    }

    public static void nextPermutation(int[] num) {
        if(num==null||num.length==0)
            return ;
        int i=num.length-2;
        //从后往前看最大升序的位置。
        while(i>=0&&num[i]>=num[i+1])
            i--;
        if(i>=0){
            int j=i+1;
            while(j<num.length&&num[j]>num[i])
                j++;
            j--;
            swap(num,i,j);
        }
        reverse(num,i+1,num.length-1);
    }
    public static void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
    }
    public static void reverse(int[] num,int i,int j){
        while(i<j)
            swap(num,i++,j--);
    }

}