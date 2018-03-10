package InterviewDirectory.StackAndQueue;

import java.util.Stack;

/**
 * Created by huali on 2018/3/10.
 */
public class hanoiProblem2 {
    //栈解决汉诺塔问题。
    public int hanoiProblem(int num,String left,String mid,String right)
    {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        lS.push(Integer.MAX_VALUE);//放入整数最大值，放置溢出。
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for(int i=num;i>0;i--)
        {
            lS.push(i);
        }
        hAction2 [] record = {hAction2.No};
        int step = 0;
        while (rS.size()!=num+1)
        {
            step +=fStackToStack(record,hAction2.MToL,hAction2.LToM,lS,mS,left,mid);
            step +=fStackToStack(record,hAction2.LToM,hAction2.MToL,mS,lS,mid,left);
            step +=fStackToStack(record,hAction2.RToM,hAction2.MToR,mS,rS,mid,right);
            step +=fStackToStack(record,hAction2.MToR,hAction2.RToM,rS,mS,right,mid);
        }
        return step;
    }

    public static int fStackToStack(hAction2[] record,hAction2 preNoAct,
                                    hAction2 nowAct,Stack<Integer> fStack,Stack<Integer> tStack,
                                    String from,String to)
    {
        if(record[0]!=preNoAct&&fStack.peek()<tStack.peek())
        {
            tStack.push(fStack.pop());
            System.out.println("move "+tStack.peek()+" from "+from+" to "+to);
            record[0]=nowAct;
            return 1;
        }
        return 0;
    }

}