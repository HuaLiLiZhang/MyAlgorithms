package InterviewDirectory.LeetCode;

import java.util.Stack;

/**
 * Created by huali on 2018/7/4.
 */
public class sortList1 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        s1.push(head);
        ListNode node = head;
        while (node.next!=null)
        {
            node = node.next;
            if(s1.peek().val>=node.val)
                s1.push(node);
            else {
                while (!s1.isEmpty())
                {
                    ListNode peek = s1.pop();
                    if(peek.val<node.val)
                        s2.push(peek);
                    else
                    {
                        s1.push(peek);
                        break;
                    }
                }
                s1.push(node);
                while (!s2.isEmpty())
                {
                    s1.push(s2.pop());
                }
            }
        }
        node = s1.pop();
        ListNode temp = node;
        while (!s1.isEmpty())
        {
            temp.next = s1.pop();
            temp = temp.next;
        }
        temp.next=null;
        return node;
    }

    public static  void main(String[]args)
    {
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(7);
        ListNode head2 = new ListNode(9);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = null;
        head = new sortList1().sortList(head);
        while (head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }


    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }