package InterviewDirectory.LinkedList;

import java.util.HashSet;

/**
 * Created by huali on 2018/3/16.
 */
public class removeRep1 {
    public void removerepeatList(node head)
    {
        if(head ==null)
            return ;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);
        node pre = head;
        node cur = head.next;
        while (cur!=null)
        {

            if(set.contains(cur.val))
            {
                pre.next = cur.next;
            }
            else
            {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
    }
}