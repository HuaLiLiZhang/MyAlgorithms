package InterviewDirectory.LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by huali on 2018/7/5.
 */
public class preorderTraversal {
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root!=null)
        {
            Stack<TreeNode> s1 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty())
            {
                root = s1.pop();
                arr.add(root.val);
                if(root.right!=null)
                    s1.push(root.right);
                if(root.left!=null)
                    s1.push(root.left);
            }
        }
        return arr;
    }
}