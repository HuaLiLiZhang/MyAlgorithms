package InterviewDirectory.binaryTree_example;

/**
 * Created by huali on 2018/8/16.
 */
public class MirrorRecursively {
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(8)  ;
        TreeNode r1 = new TreeNode(6)  ;
        TreeNode r2 = new TreeNode(10)  ;
        TreeNode r3 = new TreeNode(5)  ;
        TreeNode r4 = new TreeNode(7)  ;
        TreeNode r5 = new TreeNode(9)  ;
        TreeNode r6 = new TreeNode(11)  ;
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = r5;
        r2.right = r6;
        r3.left = null;
        r3.right = null;
        r4.left = null;
        r4.right = null;
        r5.left = null;
        r5.right = null;
        r6.left = null;
        r6.right = null;
        //TreeNode head = mirrortree(root);
        print(root);
        mirrortree1(root);
        System.out.println();
        print(root);
    }

    private static void print(TreeNode head) {
        if(head==null)
            return ;
        System.out.print(head.val+" ");
        print(head.left);
        print(head.right);
    }

    private static TreeNode mirrortree(TreeNode root) {
        //这个是复制一个镜像树。
        if(root == null)
            return null;
        TreeNode head = new TreeNode(root.val);
        head.right = mirrortree(root.left);
        head.left = mirrortree(root.right);
        return head;
    }

    private static void mirrortree1(TreeNode root) {

        //    直接改变原来的树结构
        if(root ==null)
            return ;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrortree(root.left);
        mirrortree(root.right);
    }
}