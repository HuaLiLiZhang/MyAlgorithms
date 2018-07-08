package MultiThread.ThreadProgramming;

/**
 * Created by huali on 2018/7/7.
 */
public class Threadrun1 {
    public static  void main(String[]args)
    {
        //Mythread1 mythread1 = new Mythread1();
        //mythread1.start();
        //try {
        //    Thread.sleep(1000);
        //}catch (InterruptedException e)
        //{
        //    e.printStackTrace();
        //}
        //System.out.println("main");
        Myrunables1 myrunables1 = new Myrunables1();
        Thread t2 = new Thread(myrunables1);
        t2.start();
        Myrunables1 myrunables2 = new Myrunables1();
        Thread t3 = new Thread(myrunables2);
        t3.start();
        Thread t1 = new Thread(new Mythread1());
        t1.start();
    }
}
class Mythread1 extends Thread
{
    @Override
    public void run() {
        super.run();
        System.out.println("mythread1");
    }

}
class Myrunables1 implements Runnable{

    @Override
    public void run() {
        System.out.println("runnable1"+Thread.currentThread().getName());
    }
}