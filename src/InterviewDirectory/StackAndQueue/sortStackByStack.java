package InterviewDirectory.StackAndQueue;

import java.util.Stack;

/**
 * Created by huali on 2018/3/9.
 */
public class sortStackByStack {

        public static void stacksort(Stack<Integer> stack)
        {
            Stack<Integer> help = new Stack<Integer>();
            if(stack.isEmpty())
                return ;
            while (!stack.isEmpty())
            {
                int result = stack.pop();
                while (!help.isEmpty()&&result>help.peek())
                {
                    stack.push(help.pop());
                }
                help.push(result);
            }
            //前面栈底到栈顶从大到小排序，现在重新插入到Stack中，栈顶到栈底从大到小。
            while (!help.isEmpty())
            {
                stack.push(help.pop());
            }

        }

}