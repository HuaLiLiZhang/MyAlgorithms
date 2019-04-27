package InterviewDirectory.nowcode_middle.stack1;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by huali on 2018/10/11.
 */
public class MaxTreenochongfuarr {
//    一个数组没有重复元素，生成一个maxtree
//    maxtree的特点：1.是一个二叉树，数组的每一个值对应一个二叉树的结点
//    2.包括Maxtree树在内且在其中的每一棵子树上，值最大的结点是树的头。
//    结论是：任何一个数在单独一侧，孩子数量不超过一个。

    //数组必须没有重复元素
    //MaxTree是一棵二叉树，数组的每一个值对应一个二叉树节点
    //包括MaxTree树在内且在其中的每一棵子树上，值最大的节点都是树的头

    //在【生成窗口最大数组】里面，已经掌握了，在O(N)时间复杂度里面，
    // 找到每个元素位置最近的比元素大的元素，同个这个套路，就可以构造一棵MaxTree了。
    public static void main(String[] args)
    {
        int[] arr = {3,4,5,1,2};
        Node head = getMaxTree(arr);
        System.out.println(head.value);
        System.out.println(head.left.value);
        System.out.println(head.right.value);
        System.out.println(head.left.left.value);
        System.out.println(head.right.left.value);
    }

    private static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for(int i = 0;i<arr.length;i++)
        {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        HashMap<Node,Node> lBigMap = new HashMap<>();
        HashMap<Node,Node> rBigMap = new HashMap<>();
        for(int i = 0;i<nArr.length;i++)
        {
            Node curNode = nArr[i];
            while (!stack.isEmpty()&&stack.peek().value<curNode.value)
            {
                //如果stack不为空，且当前节点大于栈顶节点的值
                popStackSetMap(stack,lBigMap);//那么调用方法将栈顶的值设置为它的左边第一个最大值
            }
            stack.push(curNode);//每次都将节点数组向stack中push
        }
        while (!stack.isEmpty())
            popStackSetMap(stack,lBigMap);

        for(int i = nArr.length-1;i>=0;i--)
        {
            Node curNode = nArr[i];
            while (!stack.isEmpty()&&stack.peek().value<curNode.value) {//如果stack不为空，且当前节点x大于栈顶节点的值
                popStackSetMap(stack,rBigMap);//那么调用方法将栈顶的值设置为它的右边第一个最大值
            }
            stack.push(curNode);//每次都将节点数组向stack中push
        }
        while(!stack.isEmpty()) {
            popStackSetMap(stack,rBigMap);
        }

        Node head = null;
        for(int i = 0;i<nArr.length;i++)
        {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if(left==null&&right==null)
            {
                head = curNode;
            }else if (left==null) {
                if (right.left==null) {
                    right.left = curNode;
                }else {
                    right.right = curNode;
                }
            }else if (right==null) {
                if(left.left==null) {
                    left.left = curNode;
                }else {
                    left.right = curNode;
                }
            }else {
                Node parent = left.value < right.value ? left:right;
                if(parent.left == null) {
                    parent.left = curNode;
                }else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    private static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> lBigMap) {
        Node popNode = stack.pop();
        if(stack.isEmpty())
        {
            lBigMap.put(popNode,null);
        }else {
            lBigMap.put(popNode,stack.peek());
        }
    }


}
//节点类
class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }
}