package InterviewDirectory.LeetCode_after;

/**
 * Created by huali on 2018/7/8.
 */
public class isBalancedTree {
    public boolean isBalanced(TreeNode root) {
        boolean []res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }

    private int getHeight(TreeNode root, int level, boolean[] res) {
        if(root==null)
            return level;
        int lefth = getHeight(root.left, level+1, res);
        if(!res[0])
            return level;
        int righth = getHeight(root.right, level+1, res);
        if(!res[0])
            return level;
        if(Math.abs(lefth-righth)>1)
            res[0] =false;
        return Math.max(lefth,righth);
    }

}