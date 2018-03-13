package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/13.
 */
public class isHuiWenlist {
    public boolean isPalindrome3(node head)
    {
        if(head==null||head.next==null)
            return true;
        node mid = head;
        node behind = head;
        while (behind.next!=null&&behind.next.next!=null)  //查找中间节点
        {
            mid=mid.next;
            behind=behind.next.next;
        }
        behind = mid.next;
        mid.next=null;
        node next = null;
        while (behind!=null)
        {
            next=behind.next;
            behind.next=mid;
            mid=behind;
            behind=next;
        }
        next = mid;//保存一下最后一个节点。
        behind=head;
        boolean res = true;
        while (mid!=null&&behind!=null)
        {
            if(mid.val!=behind.val)
            {
                res =false;
                break;
            }
            mid=mid.next;
            behind=behind.next;
        }
        behind = next.next;
        next.next=null;
        while (mid!=null)
        {
            behind = mid.next;
            mid.next = next;
            next = mid;
            mid = behind;
        }
        return res;
    }
}