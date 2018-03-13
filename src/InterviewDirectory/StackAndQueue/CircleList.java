package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/13.
 */
public class CircleList {
    public node josephusKilll(node head,int m)
    {
        if(head==null||head.next==head||m<1)
            return head;
        node last = head;
        while (last.next!=head)
        {
            last=last.next;  //找到head的前一个节点。
        }
        int count = 0;
        while (head!=last)
        {
            if(++count==m)
            {
                last.next=head.next;
                count=0;
            }else
            {
                last =last.next;
            }
            head=last.next;
        }
        return head;
    }
}