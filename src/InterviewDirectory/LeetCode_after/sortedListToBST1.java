package InterviewDirectory.LeetCode_after;


/**
 * Created by huali on 2018/7/9.
 */
public class sortedListToBST1 {
    //称为平衡二叉树。
    public TreeNode sortedListToBST(ListNode head) {

        return BST(head, null);
    }

    public TreeNode BST(ListNode head, ListNode tail)
    {
        if(head==tail)
            return null;
        ListNode mid = head;
        ListNode end = head;
        while (end!=tail&&end.next!=tail)
        {
            mid = mid.next;
            end = end.next.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = BST(head,mid);
        root.right = BST(mid.next, tail);
        return root;
    }

    public static void main(String[] args)
    {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(6);
        ListNode h5 = new ListNode(7);
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        h4.next=h5;
        h5.next=null;
        sortedListToBST1 so = new sortedListToBST1();
        TreeNode root = so.sortedListToBST(h1);
        System.out.print(root.val);
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; next = null; }
 }