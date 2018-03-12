package InterviewDirectory.StackAndQueue;

import java.util.Stack;

/**
 * Created by huali on 2018/3/12.
 */
public class maxRecSize {
    public int maxrecsize(int[][]map)
    {
        if(map==null||map.length==0||map[0].length==0)
            return 0;
        int maxArea = 0;
        int[]height = new int[map[0].length];
        for(int i =0;i<map.length;++i)
        {//首先将height[]数组代表数组的一行，每行进行叠加，然后求最大矩阵。
            for(int j=0;j<map[0].length;++j)
            {
                height[j] = map[i][j]==0?0:height[j]+1;
            }
            maxArea=Math.max(maxRecFromBottom(height),maxArea);
        }
        return maxArea;
    }
    public int maxRecFromBottom(int[]height)
    {
        if(height==null||height.length==0)
            return 0;
        int maxArea = 0;
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<height.length;i++)
        {
            while (!stack.isEmpty()&&height[i]<=height[stack.peek()])
            {
                int j=stack.pop();
                int k=stack.isEmpty()?-1:stack.peek();
                int curArea = (i-k-1)*height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty())
        {
            int j=stack.pop();
            int k=stack.isEmpty()?-1:stack.peek();
            int curArea = (height.length-k-1)*height[j];
            maxArea=Math.max(maxArea,curArea);
        }
        return maxArea;
    }
}