package MultiThread.ThreadProgramming;

/**
 * Created by huali on 2018/4/20.
 */
public class service {
    private boolean isContinueRun = true;
    //public void runMethod()
    //{
    //    while (isContinueRun==true)  //此方法陷入死循环，没有同步，iscontinueRun改变看不到，不可见
    //    {}
    //    System.out.println("停下来啦");
    //}

    //public void runMethod()
    //{
    //    String anything = new String();
    //    while (isContinueRun==true)
    //    {
    //        synchronized (anything){  //service.class
    //            //synchronized关键字保证了在同一时刻，只有一个线程可以执行某一个方法或某一个代码块。
    //            //他包含两个特征：互斥性和可见性。同步synchronized不仅可以解决一个线程看到对象不一致的状态,
    //        //    还可以保证进入同步方法或者同步代码块的每一个线程，都看到由同一个锁保护之前所有的修改效果。
    //           //已经发起停止命令了！
    //           //停下来啦
    //        }
    //    }
    //    System.out.println("停下来啦");
    //}

    public void runMethod()
    {
        Object obj = new Object();
        while (isContinueRun==true)
        //此时也不行，陷入死循环。isContinueRun必须在同步代码块之前，
        // 它才可以看到isContinueRun改变的状态
        {
            synchronized (obj)
            {}
        }
        System.out.println("停下来啦");
    }


    public void stopMethod()
    {
        isContinueRun = false;
    }
}