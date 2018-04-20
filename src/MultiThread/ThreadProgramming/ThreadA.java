package MultiThread.ThreadProgramming;

/**
 * Created by huali on 2018/4/20.
 */
public class ThreadA extends Thread{
    private service service;
    public ThreadA(service service)
    {
        super();
        this.service = service;
    }
    @Override
    public void run()
    {
        service.runMethod();
    }
}