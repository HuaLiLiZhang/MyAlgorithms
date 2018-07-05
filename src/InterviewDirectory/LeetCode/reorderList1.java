package InterviewDirectory.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by huali on 2018/7/5.
 */
public class reorderList1 {
    public void reorderList(ListNode head) {

        if(head==null||head.next==null)
            return ;
        //先找到中间的链表位置。
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        //fanzhaunglianbiao反转链表
        ListNode after = slow.next;
        slow.next=null;
        ListNode pre = null;
        while (after!=null)
        {
            ListNode temp = after.next;
            after.next = pre;
            pre = after;
            after = temp;
        }
    //    合并两个链表
        ListNode first = head;
        after = pre;
        while (first!=null&&after!=null)
        {
            ListNode ftemp = first.next;
            ListNode aftemp = after.next;
            first.next = after;
            first = ftemp;
            after.next = first;
            after = aftemp;
        }

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
        new reorderList1().reorderList(head);
        while (head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }




     /*  String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

// 以前的循环方式
//        for (String player : players) {
//            System.out.print(player + "; ");
//        }

// 使用 lambda 表达式以及函数操作(functional operation)
//        players.forEach((player) -> System.out.print(player + "; "));
//
//        System.out.println();
//// 在 Java 8 中使用双冒号操作符(double colon operator)
//        players.forEach(System.out::println);




       //1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();

// 1.2使用 lambda expression，里面写调用打印() -> System.out.println("Hello world !")，
//        然后在调用start() 开启线程。
        new Thread(() -> System.out.println("Hello world !")).start();

// 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

// 2.2使用 lambda expression
        Runnable race2 = () -> System.out.println("Hello world !");

// 直接调用 run 方法(没开新线程哦!)
        race1.run();  //race1是直接用线程开启，打印hello，world
        race2.run();   //race2是一个函数，打印hello，world的函数
        new Thread(race1).start();

        // 1.1 使用匿名内部类根据 name 排序 players
        //Arrays.sort(atp, new Comparator<String>() {
        //    @Override
        //    public int compare(String o1, String o2) {
        //        return 0;
        //    }
        //});
        // 1.3 或者这样,怀疑原作者是不是想错了,括号好多...
        Arrays.sort(atp, (String s1, String s2) ->
                ( (s1.substring(s1.indexOf(" "))).compareTo( s2.substring(s2.indexOf(" ")) ) ));
        players.forEach(System.out::println);

        Arrays.sort(atp, (String s1, String s2) ->
                ( (s1.substring(s1.length()-1)).compareTo( s2.substring(s2.length()-1) ) ));
        players.forEach(System.out::println);


        List list = new ArrayList<>();
        list.add(1);
        list.add("a");
        list.add(1);
        list.add("a");
        list.add(1);
        list.add("a");
        List<?> l1 = new ArrayList<>();
        l1.add(null);//只能插入null值。
        System.out.println(box.fun(list));*/

    }
}

class box <T>{
    box(){}
    public T compare (T a, T b)
    {
        return a.equals(b)?a:b;
    }
    public static String fun(List<?> list)
    {
        String s = "";
        for(int i=0;i<list.size();i++)
        {
            s+=list.get(i);  //只能获取值，不能添加值。
        }
        return s;
    }
}

