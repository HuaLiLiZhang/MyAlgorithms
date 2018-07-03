package offer;


import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by huali on 2018/7/3.
 */
public class maxInWindows1 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(num==null||num.length<=0||size<0||size>num.length)
            return list;
        return getMaxList(list, num, size);
    }

    private ArrayList<Integer> getMaxList(ArrayList<Integer> list, int[] num, int size) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<size;i++)
        {
            if(!queue.isEmpty()&&num[i]>num[queue.getLast()])
            {
                queue.removeLast();
            }
            queue.add(i);
        }

        for(int i=size;i<num.length;i++)
        {
            list.add(num[queue.getFirst()]);
            while (!queue.isEmpty()&&num[i]>num[queue.getLast()])
                queue.removeLast();
            if(!queue.isEmpty()&&queue.getFirst()<=i-size)
                queue.removeFirst();
            queue.add(i);
        }
        list.add(num[queue.getFirst()]);
        return list;
    }
}