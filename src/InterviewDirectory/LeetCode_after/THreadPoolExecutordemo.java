package InterviewDirectory.LeetCode_after;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by huali on 2018/7/13.
 */
public class THreadPoolExecutordemo {
    public static void main(String[] args)
    {

        Object ob = new Object();
        AtomicInteger atomicInteger = new AtomicInteger();  //原子类
        atomicInteger.incrementAndGet();
        AtomicBoolean atomicBoolean = new AtomicBoolean();

        try {
            ob.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}