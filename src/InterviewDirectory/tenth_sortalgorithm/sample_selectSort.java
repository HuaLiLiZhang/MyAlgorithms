package InterviewDirectory.tenth_sortalgorithm;

/**
 * Created by huali on 2018/4/5.
 */
public class sample_selectSort {
    //简单选择排序。时间复杂度是：O(N^2) ，空间复杂度是：O(1)
    //选取最小的和未排序的第一个交换。
    //基本思想：
    //在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
    //第二次遍历n-2个数，找到最小的数值与第二个元素交换；
    //。。。
    //第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
    public void selectsort1(int[]arr)
    {
        if(arr==null||arr.length==0)
            return ;
        int minindex = 0;
        for(int i=0;i<arr.length-1;i++)//只需要比较n-1次
        {
            minindex = i;
            for(int j =i+1;j<arr.length;j++) //从i+1开始比较，因为minIndex默认为i了，i就没必要比了。
            {
                if(arr[minindex]>arr[j])
                {
                    minindex = j;
                }
            }
            if(minindex!=i)
            {
                swap(arr, i, minindex);//如果minIndex不为i，说明找到了更小的值，交换之。
            }

        }
    }

    public void swap(int[]arr, int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}