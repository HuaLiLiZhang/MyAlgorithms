package MultiThread.ThreadProgramming;

/**
 * Created by huali on 2018/4/20.
 */
public class ThreadB extends Thread{
    private service service;
    public ThreadB(service service)
    {
        super();
        this.service=service;
    }
    @Override
    public void run(){
        service.stopMethod();
    }
}