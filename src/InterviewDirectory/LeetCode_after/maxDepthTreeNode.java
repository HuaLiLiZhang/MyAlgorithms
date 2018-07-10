package InterviewDirectory.LeetCode_after;

/**
 * Created by huali on 2018/7/10.
 */
public class maxDepthTreeNode {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 1;
        return findLength(root, 0);
    }

    private int findLength(TreeNode root, int level) {
        if(root==null)
            return level;
        int left = findLength(root.left, level+1);
        int right = findLength(root.right,level+1);
        if(left>right)
            level = left;
        else
            level = right;
        return level;
    }
}