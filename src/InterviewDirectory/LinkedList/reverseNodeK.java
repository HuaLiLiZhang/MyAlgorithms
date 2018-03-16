package InterviewDirectory.LinkedList;

/**
 * Created by huali on 2018/3/16.
 */
public class reverseNodeK {
    public node reverseKNode(node head, int k)
    {
        if(k<2)
            return head;

        node cur = head;
        node start = null;
        node pre = null;
        node next = null;

        int count =1;
        while (cur!=null)
        {
            next = cur.next;
            if(count == k)
            {
                start = pre ==null?head:pre.next;  //保存开始结点
                head = pre == null?cur:head;   //head 等于第一次K组的最后一个元素，就是cur
                resign2(pre,start,cur,next);   //调节K个元素的位置。pre 为最左边的结点，start为开始的结点，
                //cur为最后的结点，next为最后节点的下一个节点。
                pre =start;
                count=0;
            }
            count++;
            cur = next;
        }
        return head;
    }
    public void resign2(node left, node start, node end ,node right)
    {
        node pre = start;
        node cur = start.next;
        node next = null;
        while (cur!=right)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(left!=null)
            left.next = end;
        start.next = right;
    }
}