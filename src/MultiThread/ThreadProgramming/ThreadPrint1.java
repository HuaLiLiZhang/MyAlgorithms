package MultiThread.ThreadProgramming;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huali on 2018/7/8.
 */
public class ThreadPrint1 {
    private final Lock lock = new ReentrantLock();
    private Condition printA = lock.newCondition();
    private Condition printB = lock.newCondition();
    private Condition printC = lock.newCondition();
    private int flag =0;

    public void setPrintA() {
        lock.lock();
        try {
            while (true) {
                while (flag!=0)
                    printA.await();
                System.out.print("A");
                flag =1;
                printB.signal();
        }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void setPrintB() {
        lock.lock();
        try {
            while (true) {
                while (flag!=1)
                    printB.await();
                System.out.print("B");
                flag =2;
                printC.signal();
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void setPrintC() {
        lock.lock();
        try {
            while (true) {
                while (flag!=2)
                    printC.await();
                System.out.print("C");
                Thread.sleep(1000);
                flag =0;
                printA.signal();
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args){

        ThreadPrint1 printABC= new ThreadPrint1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.setPrintA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.setPrintB();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.setPrintC();
            }
        }).start();



    }
}