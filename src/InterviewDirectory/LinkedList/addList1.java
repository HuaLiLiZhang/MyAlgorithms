package InterviewDirectory.LinkedList;

import java.util.Stack;

/**
 * Created by huali on 2018/3/16.
 */
public class addList1 {
    public node addLists(node head1, node head2)
    {
        Stack<Integer> s1= new Stack<>();
        Stack<Integer> s2 =new Stack<>();
        while (head1!=null)
        {
            s1.push(head1.val);
            head1=head1.next;
        }
        while (head2!=null)
        {
            s2.push(head2.val);
            head2=head2.next;
        }

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;

        node node0 = null;
        node pre = null;
        while (!s1.isEmpty()||s2.isEmpty())
        {
            n1 = s1.isEmpty()?0:s1.pop();
            n2 = s2.isEmpty()?0:s2.pop();
            n = n1+n2+ca;
            pre = node0 ;
            node0 = new node(n%10);
            node0.next=pre;
            ca = n/10;
        }
        if(ca==1)
        {
            pre = node0;  //记住头结点。
            node0 = new node(1);   //产生进位，则在pre前面添加一个节点，node0.next = pre;
            node0.next = pre;
        }
        return node0;

    }
}