package InterviewDirectory.LeetCode_after;

/**
 * Created by huali on 2018/7/10.
 */
public class isSameTreeTwo {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return issame(p,q);
    }

    private boolean issame(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        if(p!=null&&q!=null&&p.val==q.val)
            return issame(p.left,q.left)&&issame(p.right,q.right);
        return false;
    }
}