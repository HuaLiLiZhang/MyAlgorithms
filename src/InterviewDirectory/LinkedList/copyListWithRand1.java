package InterviewDirectory.LinkedList;


import java.util.HashMap;

/**
 * Created by huali on 2018/3/16.
 */
public class copyListWithRand1 {
    public node copyList(node head)
    {
        HashMap<node ,node> map = new HashMap<>();
        node cur =head;
        while (cur!=null)
        {
            map.put(cur,new node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur !=null)
        {
            map.get(cur).next=map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
}