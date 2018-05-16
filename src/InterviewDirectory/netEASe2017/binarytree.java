package InterviewDirectory.netEASe2017;

import java.util.*;
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

    private  int  max = 0;
    private  int min = 99999;
    private  StringBuilder maxcodec;
    private  StringBuilder mincodec;

    public static void main(String []args)
    {
        TreeNode root = new TreeNode(2);
        TreeNode r1 = new TreeNode(4);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(6);
        TreeNode r5 = new TreeNode(1);
        TreeNode r6 = new TreeNode(3);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = null;
        r2.right = null;
        r3.left = null;
        r3.right = null;
        r4.left = null;
        r4.right = null;
        r5.left = null;
        r5.right = null;
        r6.left = null;
        r6.right = null;
        System.out.println(new binarytree().getDis(root));
    }
    //典型的二进制编码题，算出叶子节点二进制编码，再比编码，计算后缀长度和
    public  int getDis(TreeNode root) {
        preorder(root, '0', new StringBuilder());
        int index = 0;
        for(index =0;index<(maxcodec.length()>mincodec.length()?maxcodec.length():mincodec.length());index++)
        {
            if(maxcodec.charAt(index)!=mincodec.charAt(index))
                break;

        }
       return (maxcodec.substring(index).length()+mincodec.substring(index).length()) ;
    }

    private  void preorder(TreeNode root, char code, StringBuilder codec) {
        if(root!=null)
        {
            codec.append(code);
            if(root.left==null&&root.right==null)  //因为计算的是叶子结点的最大值和最小值之间的距离。
            //    所以要使得结点的左右结点都为空时，才是叶子结点。然后计算最大值并记载。
            {
                if(max<root.val)
                {
                    max = root.val;
                    maxcodec = codec;
                }
                if(min>root.val)
                {
                    min = root.val;
                    mincodec = codec;
                }

            }
            preorder(root.left,'0',new StringBuilder(codec));
            preorder(root.right, '1', new StringBuilder(codec));


        }


    }


    public static int getDis1(TreeNode root) {
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