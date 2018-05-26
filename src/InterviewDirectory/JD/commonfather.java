package InterviewDirectory.JD;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huali on 2018/5/26.
 */
public class commonfather {
//给定一颗二叉树，以及其中的两个node（地址均非空），
// 要求给出这两个node的一个公共父节点，
// 使得这个父节点与两个节点的路径之和最小。描述你程序的最坏时间复杂度

    public static void main(String []args)
    {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(5);
        TreeNode r5 = new TreeNode(6);
        TreeNode r6 = new TreeNode(7);
        root.father =null;
        root.left = r1;
        root.right = r2;
        r1.father=r2.father=root;

        r1.left = r3;
        r1.right = r4;
        r3.father=r4.father=r1;

        r2.left = r5;
        r2.right = r6;
        r5.father=r6.father=r2;
        r3.left = null;
        r3.right = null;
        r4.left = null;
        r4.right = null;
        r5.left = null;
        r5.right = null;
        r6.left = null;
        r6.right = null;
        //TreeNode first = r5;   //指向左子树
        //TreeNode second = r2;   //指向右子树
        TreeNode father = LowestCommonAncestor(r3, r4);
        System.out.println(father.val);
    }

    private static TreeNode LowestCommonAncestor(TreeNode first, TreeNode second) {

        if(first==second)
            return first.father;
        if(first.father == second.father)
            return first.father;
        List<TreeNode> listf = new ArrayList<>();
        List<TreeNode> lists = new ArrayList<>();

        TreeNode node = first;
        while (node.father!=null)
        {
            listf.add(node.father);
            node = node.father;
        }
        node = second;
        while (node.father!=null)
        {
            lists.add(node.father);
            node= node.father;

        }
        for(int i=0;i<listf.size();i++)
        {
            for(int j=0;j<lists.size();j++)
            {
                if(listf.get(i)==lists.get(j))
                    return listf.get(i);
            }
        }
        return null;
    }
}

class TreeNode{
    TreeNode left;   //指向左子树
    TreeNode right;   //指向右子树
    TreeNode father;   //指向父亲节点
    int val;
    TreeNode(int val)
    {
        this.val = val;
    }
}