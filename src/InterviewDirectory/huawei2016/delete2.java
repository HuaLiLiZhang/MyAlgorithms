package InterviewDirectory.huawei2016;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/7.
 */
public class delete2 {
    //有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
    //
    //输入描述:
    //每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
    //
    //
    //输出描述:
    //一行输出最后一个被删掉的数的原始下标位置。
    //
    //输入例子1:
    //8
    //
    //输出例子1:
    //6
    public static  void main(String []args)
    {
        Scanner sr = new Scanner(System.in);

        while (sr.hasNext())
        {
            int num = sr.nextInt();
            int []arr = new int[num];
            for(int i=0;i<num;i++)
            {
                arr[i] = i;
            }
            int count = 0;
            int count2 = 0;
            while (count<num-1)
            {
                for(int i =0;i<num;i++)
                {
                    if(arr[i]==-1)
                    {
                        continue;
                    }
                    else if(count2==2){
                        int j=i;
                        while (arr[j]==-1)
                        {
                            j--;
                        }
                        arr[j] =-1;
                        count++;
                        count2=0;
                    }else {
                        count2++;
                    }
                }
            }
            int k=0;
            while (arr[k]==-1)
            {
                k++;
            }
            System.out.println(k);
        }
        sr.close();

    }
}