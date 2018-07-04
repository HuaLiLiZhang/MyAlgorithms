package InterviewDirectory.LeetCode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huali on 2018/7/3.
 */
public class runMInpathTree {
    public int run(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int count=0;
        if(root==null)
            return 0;
        if(root.left==null)
            return run(root.right)+1;
        if(root.right==null)
            return run(root.left)+1;
        int leftDepth = run(root.left);
        int rightDepth = run(root.right);
        return (leftDepth<rightDepth) ?leftDepth+1:rightDepth+1;
    }

    public int run1(TreeNode root)
    {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int len = queue.size();
            depth++;
            for(int i=0;i<len;i++)
            {
                TreeNode cur = queue.poll();
                if(cur.left==null&&cur.right==null)
                    return depth;
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(root.right);
            }
        }
        return depth;

    }



}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}