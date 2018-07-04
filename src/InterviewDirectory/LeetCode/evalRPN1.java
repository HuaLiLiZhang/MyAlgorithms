package InterviewDirectory.LeetCode;

import java.util.Stack;

/**
 * Created by huali on 2018/7/3.
 */
public class evalRPN1 {
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length<=0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int end = 0;
        for(int i=0;i<tokens.length;i++)
        {
            while (i<tokens.length&&!tokens[i].equals("+")&&
                    !tokens[i].equals("-")&&
                    !tokens[i].equals("*")&&
                    !tokens[i].equals("/"))
            {
                stack.push(Integer.parseInt(tokens[i]));
                i++;
            }
            if(i<tokens.length&&tokens[i].equals("+"))
            {
                start = stack.pop();
                end = stack.pop();
                end +=start;
                stack.push(end);
            }
            if(i<tokens.length&&tokens[i].equals("-"))
            {
                start = stack.pop();
                end = stack.pop();
                end -=start;
                stack.push(end);
            }
            if(i<tokens.length&&tokens[i].equals("*"))
            {
                start = stack.pop();
                end = stack.pop();
                end *=start;
                stack.push(end);
            }
            if(i<tokens.length&&tokens[i].equals("/"))
            {
                start = stack.pop();
                end = stack.pop();
                end /=start;
                stack.push(end);
            }
        }
        return stack.pop();

    }
}