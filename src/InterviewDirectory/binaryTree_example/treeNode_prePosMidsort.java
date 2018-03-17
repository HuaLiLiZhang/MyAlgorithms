package InterviewDirectory.binaryTree_example;

/**
 * Created by huali on 2018/3/16.
 */
public class treeNode_prePosMidsort {
    public void preOrderRecur(TreeNode root)   //前序遍历  递归
    {
        if(root==null)
            return ;
        System.out.print(root.val+" ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public void InorderRecur(TreeNode root)
    {
        if(root==null)
            return ;
        InorderRecur(root.left);
        System.out.print(root.val+" ");
        InorderRecur(root.right);
    }

    public void posOrderRecur(TreeNode root)
    {
        if(root==null)
            return ;
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.val+" ");
    }

}