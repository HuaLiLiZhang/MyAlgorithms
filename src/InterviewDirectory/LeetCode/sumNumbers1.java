package InterviewDirectory.LeetCode;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by huali on 2018/7/6.
 */
public class sumNumbers1 {
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return root.val;

        int result=0;
        return getnumber(root,result);

    }

    private int getnumber(TreeNode root, int result) {
        if(root==null)
            return  0;
        result =result*10+root.val;
        if(root.left==null&&root.right==null)
            return result;
        return getnumber(root.left,result)+getnumber(root.right,result);
    }

    public static  void main(String[]args)
    {
        TreeNode head = new TreeNode(4);
        TreeNode head1 = new TreeNode(7);
        TreeNode head2 = new TreeNode(9);

        head.left = head1;
        head.right = head2;
        head1.right=null;
        head1.left=null;
        head2.left=null;
        head2.right=null;
        int result = new sumNumbers1().sumNumbers(head);
        System.out.println(result);


    }
}