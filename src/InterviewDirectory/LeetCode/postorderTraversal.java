package InterviewDirectory.LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by huali on 2018/7/5.
 */
public class postorderTraversal {
    public ArrayList<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root!=null)
        {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty())
            {
                root = s1.pop();
                s2.push(root);
                if(root.left!=null)
                    s1.push(root.left);
                if(root.right!=null)
                    s1.push(root.right);
            }

            while (!s2.isEmpty())
            {
                //System.out.print(stack2.pop().val+" ");
                arr.add(s2.pop().val);

            }
        }
        return arr;

    }
}