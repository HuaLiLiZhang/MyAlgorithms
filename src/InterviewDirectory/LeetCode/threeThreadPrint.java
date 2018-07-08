package InterviewDirectory.LeetCode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huali on 2018/7/7.
 */
public class threeThreadPrint {

    public static void main(String[] args){

        Print printABC= new Print();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printC();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printB();
            }
        }).start();



    }

}

class Print {

    private final Lock lock = new ReentrantLock();
    private Condition ThreadA =lock.newCondition();
    private Condition ThreadB =lock.newCondition();
    private Condition ThreadC =lock.newCondition();
    private  int flag=0;

    public  void printA(){
        while (true){
            lock.lock();
            try {
                while(flag !=0)
                    ThreadA.await();
                System.out.print("A");
                flag=1;
                ThreadB.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public  void printB(){
        while (true){
            lock.lock();
            try {
                while (flag !=1)
                    ThreadB.await();
                System.out.print("B");
                flag=2;
                ThreadC.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public  void printC(){
        while (true) {
            lock.lock();
            try {
                while (flag !=2)
                    ThreadC.await();
                System.out.print("C");
                Thread.sleep(1000);
                flag=0;
                ThreadA.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

}


