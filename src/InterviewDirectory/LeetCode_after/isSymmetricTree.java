package InterviewDirectory.LeetCode_after;


/**
 * Created by huali on 2018/7/10.
 */
public class isSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null||root.left==null&&root.right==null)
            return true;
        return isequal(root.left, root.right);
    }

    private boolean isequal(TreeNode L, TreeNode R) {
        if(L==null&&R==null)
            return true;
        if(L!=null&&R!=null&&L.val==R.val)
            return isequal(L.left,R.right)&&isequal(L.right, R.left);
        return false;
    }

}