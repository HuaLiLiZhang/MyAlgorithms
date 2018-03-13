package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/13.
 */
public class CircleList {
    //时间复杂度为O(nm)
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

    //时间复杂度为：O(n)
    public node circlelist(node head ,int num)
    {
        if(head==null|head.next==null||num<1)
        {
            return head;
        }
        node cur = head.next;
        int tmp = 1;
        while (cur!=head)
        {
            tmp++;
            cur=cur.next;  //遍历有多少个节点。
        }
        tmp = getLive(tmp,num);//返回最后剩下的节点。
        while (--tmp!=0)
        {   //找到最后的那个节点。并使得head.next =head; 返回head即为所求。
            head=head.next;
        }
        head.next=head;
        return head;
    }
    public int getLive(int tmp,int num)
    {
        if(tmp==1)
            return 1;
        return (getLive(tmp-1,num)+num-1)%tmp+1;
    }
}