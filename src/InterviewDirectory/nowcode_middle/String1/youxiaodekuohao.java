package InterviewDirectory.nowcode_middle.String1;

import java.util.Stack;

/**
 * Created by huali on 2018/10/10.
 */
public class youxiaodekuohao {
    //有效的括号字符串，利用栈
    public static void main(String[] args)
    {
        String str = "((()())())";
        Stack<Character> stack = new Stack<>();
        int i = 0;
        for(;i<str.length();i++)
        {
            if(str.charAt(i)=='(')
                stack.push(str.charAt(i));
            else if(!stack.isEmpty()&&stack.peek()=='(')
                stack.pop();
            else
            {
                break;
            }
        }
        if(stack.isEmpty()&&i>=str.length())
            System.out.println("合法");
        else
            System.out.println("不合法");
    }
}