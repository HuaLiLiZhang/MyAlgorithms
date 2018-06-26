package InterviewDirectory.tenth_sortalgorithm;

/**
 * Created by huali on 2018/4/5.
 */
public class heapSort {
    //堆排序
    //平均时间复杂度：O(NlogN), 空间复杂度：O(1)
    //由于每次重新恢复堆的时间复杂度为O(logN)，
    // 共N - 1次重新恢复堆操作，
    // 再加上前面建立堆时N / 2次向下调整，
    // 每次调整时间复杂度也为O(logN)。
    // 二次操作时间相加还是O(N * logN)。

    //堆排序是借助堆来实现的选择排序，
    // 思想同简单的选择排序，以下以大顶堆为例。
    // 注意：如果想升序排序就使用大顶堆，反之降序使用小顶堆。
    // 原因是堆顶元素需要交换到序列尾部

    //大顶堆和小顶堆区别：
    //每个结点的值都大于等于其左右孩纸结点的值，称为大顶堆.
    //每个结点的值都小于等于其左右孩纸结点的值，称为小顶堆。
    //将根节点最大的堆叫做最大堆或大根堆，根节点最小的堆叫做最小堆或小根堆。

    //从算法描述来看，堆排序需要两个过程，
    // 一是建立堆，二是堆顶与堆的最后一个元素交换位置。
    // 所以堆排序有两个函数组成。一是建堆的渗透函数，
    // 二是反复调用渗透函数实现排序的函数
    public void heapsort(int []arr)
    {
        if(arr == null || arr.length == 0)
            return ;
        //建立大顶堆：节点值大于等于其左右孩纸结点的值。，然后要将堆顶元素需要交换到序列尾部，形成数组上的升序。
        for(int i =arr.length/2;i>=0;i--)
        {
            heapAdjust(arr, i, arr.length-1);
        }//先将数组堆化。

        for(int i =arr.length-1;i>=0;i--)
        {
            swap(arr, 0, i);
            heapAdjust(arr, 0,i-1);
        }
    }

    public void heapAdjust(int[]arr, int start ,int end)
    {
        /**
         堆筛选，除了start之外，start~end均满足大顶堆的定义。
         * 调整之后start~end称为一个大顶堆。
         * @param arr 待调整数组
         * @param start 起始指针
         * @param end 结束指针
         */
        int temp = arr[start];
        //利用二叉树的性质，根节点与孩纸结点的关系。
        for(int i = start*2+1;i<=end;i*=2)
        {
            //左右孩子的节点分别为2*i+1,2*i+2
            //一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。
            // 它的左右子结点下标分别为2 * i + 1和2 * i + 2。
            // 如第0个结点左右子结点下标分别为1和2。
            //选择出左右孩子较小的下标
            if(i<end&&arr[i]<arr[i+1])
            {
                i++;
            }
            if(temp>=arr[i])
                break;//已经为大顶堆，=保持稳定性。
            arr[start] = arr[i]; //将子节点上移
            start = i; //下一轮筛
        }
        arr[start] = temp;
    }

    public void swap(int[]arr, int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String []args)
    {
        int[] data5 = new int[] { 5, 3, 6, 0, 2, 1, 9, 4, 8, 7 };
        print(data5);
        new heapSort().heapsort(data5);
        System.out.println("排序后的数组：");
        print(data5);
    }
    public    static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

}