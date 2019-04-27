package InterviewDirectory.nowcode_middle.stack1;

/**
 * Created by huali on 2018/10/11.
 */
public class WindowsMaxvalue {
    public static void main(String[] args)
    {
        int [] arr = {4,3,5,4,3,3,6,7};
        //滑动窗口的最大值 :5 5 5 4 6 7
        int w = 3;
        int [] re = new int[arr.length-w+1];
        int j = 0;
        for(int i = 0;i<arr.length;i++)
        {
            int max = Integer.MIN_VALUE;
            for(int k = i;k<i+w&&k<arr.length;k++)
            {
                max = Math.max(max,arr[k]);
            }
            if(j<re.length)
            {
                re[j++] = max;
                System.out.print(re[j-1]+" ");
            }
        }

    }
}