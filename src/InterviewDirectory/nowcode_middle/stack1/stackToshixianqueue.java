package InterviewDirectory.nowcode_middle.stack1;

import java.util.Stack;


/**
 * Created by huali on 2018/10/11.
 */
public class stackToshixianqueue {
//    利用两个栈结构实现队列
    static Stack<Integer> astack = new Stack<>();
    static Stack<Integer> pstack = new Stack<>();
    public static void main(String[] args)
    {
        pushdata(1);
        pushdata(2);
        pushdata(3);
        pushdata(4);
        pushdata(5);
        System.out.println(getdata());
        pushdata(6);
        pushdata(7);
        pushdata(8);
        System.out.println(getdata());
    }

    private static void pushdata( int i) {
        while (!pstack.isEmpty())
        {
            astack.add(pstack.pop());
        }
        astack.add(i);
    }

    public static int getdata() {
        while (!astack.isEmpty())
        {
            pstack.add(astack.pop());
        }
        return pstack.pop();
    }

}