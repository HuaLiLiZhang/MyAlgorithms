package MultiThread.ThreadProgramming;

/**
 * Created by huali on 2018/4/20.
 */
public class Run {
    public static void main(String[]args)
    {
        try {
            service service = new service();
            ThreadA a = new ThreadA(service);
            a.start();
            Thread.sleep(1000); //此时出现死循环。各线程之间的数据值没有可视性造成的。
            // 而synchronized关键字可以具有可视性
            ThreadB b = new ThreadB(service);
            b.start();
            System.out.println("已经发起停止命令了！");
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}