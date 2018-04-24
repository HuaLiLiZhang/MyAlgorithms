package MultiThread.ThreadProgramming;

/**
 * Created by huali on 2018/4/23.
 */
public class orderThread  extends Thread{
    private Object lock;
    private String showchar;
    private int showNUmPosition;
    private int printCount =0;
    volatile private static int addNumber = 1;
    public orderThread(Object lock, String showchar, int showNUmPosition)
    {
        super();
        this.lock=lock;
        this.showchar = showchar;
        this.showNUmPosition= showNUmPosition;
    }

    @Override
    public void run()
    {
        try {
            synchronized (lock)
            {
                while (true)
                {
                    if(addNumber%3==showNUmPosition)
                    {
                        System.out.println("threadname : "+
                                Thread.currentThread().getName()+
                                " runcount : "+addNumber+ " "+showchar);
                        lock.notifyAll();
                        addNumber++;
                        printCount++;
                        System.out.println("threadname : "+
                                Thread.currentThread().getName()+" printcount: "+printCount);
                        if(printCount==3)
                            break;
                    }else {
                        lock.wait();
                    }
                }
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[]args)
    {
        Object lock = new Object();
        orderThread a = new orderThread(lock, "A", 1);
        orderThread b = new orderThread(lock, "B", 2);
        orderThread c = new orderThread(lock, "C", 0);
        a.start();
        b.start();
        c.start();
    }

}