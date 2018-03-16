package InterviewDirectory.LinkedList;

/**
 * Created by huali on 2018/3/16.
 */
public class sortLinkedList {
    public node sortlist(node head)
    {
        node pre = head;
        node next = null;
        node cur = head;
        while (pre!=null)
        {
            int min = pre.val;
            cur = pre.next;
            while (cur!=null)
            {
                if(min>cur.val)
                {
                    min = cur.val;
                    next = cur;
                }
                cur = cur.next;
            }
            if(pre.val!=min)
            {
                next.val = pre.val;
                pre.val = min;
            }
            pre = pre.next;
        }
        return head;
    }
}