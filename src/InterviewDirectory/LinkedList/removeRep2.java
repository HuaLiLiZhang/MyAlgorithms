package InterviewDirectory.LinkedList;

/**
 * Created by huali on 2018/3/16.
 */
public class removeRep2 {
    public void removerep(node head)
    {
        //时间复杂度为O(n)。空间复杂度为O(1)
        node cur = head;
        node pre = null;
        node next = null;
        while (cur!=null)
        {
            pre = cur;
            next = cur.next;
            while (next!=null)
            {
                if(cur.val==next.val)
                {
                    pre.next = next.next;
                }else
                {
                    pre = next;
                }
                next = next.next;
            }
            cur=cur.next;
        }
    }
}