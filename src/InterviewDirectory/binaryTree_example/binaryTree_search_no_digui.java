package InterviewDirectory.binaryTree_example;

import javax.xml.soap.Node;
import java.util.Stack;

/**
 * Created by huali on 2018/3/17.
 */
public class binaryTree_search_no_digui {
    //非递归方法实现，前序和中序，后序遍历二叉树
    public void preorderUnRecur(TreeNode root)
    {
        System.out.print("pre-order:");
        if(root!=null)
        {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty())
            {
                root = stack.pop();
                System.out.print(root.val+" ");
                if(root.right!=null)
                    stack.push(root.right);
                if(root.left!=null)
                    stack.push(root.left);
            }
        }
        System.out.println();
    }

    public void inOrderUnRecur(TreeNode root)
    {
        System.out.print("in-order:");
        if(root!=null)
        {
            Stack<TreeNode> stack  = new Stack<TreeNode>();
            while (!stack.isEmpty()||root!=null)
            {
                if(root!=null)
                {
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    System.out.print(root.val+" ");
                    root = root.right;
                }
            }
        }
        System.out.println();

    }


    public void posOrderUnREcur(TreeNode root)//用两个栈实现后序遍历。
    {
        System.out.print("pos-order:");
        if(root!=null)
        {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty())
            {
                root = stack1.pop();
                stack2.push(root);
                if(root.left!=null)
                    stack1.push(root.left);
                if(root.right!=null)
                    stack1.push(root.right);
            }
            while (!stack2.isEmpty())
            {
                System.out.print(stack2.pop().val+" ");
            }
        }
        System.out.println();
    }

    public void posOrderUnrecur2(TreeNode root)
    {
        System.out.print("pos-order:");
        if(root!=null)
        {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode c = null;
            while (!stack.isEmpty())
            {
                c=stack.peek();
                if(c.left!=null&&root!=c.left&&root!=c.right){
                    stack.push(c.left);
                }else if(c.right!=null&&root!=c.right){
                    stack.push(c.right);
                }else {
                    System.out.print(stack.pop().val+" ");
                    root = c;
                }
            }
        }
        System.out.println();
    }
}