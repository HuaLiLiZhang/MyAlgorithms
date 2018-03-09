package InterviewDirectory.StackAndQueue;

import sun.invoke.empty.Empty;

import java.util.Stack;

/**
 * Created by huali on 2018/3/9.
 */
public class TwoStackQueue {
    //利用   IsEmpty   函数决定变量是否能被初始化：
    //Dim   MyVar,   MyCheck
    //MyCheck   =   IsEmpty(MyVar)             '   返回   True。
    //MyVar   =   Null                                     '   赋为   Null。
    //MyCheck   =   IsEmpty(MyVar)             '   返回   False。
    //MyVar   =   Empty                                   '   赋为   Empty。
    //MyCheck   =   IsEmpty(MyVar)             '   返回   True。
    private Stack<Integer> stackPush ;
    private Stack<Integer> stackPop;
    TwoStackQueue()
    {
        stackPop=new Stack<>();
        stackPush = new Stack<>();
    }
    public void add(int pushInt)
    {
        if(stackPop.empty())
        {
            stackPush.push(pushInt);
        }else
        {
            while (!stackPop.isEmpty())
            {
                stackPush.push(stackPop.pop());
            }
            stackPush.push(pushInt);//记得把数组加入到队列呐
        }
    }
    public int poll()
    {
        //不足之处，自己没加为空的处理情况。
        if(stackPop.empty()&&stackPush.empty())
            throw new RuntimeException("queue is empty!");
        //
        else
        {
            //判断stackPop为空的情况
            if(stackPop.empty())
            {//
                while (!stackPush.isEmpty())
                {
                    stackPop.push(stackPush.pop());
                }
            }
        }
        return stackPop.pop();
    }
    public int peek()
    {
        //不足之处，自己没加为空的处理情况。
        if(stackPop.isEmpty()&&stackPush.isEmpty())
            throw new RuntimeException("queue is empty!");
        //
        else if(stackPop.empty())
                 while (!stackPush.isEmpty())
                {
                    stackPop.push(stackPush.pop());
                }
       return stackPop.peek();
    }
}