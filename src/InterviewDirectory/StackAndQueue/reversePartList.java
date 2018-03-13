package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/13.
 */
public class reversePartList {
    public node reversepart(node head,int from ,int to)
    {
        int len =0;
        node node1 = head;
        node fPre = null;
        node tPos = null;
        while (node1!=null)
        {
            len++;
            fPre = len==from-1?node1:fPre;
            tPos = len==to+1?node1:tPos;
            node1=node1.next;
        }
        if(from>to||from<1||to>len)
        {
            return head;
        }
        node1 = fPre==null?head:fPre.next;
        node node2 = node1.next;
        node1.next=tPos;
        node next =null;
        while (node2!=tPos)
        {
            next=node2.next;
            node2.next=node1;
            node1=node2;
            node2=next;
        }
        if(fPre!=null)
        {
            fPre.next=node1;
            return head;
        }
        return node1;
    }
}