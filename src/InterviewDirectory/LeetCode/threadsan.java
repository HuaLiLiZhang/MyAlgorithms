package InterviewDirectory.LeetCode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huali on 2018/7/7.
 */
public class threadsan {
    public static void main(String [] args)
    {
        PrintABC printABC = new PrintABC();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printB();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printC();
            }
        }).start();
    }
}

class PrintABC{
    private final Lock lock = new ReentrantLock();
    private Condition lockA = lock.newCondition();
    private Condition lockB = lock.newCondition();
    private Condition lockC = lock.newCondition();
    int flag = 0;

    public void printA()
    {
        lock.lock();
        try {
            while (true)
            {
                while (flag!=0)
                    lockA.await();
                System.out.print("A");
                flag =1;
                lockB.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB()
    {
        lock.lock();
        try {
            while (true)
            {
                while (flag!=1)
                    lockB.await();
                System.out.print("B");
                flag =2;
                lockC.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printC()
    {
        lock.lock();
        try {
            while (true)
            {
                while (flag!=2)
                    lockC.await();
                System.out.print("C");
                Thread.sleep(1000);
                flag =0;
                lockA.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
