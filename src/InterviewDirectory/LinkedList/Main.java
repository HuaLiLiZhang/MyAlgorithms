package InterviewDirectory.LinkedList;

/**
 * Created by huali on 2018/3/9.
 */
public class Main {
    public static void main(String[]args)
    {
        node head = new node(5);
        node h1 = new node(2);
        node h2 = new node(4);
        node h3 = new node(0);
        node h4 = new node(1);
        node h5 = new node(6);
        node h6 = null;
        head.next=h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        //node h0 = new reverseNodeK().reverseKNode(head,3);
        //new removeRep1().removerepeatList(head);
        //new removeRep2().removerep(head);
        //while (head!=null)
        //{
        //    System.out.println(head.val);
        //    head=head.next;
        //}
        node hh = new sortLinkedList().sortlist(head);
        while (hh!=null)
        {
            System.out.println(hh.val);
            hh=hh.next;
        }


    }
}