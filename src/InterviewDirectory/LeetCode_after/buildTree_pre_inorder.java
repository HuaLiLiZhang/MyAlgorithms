package InterviewDirectory.LeetCode_after;


/**
 * Created by huali on 2018/7/10.
 */
public class buildTree_pre_inorder {
    public TreeNode bulidtree(int[] preorder, int[] inorder)
    {
        if(inorder==null&&preorder==null||inorder.length<=0&&preorder.length<=0)
            return null;
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int prestart, int preend,
                               int[] inorder, int istart, int iend) {
        int rootvalue = preorder[prestart];
        TreeNode root = new TreeNode(rootvalue);
        root.left=root.right = null;
        if(prestart == preend)
        {
            if(istart==iend&&preorder[prestart]==inorder[istart])
                return root;
            else
                return null;
        }
        int rootInorder = istart;
        while (rootInorder<=iend&&inorder[rootInorder]!=rootvalue)
            ++rootInorder;
        if(rootInorder==iend&&inorder[rootInorder]!=rootvalue)
            return null;
        int leftlength = rootInorder-istart;
        int leftpreorderend = prestart+leftlength;
        if(leftlength>0)
        {
            root.left = buildTree(preorder,prestart+1, leftpreorderend,
                    inorder, istart, rootInorder-1);

        }
        if(leftlength<preend-prestart)
        {
            root.right = buildTree(preorder,leftpreorderend+1, preend,
                    inorder, rootInorder+1,iend);
        }
        return root;

    }
}