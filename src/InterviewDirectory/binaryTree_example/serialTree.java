package InterviewDirectory.binaryTree_example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huali on 2018/4/12.
 */
public class serialTree {
    public String serialByPre(TreeNode head)
    {
        if(head == null)
            return "#!";
        String res = head.val+"!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);

        return res;
    }

    public TreeNode reconByPreString(String prestr)
    {
        String []values = prestr.split("!");
        Queue<String> queue = new LinkedList<>();
        for(int i =0;i<values.length;i++)
        {
            queue.offer(values[i]);
        }
        return reconpreorder(queue);
    }

    public TreeNode reconpreorder(Queue<String> queue)
    {
        String value = queue.poll();
        if(value.equals('#'))
            return null;
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconpreorder(queue);
        head.right = reconpreorder(queue);
        return head;
    }

}