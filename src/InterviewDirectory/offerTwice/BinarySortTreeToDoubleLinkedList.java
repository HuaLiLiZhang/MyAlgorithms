package InterviewDirectory.offerTwice;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by huali on 2018/9/2.
 */
public class BinarySortTreeToDoubleLinkedList {
    public static void main(String[] args)
    {
       TreeNode root = new TreeNode(10);
       TreeNode r1 = new TreeNode(9);
       TreeNode r2 = new TreeNode(12);
       root.left = r1;
       root.right = r2;
       r1.left=r1.right=null;
       r2.left=r2.right = null;
       //.....
       //TreeNode LinkedList = ConvertBSTToBiList(root);
       // TreeNode LinkedList = Conver(root);
       // System.out.println(LinkedList.value);
        Convert(root);
        while (realHead!=null){
            System.out.println(realHead.value);
            realHead = realHead.right;
        }
    }

    //第一种，非递归的方法：
    //解题思路：
    //1.核心是中序遍历的非递归算法。
    //2.修改当前遍历节点与前一遍历节点的指针指向。
    private static TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;  //用于存储当前结点
        TreeNode pre = null;  //用于保存中序遍历序列的上一节点。指向双向结点。
        boolean isFirst = true;
        while (p!=null||!stack.isEmpty())
        {
            while (p!=null)
            {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst)
            {
                root = p;
                pre = root;
                isFirst = false;
            }
            else {
                pre.right = p;
                p.left = pre;
                pre  = p;
            }
            p = p.right;
        }
        return root;

    }


//    递归版
//解题思路：
//1.将左子树构造成双链表，并返回链表头节点。
//2.定位至左子树双链表最后一个节点。
//3.如果左子树链表不为空的话，将当前root追加到左子树链表。
//4.将右子树构造成双链表，并返回链表头节点。
//5.如果右子树链表不为空的话，将该链表追加到root节点之后。
//6.根据左子树链表是否为空确定返回的节点。

    public static TreeNode Conver(TreeNode root)
    {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Conver(root.left);
        TreeNode p = left;
    //    2定位至左子树双链表的最后一个结点，
        while (p!=null&&p.right!=null)
        {
            p = p.right;
        }
        //3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null)
        {
            p.right = root;
            root.left = p;
        }
        TreeNode right = Conver(root.right);
    //    4.将右子树够着成链表，并返回链表头结点。
        if(right!=null)
        {
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;

    }

//    方法三：改进递归版
//解题思路：
//思路与方法二中的递归版一致，仅对第2点中的定位作了修改，新增一个全局变量记录左子树的最后一个节点。

    static TreeNode  head = null;
    static TreeNode  realHead = null;
    public static void Convert(TreeNode prootofTree)
    {
        if(prootofTree==null)
            return ;
        Convert(prootofTree.left);
        if(head ==null)
        {
            head = prootofTree;
            realHead = prootofTree;
        }
        else {
            head.right = prootofTree;
            prootofTree.left = head;
            head = prootofTree;
        }
        Convert(prootofTree.right);

    }



}