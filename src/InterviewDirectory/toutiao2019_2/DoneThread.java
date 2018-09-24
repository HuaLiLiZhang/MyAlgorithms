package InterviewDirectory.toutiao2019_2;

import java.util.concurrent.CountDownLatch;

/**
 * Created by huali on 2018/9/9.
 */
public class DoneThread extends Thread{
    private CountDownLatch cdl;

    public DoneThread(String name, CountDownLatch cdl)
    {
        super(name);
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.getName()+"要等待了，时间为："+System.currentTimeMillis());
            cdl.await();
            System.out.println(this.getName()+"等待完了，时间为："+System.currentTimeMillis());
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}