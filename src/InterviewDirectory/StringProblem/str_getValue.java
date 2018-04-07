package InterviewDirectory.StringProblem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by huali on 2018/4/7.
 */
public class str_getValue {
    /**
     * 1.认定字符串一定是正确格式，不做有效性检查。
     * 2.如果是负数的话，需要用括号括起来4*（-3），但是如果负数作为开头的话，
     * 或部分括号开头的话，可以不用加括号
     * 3.不考虑计算发生溢出的情况
     */
    public int getValue(String str)
    {
        char[]chars = str.toCharArray();
        return  value(chars, 0)[0];

    }
    public int [] value(char[] chars ,int i)
    {
        Deque<String> deq = new LinkedList<>();
        int pre = 0;
        int []bra= null;  //存计算返回值和下一步继续遍历位置。
        while (i<chars.length&&chars[i]!=')')
        {
            if(chars[i]>='0'&&chars[i]<='9')
            {
                pre = pre *10+chars[i++]-'0';
            }else if(chars[i]!='(')
            {
                addNum(deq, pre);
                deq.addLast(String.valueOf(chars[i++]));
                pre = 0;
            }else {
                bra = value(chars, i+1);
                pre = bra[0];
                i = bra[1]+1;
            }
        }
        addNum(deq,pre);
        return new int[]{getNum(deq), i};
    }
    public void addNum(Deque<String> deq , int num)
    {
        if(!deq.isEmpty())
        {
            int cur = 0;
            String top = deq.pollLast();
            if(top.equals("+")||top.equals("-"))
            {
                deq.addLast(top);
            }
            else {
                cur = Integer.valueOf(deq.pollLast());
                num = top.equals("*")?(cur*num):(cur/num);
            }
        }
        deq.addLast(String.valueOf(num));
    }

    public int getNum(Deque<String> deque)
    {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!deque.isEmpty())
        {
            cur = deque.pollFirst();
            if(cur.equals("+")) {
                add = true;
            }else if(cur.equals("-")) {
                    add = false;
            }else {
                num = Integer.valueOf(cur);
                res+= add?num:(-num);
            }
        }
        return res;
    }
}