package InterviewDirectory.LeetCode_after;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by huali on 2018/7/10.
 */
public class zigzagLevelOrderTree {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return list;
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()||!stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                TreeNode node = stack1.pop();
                arr.add(node.val);
                if(node.left!=null)
                    stack2.add(node.left);
                if(node.right!=null)
                    stack2.add(node.right);
            }
            if(!arr.isEmpty())
            {
                list.add(arr);
                arr = new ArrayList<>();
            }
            while (!stack2.isEmpty())
            {
                TreeNode node = stack2.pop();
                arr.add(node.val);
                if(node.right!=null)
                    stack1.add(node.right);
                if(node.left!=null)
                    stack1.add(node.left);
            }
            if(!arr.isEmpty())
            {
                list.add(arr);
                arr = new ArrayList<>();
            }
        }
        return list;
    }
}