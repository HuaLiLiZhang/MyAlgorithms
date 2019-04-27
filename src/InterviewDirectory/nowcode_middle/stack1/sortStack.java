package InterviewDirectory.nowcode_middle.stack1;

import java.util.Stack;

/**
 * Created by huali on 2018/10/11.
 */
public class sortStack {
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        sortstackASC(stack);
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

    private static void sortstackASC(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        int cur = 0;
        while (!stack.isEmpty())
        {

            if(temp.isEmpty())
            {
                temp.add(stack.pop());
            }
            else
            {
                if(stack.peek()<=temp.peek())
                {
                    temp.push(stack.peek());
                    stack.pop();
                }
                else
                {
                    cur = stack.pop();
                    while (!temp.isEmpty()&&temp.peek()<=cur)
                    {
                        stack.push(temp.pop());
                    }
                    temp.push(cur);
                }
            }
        }
        while (!temp.isEmpty())
        {
            stack.push(temp.pop());
        }
    }
}