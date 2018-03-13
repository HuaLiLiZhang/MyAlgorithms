package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/13.
 */
public class reverseList {
    public node reverselist(node head)
    {
        node pre = null;
        node next = head;
        while (head!=null)
        {
            next = head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public node reversetwoDirecList(node head)
    {
        node pre = null;
        node next =null;
        while (head!=null)
        {
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }
}