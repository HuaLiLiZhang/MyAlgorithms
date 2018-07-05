package InterviewDirectory.LeetCode;


/**
 * Created by huali on 2018/7/4.
 */
public class sortList2 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode node = head;
        int length =0;
        while (node!=null)
        {
            node = node.next;
            length++;
        }
        ListNode[] arr = new ListNode[length];
        arr[0]=node =head;
        for(int i=1;i<length;i++)
        {
            node=node.next;
            arr[i] = node;
        }

        quicksort1(arr,0, length-1);
        head = node = arr[0];
        for(int i=1;i<length;i++)
        {
            node.next = arr[i];
            node = node.next;
        }
        node.next=null;
        return head;
    }

    private void quicksort1(ListNode[] arr, int start, int end) {
        if(start<end)
        {
            int index = partition(arr, start, end);
            quicksort1(arr, start, index-1);
            quicksort1(arr, index+1, end);
        }
    }


    private int partition(ListNode[] arr, int start, int end) {
        ListNode temp = arr[start];
        while (start<end)
        {
            while (start<end&&arr[end].val>temp.val)
            {
                end--;
            }
            if(start<end)
            {
                arr[start] = arr[end];
                start++;
            }
            while (start<end&&arr[start].val<temp.val)
                start++;
            if(start<end)
            {
                arr[end] = arr[start];
                end--;
            }
        }
        arr[start] = temp;
        return start;
    }

    public static  void main(String[]args)
    {
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(7);
        ListNode head2 = new ListNode(9);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = null;
        head = new sortList2().sortList(head);
        while (head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }


    }
}