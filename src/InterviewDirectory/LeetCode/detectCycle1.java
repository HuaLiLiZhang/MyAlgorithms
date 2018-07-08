package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/5.
 */
public class detectCycle1 {
    public ListNode detectCycle(ListNode head) {

        if(head==null||head.next==null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                break;
        }
        if(fast==null||fast.next==null)
            return null;
        ListNode temp = head;
        ListNode meetingnode = slow;
        while (meetingnode!=temp)
        {
            temp = temp.next;
            meetingnode=meetingnode.next;
        }
        return meetingnode;

    }

    public static  void main(String[]args) {
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(7);
        ListNode head2 = new ListNode(9);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;
        System.out.println(new detectCycle1().detectCycle(head).val);


    }
    }