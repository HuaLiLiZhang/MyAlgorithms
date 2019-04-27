package InterviewDirectory.nowcode_middle.stack1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by huali on 2018/10/11.
 */
public class WindowsMaxValueOn {
    //滑动窗口的最大值，O(N)时间复杂度
    //滑动窗口的最大值 :5 5 5 4 6 7
    public static void main(String[] args)
    {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        Deque<Integer> deque = new ArrayDeque<>();
        //用双端队列存储数组的下标
        for(int i = 0;i<arr.length;i++)
        {
            if(!deque.isEmpty())
            {
                //如果双端队列不为空，取出双端队列的队尾下标j
                //如果arr[j]>arr[i]直接把下标i放入到双端队列的队尾
                int j = deque.peekLast();
                if(arr[j]>arr[i])
                {
                    deque.addLast(i);
                }
                else {
                    //如果arr[j]<=arr[i],如果双端队列不为空，一直从队列中暗处下标，直到某个下标在队列中对应的值大于arr[i]
                    //然后再将其放入到双端队列的队尾。
                    while (!deque.isEmpty()&&arr[deque.peekLast()]<=arr[i])
                    {
                        deque.pollLast();
                    }
                    deque.addLast(i);
                }
                //然后判断下标元素是否过期，是否在滑动窗口内。
                //如果在滑动窗口内，且第一个滑动窗中元素全部进双端队列，且双端队列中的对头的下标大于i-w,
                // 那么输出双端队列的对头的下标所对应的元素。
                if(i-w>=-1&&i-w<deque.peekFirst())
                {
                    System.out.print(arr[deque.peekFirst()]+" ");
                }else {
                    //如果双端队列中的对头的下标等于i-w,弹出队列中的对头的下标。
                    while (!deque.isEmpty()&&i-w>=deque.peekFirst())
                        deque.pollFirst();
                    ////如果在滑动窗口内，且双端队列中的对头的下标大于i-w,
                    // 那么输出双端队列的对头的下标所对应的元素。
                    if(!deque.isEmpty()&&i-w>=-1&&i-w<deque.peekFirst())
                        System.out.print(arr[deque.peekFirst()]+" ");
                }
            }else {
                deque.addLast(i);
            //    如果队列为空，直接将下标i加入到双端队列中。
            }
        }

    }
}