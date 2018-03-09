package InterviewDirectory.StackAndQueue;

import java.util.Stack;

/**
 * Created by huali on 2018/3/9.
 */
public class ReverseStack {
    public int getAndRemoveLastElement(Stack<Integer> stack)
    {
        int result = stack.pop();
        if(stack.isEmpty())
        {
            return result ;
        }else
        {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack)
    {
        if(stack.isEmpty())
            return;
        int i =getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}