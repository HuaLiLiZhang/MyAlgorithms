package offer;

/**
 * Created by huali on 2018/6/23.
 */
public class RandomListNodeClone {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)
            return null;
        RandomListNode pnode ;
        pnode = pHead;
        while (pnode!=null)
        {
            RandomListNode pnew = new RandomListNode(0);
            pnew.label = pnode.label;
            pnew.next = pnode.next;
            pnew.random = null;
            pnode.next = pnew;
            pnode = pnew.next;
        }
        pnode = pHead;
        while (pnode!=null)
        {
            RandomListNode ptemp = pnode.next;
            if(pnode.random!=null)
            {
                ptemp.random = pnode.random.next;

            }
            pnode = ptemp.next;
        }
        pnode = pHead;
        RandomListNode pclonehead = null;
        RandomListNode pclonenode = null;
        if(pnode!=null)
        {
            pclonehead=pclonenode=pnode.next;
            pnode.next = pclonenode.next;
            pnode = pnode.next;
        }


        while (pnode!=null)
        {
            pclonenode.next = pnode.next;
            pclonenode = pclonenode.next;
            pnode.next = pclonenode.next;
            pnode = pnode.next;
        }
        return pclonehead;

    }


}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}