package InterviewDirectory.tenth_sortalgorithm;


import offer.aMoreThanHalfNum_Solution;

/**
 * Created by huali on 2018/4/5.
 */
public class quicksort {
    //快速排序
    // 快速排序是不稳定的，其时间平均时间复杂度是O(nlogn)。最坏的复杂度是O(N^2)，空间复杂度是O(logn)
    //基本思想：（分治）
    //
    //先从数列中取出一个数作为key值；
    //将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
    //对左右两个小数列重复第二步，直至各区间只有1个数。
    public void quicksort(int[]arr, int l, int r)
    {
        if(arr==null||arr.length==0||l>=r)
            return ;
        int left = l;
        int right = r;
        int pivot = arr[left]; //选择第一个数为key
        while (left<right)
        {
            while (left<right&&arr[right]>=pivot)
            {
                right--;
            }
            if(left<right)
            {
                arr[left] = arr[right];
                left++;
            }
            while (left<right&&arr[left]< pivot)
                left++;
            if(left<right)
            {
                arr[right]=arr[left];
                right--;
            }
        }
        arr[left] = pivot;
        quicksort(arr, l, left-1);
        quicksort(arr, left+1, r);
    }

    public static void main(String []args)
    {
        int[] data5 = new int[] { 5, 3, 6, 0, 2, 1, 9, 4, 8, 7 };
        new quicksort().quicksort2(data5, 0, data5.length-1);
        System.out.println("排序后的数组：");

    }

    public void quicksort2(int []arr, int left, int right)
    {
        if(arr==null||arr.length==0||left>=right)
            return ;
        int pivot = partition(arr, left, right);
        quicksort(arr, left, pivot-1);
        quicksort(arr, pivot+1, right);
    }
    public int partition(int []arr, int left, int right)
    {
        int l = left;
        int r =right;
        int temp = arr[l];
        while (l<r)
        {
            while (l<r&&arr[r]>temp)
                r--;
            if(l<r)
            {
                arr[l] = arr[r];
                l++;
            }
            while (l<r&&arr[l]<temp)
                l++;
            if(l<r)
            {
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = temp;
        return l;
    }




    //另外一种快速排序
    //另一种实现划分的思路是先从左到右扫描一个比基准数大的元素，
    // 再从右到左扫描一个比基准数小的元素（左右两个指针i、j滑动），
    // 然后交换这两个元素，重复操作直到两指针相遇，
    // 然后将基准元素arr[left]与左子序列最后的元素arr[j]进行交换即可，用代码描述为：

    public int partition1(int arr[] ,int left ,int right)
    {
        int i = left+1, j = right;
        int temp = arr[left];
        while (i<j) {
            while (arr[i] < temp && i < right) {
                i++;
            }
            while (arr[j] > temp && j >left) {
                j--;
            }
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr,left, j);
        return j;
    }


    public void quicksort3(int []arr, int left, int right)
    {
        if(arr==null||arr.length==0||left>=right)
            return ;
        int pivot = partition1(arr, left, right);
        quicksort(arr, left, pivot-1);
        quicksort(arr, pivot+1, right);
    }

    public void swap(int[]arr, int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}