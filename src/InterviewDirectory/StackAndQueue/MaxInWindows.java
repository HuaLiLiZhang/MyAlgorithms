package InterviewDirectory.StackAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by huali on 2018/3/11.
 */
public class MaxInWindows {
    public ArrayList<Integer> maxinwindows(int[]arr,int w)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(arr==null||arr.length<=0||w<=0||w>arr.length)
            return list;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<w;++i)
        {
            while (!deque.isEmpty()&&arr[i]>arr[deque.getLast()])
                deque.removeLast();
            deque.add(i);
        }

        for(int i=w;i<arr.length;++i)
        {
            list.add(arr[deque.getFirst()]);
            while (!deque.isEmpty()&&arr[i]>arr[deque.getLast()])
                deque.removeLast();
            if(!deque.isEmpty()&&deque.getFirst()<=(i-w))
                deque.removeFirst();
            deque.add(i);
        }
        list.add(arr[deque.getFirst()]);

        return list;
    }



    public int[] maxwindows(int[] arr,int w)
    {
        if(arr==null||arr.length<=0||w<=0||w>arr.length)
            return null;
        LinkedList<Integer> qmax = new LinkedList<>();
        int [] res = new int[arr.length-w+1];
        int index=0;
        for(int i=0;i<arr.length;++i)
        {
            while (!qmax.isEmpty()&&arr[i]>=arr[qmax.getLast()])
                qmax.removeLast();
            qmax.add(i);
            if(!qmax.isEmpty()&&qmax.getFirst()<=i-w)
                qmax.removeFirst();
            if(i>=w-1)
                 res[index++]=arr[qmax.getFirst()];
        }
        return res;
    }
}