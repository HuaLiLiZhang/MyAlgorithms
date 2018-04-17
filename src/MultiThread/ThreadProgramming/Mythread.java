package MultiThread.ThreadProgramming;

/**
 * Created by huali on 2018/4/16.
 */
public class Mythread extends Thread{
    private int count =5;
    @Override
    synchronized public void run()  //解决多线程安全问题，只有在一个线程调用结束后，其他线程才能够进入
    {   //次区域称为：互斥区或者临界区
        super.run();
        //count--;
        System.out.println(this.currentThread().getName()+"...."+(count--));
        //System.out.println(this.toString());
        //System.out.println(this.isAlive());
    }

    public static void main(String []argz)
    {
        System.out.println(System.currentTimeMillis());
        Mythread mythread = new Mythread();   //非线程安全。
        Thread t1 = new Thread(mythread, "A");
        Thread t2 = new Thread(mythread, "B");
        Thread t3 = new Thread(mythread, "C");
        Thread t4 = new Thread(mythread, "D");
        Thread t5 = new Thread(mythread, "E");
        Thread t6 = new Thread(mythread, "F");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        System.out.println(System.currentTimeMillis());

    }
}