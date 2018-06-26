package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by huali on 2018/6/21.
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottoms(TreeNode root) {
        ArrayList<Integer> l1 = new ArrayList<>();
        Queue<TreeNode> s1 = new ArrayDeque<>();
        if(root==null)
            return l1;
        s1.offer(root);
        if(root.left==null&&root.right==null)
        {
            l1.add(root.val);
            return l1;
        }
        while (!s1.isEmpty())
        {
            TreeNode node = s1.poll();
            l1.add(node.val);
            if(node.left!=null)
                s1.add(node.left);
            if(node.right!=null)
                s1.add(node.right);
        }
        return l1;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}