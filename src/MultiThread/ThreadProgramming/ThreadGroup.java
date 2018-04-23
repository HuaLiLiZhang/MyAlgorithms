package MultiThread.ThreadProgramming;

/**
 * Created by huali on 2018/4/23.
 */
public class ThreadGroup {
    public static void main(String []args)
    {
        //在main线程中添加一个线程组A，然后在这个A组中添加线程对象Z
        //
        java.lang.ThreadGroup maingroup= Thread.currentThread().getThreadGroup();
        // ThreadGroup getThreadGroup()
        //          返回该线程所属的线程组。
        java.lang.ThreadGroup group = new java.lang.ThreadGroup(maingroup, "A");
        //ThreadGroup(ThreadGroup parent, String name)
        //          创建一个新线程组。
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("runMethod");
                    Thread.sleep(10000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        Thread newThread = new Thread(group, runnable);
        //Thread(ThreadGroup group, Runnable target)
        //          分配新的 Thread 对象。
        newThread.setName("Z");
        newThread.start();//线程必须启动才能归到组A中
        java.lang.ThreadGroup[] listgroup = new java.lang.ThreadGroup[Thread.currentThread().
                getThreadGroup().activeGroupCount()];
        // int activeGroupCount()
        //          返回此线程组中活动线程组的估计数。
        Thread.currentThread().getThreadGroup().enumerate(listgroup);
        //int enumerate(ThreadGroup[] list)
        //          把对此线程组中的所有活动子组的引用复制到指定数组中。

        System.out.println("main线程中有多少个子线程组："+listgroup.length+" 名字为："+listgroup[0].getName());
        Thread [] listThread = new Thread[listgroup[0].activeCount()];
        //static int activeCount()
        //          返回当前线程的线程组中活动线程的数目。
        listgroup[0].enumerate(listThread);
        // int enumerate(Thread[] list)
        //          把此线程组及其子组中的所有活动线程复制到指定数组中。
        System.out.println(listThread[0].getName());


    }
}