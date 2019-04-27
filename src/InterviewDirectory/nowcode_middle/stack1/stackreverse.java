package InterviewDirectory.nowcode_middle.stack1;

import java.util.Stack;


/**
 * Created by huali on 2018/10/11.
 */
public class stackreverse {
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(getlast1(stack));
        reverse(stack);
    }
    public static void  reverse(Stack<Integer> s)
    {
        if(s.isEmpty())
            return;
        int i = getlast1(s);
        reverse(s);
        s.push(i);
    }

    //把最后一个元素返回，并将剩下的元素重新插入。
    private static int  getlast1(Stack<Integer> stack) {
        int result = stack.pop();  //递归
        //栈中的元素如果是最后一个元素，辣么返回。
        if(stack.isEmpty())
        {
            return result;
        }
        else {
            //如果不是最后一个元素，一次递归
            int last = getlast1(stack);  //得到最后一个元素，然后再把前面的元素一次插入到stack中。
            stack.push(result);  //后面的元素先插入，前面的元素后插入，还是原来的顺序
            return last;    //然后返回最后一个元素
        }
    }
}