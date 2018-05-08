package InterviewDirectory.netEASe2017;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/8.
 */
public class constructQueue {

    //小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
    //while(!Q.empty())              //队列不空，执行循环
    //
    //{
    //
    //    int x=Q.front();            //取出当前队头的值x
    //
    //    Q.pop();                 //弹出当前队头
    //
    //    Q.push(x);               //把x放入队尾
    //
    //    x = Q.front();              //取出这时候队头的值
    //
    //    printf("%d\n",x);          //输出x
    //
    //    Q.pop();                 //弹出这时候的队头
    //
    //}
    //
    //做取出队头的值操作的时候，并不弹出当前队头。
    //小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行5有错，应该为3，以下已修正]
    //输入描述:
    //第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。
    //
    //
    //输出描述:
    //对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        int num = sr.nextInt();
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        while (count<num)
        {
            int n = sr.nextInt();
            //queue.push(n);
            for(int i=n;i>0;i--)
            {
                queue.offerFirst(i);
                int x = queue.getLast();
                queue.removeLast();
                queue.offerFirst(x);
            }
            while (queue.size()>1)
            {
                System.out.print(queue.pop()+" ");
            }
            System.out.print(queue.pop());
            System.out.println();
            count++;
        }
    }
}