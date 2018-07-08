package InterviewDirectory.LeetCode;

/**
 * Created by huali on 2018/7/5.
 */
public class copyRandomList1 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        RandomListNode node = head;
        //先复制结点
        while (node!=null)
        {
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;

            node.next = copy;
            node = copy.next;
        }
        //在将结点的random指针指到相应位置。
        node = head;
        while (node!=null)
        {
            if(node.random!=null)
            {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = head;
        RandomListNode copyhead = head.next;

        while (node!=null)
        {
            RandomListNode copynext = node.next;
            node.next = copynext.next;
            if(copynext.next!=null)
                copynext.next = copynext.next.next;
            node = node.next;
        }

        return copyhead;

    }
}

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
 }