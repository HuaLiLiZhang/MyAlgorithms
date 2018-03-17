package InterviewDirectory.binaryTree_example;

/**
 * Created by huali on 2018/3/16.
 */
public class Main {
    public static void main(String[]args)
    {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(5);
        TreeNode r5 = new TreeNode(6);
        TreeNode r6 = new TreeNode(7);
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

        binaryTree_search_no_digui tree = new binaryTree_search_no_digui();
        tree.preorderUnRecur(root);
        tree.inOrderUnRecur(root);
        tree.posOrderUnREcur(root);
        tree.posOrderUnrecur2(root);




    }
}