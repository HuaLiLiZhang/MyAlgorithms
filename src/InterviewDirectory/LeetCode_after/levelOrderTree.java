package InterviewDirectory.LeetCode_after;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huali on 2018/7/10.
 */
public class levelOrderTree {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            while (size--!=0)
            {
                TreeNode node = queue.poll();
                arr.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            list.add(arr);
            arr = new ArrayList<>();
        }
        return list;
    }
}