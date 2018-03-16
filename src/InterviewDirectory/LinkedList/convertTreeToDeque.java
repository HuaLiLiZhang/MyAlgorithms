package InterviewDirectory.LinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huali on 2018/3/16.
 */
public class convertTreeToDeque {
    public node vonvert(node head)
    {
        Queue<node> queue = new LinkedList<>();
        inorderToQueue(head,queue);
        if(queue.isEmpty())
            return head;
        head = queue.poll();
        node pre = head;
        pre.left =null;
        node cur = null;
        while (!queue.isEmpty())
        {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        cur.right = null;
        return head;
    }
    public void inorderToQueue(node head, Queue<node> queue)
    {
        if(head==null)
            return ;
        inorderToQueue(head.left,queue);
        queue.offer(head);
        inorderToQueue(head.right,queue);
    }
}