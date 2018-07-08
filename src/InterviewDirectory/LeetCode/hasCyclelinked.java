package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/5.
 */
public class hasCyclelinked {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                break;
        }
        if(fast==null||fast.next==null)
            return false;
        return true;
    }
}