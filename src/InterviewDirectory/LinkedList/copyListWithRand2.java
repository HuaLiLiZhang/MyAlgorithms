package InterviewDirectory.LinkedList;

/**
 * Created by huali on 2018/3/16.
 */
public class copyListWithRand2 {
    //空间复杂度变为O(1)
    public node copyList(node head)
    {
        if(head==null)
            return null;
        node cur = head;
        node next =null;
        //复制并连接每一个结点
        while (cur!=null)
        {
            next = cur.next;
            cur.next = new node(cur.val);
            cur.next.next=next;
            cur=next;
        }
        cur =head;
        node curcopy = null;
        //设置rand指针
        while (cur!=null)
        {
            next = cur.next.next;
            curcopy = cur.next;
            curcopy.rand = cur.rand!=null?cur.rand.next:null;
            cur=cur.next;
        }
        node res = head.next;
        cur = head;
        while (cur!=null)
        {
            next = cur.next.next;
            curcopy = cur.next;
            cur.next=next;
            curcopy.next = next!=null?next.next:null;
            cur =next;
        }
        return res;
    }
}