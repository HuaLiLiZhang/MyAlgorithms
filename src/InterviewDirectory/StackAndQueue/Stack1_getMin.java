package InterviewDirectory.StackAndQueue;


import java.util.Stack;

/**
 * Created by huali on 2018/3/9.
 */
public class Stack1_getMin {
    /**
     * 0.设计两个栈，一个栈用来保存当前元素，一个栈用来保存每一步的最小值。
     * 1.压入数据,当前数据为newNum,先将其压入stackData，然后判断stackMin是否为空，为空则压入；
     * 不为空，则比较newNum和stackMin的栈顶元素哪一个更小。
     * 如果newNum更小或则相等，则压入stackMin中
     * 如果stackMin栈顶元素小，则不压入任何内容。
     * 2.弹出数据：先弹出stackData的元素，即为value，然后比较当前stackMin的栈顶元素和value哪一个更小；
     * 因为stackMIn中是存储的输入的较小元素，所以比较时，当前stackMin的栈顶元素一定小于等于value。
     * 当value等于stackMIn的栈顶元素时，stackMin弹出栈顶元素，返回value。//应该返回最小值。而不是value吧？
     * 如果value大于当前stackMin的栈顶元素，则不弹出当前stackMin的栈顶元素。
     * 3.查询：stackMin始终记录着stackData中的最小值，返回栈顶元素即为最小值。
     */
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public Stack1_getMin()
    {
        this.stackMin=new Stack<>();
        this.stackData=new Stack<>();
    }
    public void push(int newNum)
    {
        if(this.stackMin.isEmpty())
            this.stackMin.push(newNum);
        else
        {
            if(newNum<=this.getMin())
            {
                this.stackMin.push(newNum);
            }
        }
        this.stackData.push(newNum);

    }
    public int pop()
    {
        if(this.stackData.isEmpty())
            throw new RuntimeException("your stack is empty");
        int value = this.stackData.pop();
        int min=0;
        if(value==this.getMin())
        {
            min=value;
            this.stackMin.pop();
        }
        else
            min=this.getMin();

        return min;
    }
    public int getMin()
    {
        if(this.stackMin.isEmpty())
        {
            throw new RuntimeException("your stack is empty!");
        }
        return this.stackMin.peek();
    }


//push 改进
    public void push1(int newNum)
    {
        if(this.stackMin.isEmpty())
            this.stackMin.push(newNum);
        else
        {
            if(newNum<this.getMin())
            {
                this.stackMin.push(newNum);
            }
            else{
                int newMin = this.stackMin.peek();
                stackMin.push(newMin);
            }
        }
        this.stackData.push(newNum);
    }

    //pop改进
    public int pop1()
    {
        if(this.stackData.isEmpty())
        throw new RuntimeException("you dataStack is empty!");
        if(this.stackData.empty())
            throw new RuntimeException("you dataStack is empty!");
        this.stackData.pop();
        return this.stackMin.pop();
    }



}