package MultiThread.ThreadProgramming;

import java.lang.ThreadGroup;

/**
 * Created by huali on 2018/4/23.
 */
public class ThreadGroupGroup {
    public static void main(String []args) {
        //在main线程中添加一个线程组A，然后在这个A组中添加线程对象Z
        //
        ThreadGroup maingroup = Thread.currentThread().getThreadGroup();
        // ThreadGroup getThreadGroup()
        //          返回该线程所属的线程组。
        ThreadGroup groupa = new ThreadGroup(maingroup, "A");
        //ThreadGroup(ThreadGroup parent, String name)
        //          创建一个新线程组。
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("runMethod1");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadGroup groupb = new ThreadGroup(groupa, "B");
        ThreadGroup [] listgroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        //传入true是递归取得子组以及子孙组。
        Thread.currentThread().getThreadGroup().enumerate(listgroup, true);
        //public int enumerate(ThreadGroup[] list,
        //                     boolean recurse)把对此线程组中的所有活动子组的引用复制到指定数组中。
        // 如果 recurse 标志为 true，则还包括对子组的所有活动子组的引用，等等。

        for(int i =0;i<listgroup.length;i++)
        {
            if(listgroup[i]!=null)
                System.out.println(listgroup[i].getName());
        }
        ThreadGroup [] listgroup2 = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(listgroup2, false);
        for(int i =0;i<listgroup2.length;i++)
        {
            if(listgroup2[i]!=null)
                System.out.println(listgroup2[i].getName());
        }
        //输出结果：
        //A
        //B
        //A

    }
}