package InterviewDirectory.LinkedList;

/**
 * Created by huali on 2018/3/16.
 */
public class addList2_reverse {
    public node addListReverse(node head1,node head2)
    {
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        node c1 = head1;
        node c2 = head2;
        node node =null;
        node pre = null;
        while (c1!=null||c2!=null)
        {
            n1 = c1==null?0:c1.val;
            n2 = c2==null?0:c2.val;
            n = n1+n2+ca;
            pre = node ;
            node =new node(n%10);
            node.next = pre;
            ca = n/10;
            c1 = c1!=null?c1.next:null;
            c2 = c2!=null?c2.next:null;
        }
        if(ca == 1)
        {
            pre = node ;
            node =new node(1);
            node.next = pre;
        }
        reverseList(head1);
        reverseList(head2);
        return node;

    }

    public node reverseList(node head1)
    {
        node pre = null;
        node next = null;
        while (head1!=null)
        {
            next = head1.next ;
            head1.next = pre ;
            pre = head1;
            head1= next;
        }
        return pre;
    }
}