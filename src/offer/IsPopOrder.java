package offer;

import java.util.Stack;

/**
 * Created by huali on 2018/6/21.
 */
public class IsPopOrder {
    public boolean IsPopOrders(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack<>();
        int i=0;
        for(int j=0;j<popA.length;j++)
        {
            if(i<pushA.length&&pushA[i]!=popA[j])
            {
                while(i<pushA.length&&pushA[i]!=popA[j])
                {
                    s.push(pushA[i]);
                    i++;
                }

            }
            if(!s.isEmpty()&&popA[j]==s.peek())
            {
                s.pop();
                continue;
            }
            if(i<pushA.length&&pushA[i]==popA[j])
                i++;

        }
        if(!s.isEmpty())
            return false;
        return true;

    }

    public static void main(String[]args)
    {
        int [] a1 = {1};
        int []a2= {1};
        System.out.println(new IsPopOrder().IsPopOrders(a1,a2));
    }

}