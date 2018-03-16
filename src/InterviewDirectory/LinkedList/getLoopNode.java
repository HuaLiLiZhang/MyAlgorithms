package InterviewDirectory.LinkedList;

/**
 * Created by huali on 2018/3/16.
 */
public class getLoopNode {
    public node getloopnode(node head) //判断是否有环
    {
        if(head==null||head.next==null||head.next.next==null)
        {
            return null;
        }
        node fast =head.next.next;
        node slow =head.next;
        while (fast!=slow)
        {
            if(fast.next.next==null||slow.next==null)
            {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while (fast!=slow)
        {
            fast =fast.next;
            slow =slow.next;
        }
        return fast;
    }

    public node noloop(node head1,node head2)
    {
        if(head1==null||head2==null)
            return null;
        node cur1 = head1;
        node cur2 = head2;
        int n = 0;
        while (cur1.next!=null)
        {
            n++;
            cur1=cur1.next;
        }
        while (cur2.next!=null)
        {
            n--;
            cur2=cur2.next;
        }
        if(cur1!=cur2)  //判断最后一个节点是不是相等，不相等则不相交。
            return null;

        cur1 = n>0?head1:head2;  //链表相交，判断在那个节点相交，cur1记录最长的那个链表。
        cur2 = cur1==head1?head2:head1;
        n = Math.abs(n);
        while (n!=0)
        {
            n--;
            cur1=cur1.next;
        }
        while (cur1!=cur2)
        {
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }


    public node bothloop(node head1,node loop1,node head2,node loop2)
    {
        node cur1 = null;
        node cur2 = null;
        if(loop1==loop2)
        {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1!=loop1)
            {
                n++;
                cur1= cur1.next;
            }
            while (cur2!=loop2)
            {
                n--;
                cur2=cur2.next;
            }
            cur1 = n>0? head1:head2;
            cur2 = cur1==head1?head2:head1;
            n = Math.abs(n);
            while (n!=0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1!=cur2)
            {
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;

        }else
            {
                cur1 = loop1.next;
                while (cur1!=loop1)
                {
                    if(cur1==loop2)
                        return loop1;
                    cur1 = cur1.next;
                }
                return null;
            }
    }

    public node getIntersectNode(node head1,node head2)
    {
        if(head1==null||head2==null)
            return null;
        node loop1 = getloopnode(head1);
        node loop2 = getloopnode(head2);
        if(loop1==null&&loop2==null)
            return noloop(head1,head2);
        if(loop1!=null&&loop2!=null)
        {
            return bothloop(head1,loop1,head2,loop2);
        }
        return null;
    }
}