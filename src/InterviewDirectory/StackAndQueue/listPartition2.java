package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/14.
 */
public class listPartition2 {
    public static node listPartition(node head,int pivot)
    {
        node sH = null;//小的头
        node sT = null;//小的尾
        node eH = null;//相等的头
        node eT = null;//相等的尾
        node bH = null;//大的头
        node bT = null;//大的尾
        node next =null;//保存下一个节点。
        //所有节点分进三个链表中。
        while (head!=null)
        {
            next=head.next;
            head.next = null;
            if(head.val<pivot)
            {
                if(sH==null)
                {
                    sH = head;
                    sT=head;
                }else {
                    sT.next=head;
                    sT=head;
                }
            }else if(head.val==pivot){
                if(eH==null)
                {
                    eH=head;
                    eT=head;
                }
                else {
                    eT.next=head;
                    eT=head;
                }
            }else {
                if(bH==null)
                {
                    bH=head;
                    bT=head;
                }else {
                    bT.next=head;
                    bT=head;
                }
            }
            head=next;
        }
        if(sT!=null)
        {
            sT.next=eH;
            eT=eT==null?sT:eT;
        }
        //所有重新连接
        if(eT!=null)
        {
            eT.next=bH;
        }
        return sH!=null?sH:eH!=null?eH:bH;
    }
}