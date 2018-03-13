package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/13.
 */
public class removeMidNode
{
    public node removemidnode(node head)
    {
        if(head==null||head.next==null)
            return head;
        if(head.next.next==null)
            return head.next;
        node pre = head;
        node behin = head.next.next;
        while (pre.next!=null&&behin.next.next!=null)
        {
            pre=pre.next;
            behin=behin.next.next;
        }
        pre.next=behin;
        return head;
    }
}
