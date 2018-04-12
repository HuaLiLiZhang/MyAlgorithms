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


    //层序遍历的序列化和反序列化
    public String serialBylevel(TreeNode head) {
        if (head == null)
            return "#!";
        String res = head.val + "!";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty())
        {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.val + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.val + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    //反序列化
    public TreeNode reconBylevelString(String levelStr)
    {
        String [] values = levelStr.split("!");
        int index = 0;
        TreeNode head = generateNodeByString(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();  //队列先进先出，
        if(head!=null)
            queue.offer(head);
        TreeNode node = null;
        while (!queue.isEmpty())
        {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if(node.left!=null)
            {
                queue.offer(node.left);
                //left先进来，left先出去，在遍历left的子节点。
            }
            if(node.right!=null)
            {
                queue.offer(node.right);
            }
        }
        return head;
    }
    public TreeNode generateNodeByString(String value)
    {
        if(value.equals("#"))
            return null;
        return new TreeNode(Integer.valueOf(value));

    }
}
