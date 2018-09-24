package InterviewDirectory.toutiao2019_2;

import java.util.concurrent.CountDownLatch;

/**
 * Created by huali on 2018/9/9.
 */
public class countDownLatch {
    public static void main(String[] args) throws Exception
    {
        CountDownLatch cdl = new CountDownLatch(4);//count的个数必须小于等于需要执行countdown()的线程数，
        // 因为没执行一次count才会-1，执行完，才能继续唤醒await()，继续执行等待的线程。
        DoneThread dt0 = new DoneThread("DoneThread1", cdl);
        DoneThread dt1 = new DoneThread("DoneThread2", cdl);
        DoneThread dt2 = new DoneThread("DoneThread3", cdl);
        dt0.start();
        dt1.start();
        dt2.start();
        workThread wt0 = new workThread("WorkThread1", cdl, 2);
        workThread wt1 = new workThread("WorkThread2", cdl, 3);
        workThread wt2 = new workThread("WorkThread3", cdl, 4);
        wt0.start();
        wt1.start();
        wt2.start();
        workThread wt3 = new workThread("WorkThread4", cdl, 5);
        wt3.start();
    }

}