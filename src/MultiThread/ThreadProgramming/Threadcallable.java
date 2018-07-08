package MultiThread.ThreadProgramming;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by huali on 2018/7/8.
 */
public class Threadcallable {
    public static void main(String[] args)
    {
        Callable<Integer> callable = new Callable() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100)+100;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        //可以当做runnable用，也可以作为future获取callable的值
        try {
            Thread.sleep(1000);
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}