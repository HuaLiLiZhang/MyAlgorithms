package InterviewDirectory.toutiao2019_2;

import java.util.concurrent.CountDownLatch;

/**
 * Created by huali on 2018/9/9.
 */
public class workThread extends Thread{
    CountDownLatch cdl;
    int sleepSecond;
    workThread(String name, CountDownLatch cdl, int sleepSecond)
    {
        super(name);
        this.cdl = cdl;
        this.sleepSecond = sleepSecond;
    }
    @Override
    public void run()
    {
        try {
            System.out.println(this.getName()+"启动了，时间为："+System.currentTimeMillis());
            Thread.sleep(sleepSecond*1000);
            cdl.countDown();
            System.out.println(this.getName() + "执行完了，时间为" + System.currentTimeMillis());
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}