package InterviewDirectory.LeetCode_after;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huali on 2018/7/9.
 */
public class levelOrderBottomprintList {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return list;
        ArrayList<Integer> arr = new ArrayList<>();
        if(root.right==null&&root.left==null)
        {
            arr.add(root.val);
            list.add(arr);
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        addList(root, queue,arr,list);
        return list;
    }

    private void addList(TreeNode root, Queue<TreeNode> queue,
                         ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> list) {
        queue.add(root);
        Queue<TreeNode> queue2 = new LinkedList<>();
        while (!queue.isEmpty()||!queue2.isEmpty())
        {
            while (!queue.isEmpty())
            {
                TreeNode  node = queue.poll();
                arr.add(node.val);
                if(node.left!=null)
                    queue2.add(node.left);
                if(node.right!=null)
                    queue2.add(node.right);
            }
            list.add(0, arr);
            //
            //list.add("a");
            //list.add("b");
            //list.add("c");
            //list.add(0,"请选择");
            ////此时 list={"请选择" ,a ,b, c} ,且a并不会被顶替 ,只是使用向后移动一位
            arr = new ArrayList<>();
            while (!queue2.isEmpty())
            {
                queue.offer(queue2.poll());
            }
        }

    }
}