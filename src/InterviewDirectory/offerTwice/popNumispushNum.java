package InterviewDirectory.offerTwice;

import java.util.Stack;

/**
 * Created by huali on 2018/8/19.
 */
public class popNumispushNum {
    public static void main(String[] args)
    {
        int [] push = {1,2,3,4,5};
        int [] pop = {4,3,5,1,2};
        //int [] pop = {5,4,3,2,1};
        //int [] pop = {3,4,2,5,1};
        //int [] pop = {4,3,5,2,1};
        boolean result = ispush(push, pop);
        System.out.println(result);
    }

    private static boolean ispush(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while(i<push.length&&j<pop.length)
        {
            if(push[i]==pop[j])
            {
                i++;
                j++;
            }else
            {
                if(!stack.isEmpty()&&stack.peek()==pop[j])
                {
                    j++;
                    stack.pop();
                }else
                {
                    stack.push(push[i]);
                    i++;
                }
            }
        }
        while (!stack.isEmpty())
        {
            if(stack.peek()==pop[j])
            {
                j++;
                stack.pop();
            }else {
                return false;
            }
        }
        return true;
    }
}