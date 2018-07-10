package InterviewDirectory.LeetCode_after;

/**
 * Created by huali on 2018/7/9.
 */
public class buildTree_post_Inorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null&&postorder==null||inorder.length<=0&&postorder.length<=0)
            return null;
        return reconstructor(inorder, 0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    private TreeNode reconstructor(int[] inorder, int istart, int iend,
                                   int[] postorder, int pstart, int pend) {
        if(istart>iend)
            return null;
        TreeNode root = new TreeNode(postorder[pend]);
        if(istart==iend)
            return root;
        int rootnum = 0;
        for(int i=istart;i<=iend;i++)
        {
            if(inorder[i]==postorder[pend])
            {
                rootnum = i;
                break;
            }
        }
        int leftlength = rootnum-istart;
        root.left = reconstructor(inorder,istart,istart+leftlength-1,
                postorder,pstart,pstart+leftlength-1);
        root.right = reconstructor(inorder,istart+leftlength+1, iend,
                postorder, pstart+leftlength,pend-1);
        return root;
    }


}