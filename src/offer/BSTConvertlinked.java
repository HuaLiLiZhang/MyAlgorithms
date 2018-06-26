package offer;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by huali on 2018/6/23.
 */
public class BSTConvertlinked {
    public TreeNode Convert(TreeNode pRootOfTree)
    {
        if(pRootOfTree==null)
            return null;
        TreeNode pnode = pRootOfTree;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        boolean isfirst = true;
        while (pnode!=null||!stack.isEmpty())
        {
            while (pnode!=null)
            {
                stack.add(pnode);
                pnode=pnode.left;
            }
            pnode = stack.pop();
            if(isfirst)
            {
                pRootOfTree = pnode;
                pre = pRootOfTree;
                isfirst = false;
            }else
            {
                pre.right = pnode;
                pnode.left = pre;
                pre = pnode;
            }
            pnode = pnode.right;
        }
        return pRootOfTree;

    }
}
