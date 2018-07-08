package InterviewDirectory.LeetCode_after;


/**
 * Created by huali on 2018/7/8.
 */
public class hasPathSumtrue {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null || root.left == null && root.right == null && sum != root.val)
            return false;
        return ishaspath(root, sum);
    }

    private boolean ishaspath(TreeNode root, int sum) {
        if (root != null && root.left == null && root.right == null && sum == root.val)
            return true;
        if (root != null)
            return ishaspath(root.left, sum - root.val)
                    || ishaspath(root.right, sum - root.val);
        return false;
    }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(5);
        TreeNode h1 = new TreeNode(4);
        TreeNode h2 = new TreeNode(8);
        TreeNode h3 = new TreeNode(11);
        TreeNode h4 = new TreeNode(13);
        TreeNode h5 = new TreeNode(4);
        TreeNode h6 = new TreeNode(7);
        TreeNode h7 = new TreeNode(2);
        TreeNode h8 = new TreeNode(5);
        TreeNode h9 = new TreeNode(1);
        head.left = h1;
        head.right=h2;
        h1.left = h3;h1.right=null;
        h2.left = h4;h2.right=h5;
        h3.left = h6;h3.right=h7;
        h4.left = null;h4.right=null;
        h5.left = h8;h5.right=h9;
        h6.left = null;h6.right=null;
        h7.left = null;h7.right=null;
        h8.left = null;h9.right=null;
        h9.left = null;h9.right=null;
        //TreeNode head = new TreeNode(-2);
        //TreeNode h2 = new TreeNode(-3);
        //head.left = null;
        //head.right = h2;
        //h2.left = null;
        //h2.right = null;
        hasPathSumtrue pathSumTree = new hasPathSumtrue();
        boolean re = pathSumTree.hasPathSum(head, 22);
        System.out.println(re);

    }
}