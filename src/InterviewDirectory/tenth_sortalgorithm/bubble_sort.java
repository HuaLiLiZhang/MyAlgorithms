package InterviewDirectory.tenth_sortalgorithm;

/**
 * Created by huali on 2018/4/5.
 */
public class bubble_sort {
    //冒泡排序：时间复杂度是：O(n^2)，最坏时间复杂度是：O(n^2), 空间复杂度是O(1)
    //冒泡排序是：i 从0  --  arr.length-1,j从arr.length-1 到i，交换j<j-1的数，把最小的数，放在开头。
    //改进可以设置一个flag ，表示已经排序好，不需要在继续遍历，比较
    public void bubblesort(int []arr)
    {
        if(arr==null||arr.length==0)
            return ;

        for(int i=0;i<arr.length;i++)
        {
            for(int j=arr.length-1;j>i;j--)
            {
                if(arr[j]<arr[j-1])
                    swap(arr, j,j-1);
            }
        }
    }
    public void swap(int[]arr, int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //改进可以设置一个flag ，表示已经排序好，不需要在继续遍历，比较
    public void bubblesort2(int []arr)
    {
        if(arr==null||arr.length==0)
            return ;
        boolean flag = true;
        for(int i=0;i<arr.length&&flag;i++)
        {
            flag = false;
            for(int j = arr.length-1;j>i;j--)
            {
                if(arr[j]<arr[j-1])
                {
                    flag = true;
                    swap(arr, j,j-1);
                }
            }
        }
    }
}