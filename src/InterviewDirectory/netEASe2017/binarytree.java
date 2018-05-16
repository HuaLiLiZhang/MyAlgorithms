package InterviewDirectory.netEASe2017;

/**
 * Created by huali on 2018/5/15.
 */
public class binarytree {
//    有一棵二叉树，树上每个点标有权值，权值各不相同，
// 请设计一个算法算出权值最大的叶节点到权值最小的叶节点的距离。
// 二叉树每条边的距离为1，一个节点经过多少条边到达另一个节点为这两个节点之间的距离。
//

    private static TreeNode maxNode = new TreeNode(Integer.MIN_VALUE);

    private static TreeNode minNode = new TreeNode(Integer.MAX_VALUE);

    public static void main(String []args)
    {
        TreeNode root = new TreeNode(2);
        TreeNode r1 = new TreeNode(4);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(9);
        TreeNode r4 = new TreeNode(6);
        TreeNode r5 = new TreeNode(1);
        TreeNode r6 = new TreeNode(3);
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
        System.out.println(getDis(root));
    }
    public static int getDis(TreeNode root) {
        // write code here
        getMaxMIn(root);  //找到最大最小叶子节点
        TreeNode lcanode = getLCA(root);    //找LCA
        int a = getNodeDis(lcanode, maxNode);  //最大值叶子节点到LCA的距离
        int b = getNodeDis(lcanode, minNode);  //最小值叶子节点到LCA的距离
        return a+b;

    }

    // LCA最近公共祖先
    private static TreeNode getLCA(TreeNode root) {
        if(root==null)  // 说明是空树
            return null;
        if(root.val==maxNode.val||root.val==minNode.val)
            return root;
        TreeNode leftnode = getLCA(root.left);
        TreeNode rightnode = getLCA(root.right);
        if(leftnode==null)
            return rightnode;
        else if(rightnode==null)
            return leftnode;
        else
            return root;

    }
    // 先找到最大最小叶子节点
    private static void getMaxMIn(TreeNode root) {
        if(root==null)
            return ;
        if(root.left==null&&root.right==null)
        {
            if(root.val>maxNode.val)
                maxNode = root;
            else if(root.val<minNode.val)
                minNode = root;
        }
        getMaxMIn(root.left);
        getMaxMIn(root.right);
    }
    //获取叶子节点到LCA距离
    private static int getNodeDis(TreeNode lcanode, TreeNode node) {
        if(lcanode==null)
            return -1;
        if(lcanode.val ==node.val)
            return 0;
//三种情况：两个均在左子树；两个均在右子树；一左一右，所以不能用if-elseif结构

        int distance = getNodeDis(lcanode.left, node);//左子树未找到两个节点之一
        if(distance ==-1)
            distance=getNodeDis(lcanode.right, node);
        if(distance!=-1)
            return distance;
        return -1;
    }
    
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}