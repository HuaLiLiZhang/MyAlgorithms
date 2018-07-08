package InterviewDirectory.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huali on 2018/7/7.
 */
public class connectNextRightPoint {
    public void connect(TreeLinkNode root) {
//利用层序遍历思想，需要注意的是对每层的节点都进行处理
        if(root==null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int n = queue.size();
            for(int i=0;i<n;i++)
            {
                TreeLinkNode tmp = queue.poll();
                if(tmp.left!=null)
                    queue.offer(tmp.left);
                if(tmp.right!=null)
                    queue.offer(tmp.right);
                if(i!=n-1)
                    tmp.next = queue.peek();
                else
                    tmp.next = null;
            }
        }
    }

}
class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }