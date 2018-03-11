package InterviewDirectory.StackAndQueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by huali on 2018/3/11.
 */
public class getMaxTree {
    public TreeNode getmaxtree(int[]arr)
    {
        TreeNode [] nArr = new  TreeNode[arr.length];
        for(int i=0;i!=arr.length;++i)
        {
            nArr[i]=new TreeNode(arr[i]);
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        HashMap<TreeNode,TreeNode> lBigMap = new HashMap<>();
        HashMap<TreeNode,TreeNode> rBigMap = new HashMap<>();
        for(int i=0;i!=nArr.length;++i)
        {
            TreeNode curNode = nArr[i];
            while ((!stack.isEmpty())&&stack.peek().val<curNode.val)
            {
                popstackSetMap(stack,lBigMap);
            }
            stack.push(curNode);
        }

        while (!stack.isEmpty())
        {
            popstackSetMap(stack,lBigMap);
        }

        for (int i= nArr.length-1;i!=-1;i--)
        {
            TreeNode curNode = nArr[i];
            while ((!stack.isEmpty())&&stack.peek().val<curNode.val)
            {
                popstackSetMap(stack,rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty())
        {
            popstackSetMap(stack,rBigMap);
        }

        TreeNode head = null;
        for(int i=0;i!=nArr.length;++i)
        {
            TreeNode curNode = nArr[i];
            TreeNode left = lBigMap.get(curNode);
            TreeNode right = rBigMap.get(curNode);
            if(left==null&&right==null)
            {
                head = curNode;
            }
            else if(left==null)
            {
                if(right.left==null)
                    right.left=curNode;
                else
                    right.right=curNode;
            }
            else if(right==null)
            {
                if(left.left==null)
                {
                    left.left=curNode;
                }
                else
                {
                    left.right=curNode;
                }
            }else
            {
                TreeNode parent = left.val<right.val?left:right;
                if(parent.left == null)
                {
                    parent.left=curNode;
                }else {
                    parent.right=curNode;
                }
            }
        }
        return head;
    }

    public void popstackSetMap(Stack<TreeNode> stack,HashMap<TreeNode,TreeNode>map)
    {
        TreeNode popNode = stack.pop();
        if(stack.isEmpty())
            map.put(popNode,null);
        else
            map.put(popNode,stack.peek());
    }
}