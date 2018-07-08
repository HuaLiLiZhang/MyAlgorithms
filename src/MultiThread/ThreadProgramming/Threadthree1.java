package MultiThread.ThreadProgramming;

/**
 * Created by huali on 2018/7/7.
 */
public class Threadthree1 {
    //private  boolean flag = true;
    //public  void runs(){
    //    String s = new String();
    //
    //    while (flag)
    //    {
    //
    //    }
    //    System.out.println("stop");
    //
    //}
    //public  void stop(){
    //    flag = false;
    //
    //}
    public static  void main(String[]args)
    {
        service service = new service();

        B b = new B(service);
        A a = new A(service);
        b.start();
        a.start();
        System.out.println("yijing faqi停止");
    }

}

class B extends Thread
{
    service b;
    B(service b)
    {
        this.b = b;
    }
    @Override
    public void run() {
        super.run();
        b.runMethod();

    }

}
class A extends Thread{
    service b;
    A(service b)
    {
        this.b = b;
    }
    @Override
    public void run() {
        b.stopMethod();
    }
}

