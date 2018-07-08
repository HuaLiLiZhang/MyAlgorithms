package MultiThread.ThreadProgramming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huali on 2018/7/8.
 */
public class TimerSchedule {
    private static Timer timer = new Timer(); //只有守护线程，JVM停止工作。true
    static public class  myTask extends TimerTask
    {

        @Override
        public void run() {
            try {
                System.out.println("运行了，时间是："+new Date());
                Thread.sleep(4000);
            //    sleep时间大于delay时间
            //    运行了，时间是：Sun Jul 08 14:15:12 CST 2018
                //结束了，时间是：Sun Jul 08 14:15:16 CST 2018
                //运行了，时间是：Sun Jul 08 14:15:16 CST 2018
                //结束了，时间是：Sun Jul 08 14:15:20 CST 2018
                //运行了，时间是：Sun Jul 08 14:15:20 CST 2018
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束了，时间是："+new Date());
        }
    }
    public static void main(String[] args) throws ParseException {
        myTask myTask = new myTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestring = "2018-7-8 14:12:55";
        Date dateref = sdf.parse(datestring);
        System.out.println("字符串执行时间："+dateref.toString()+"当前时间："+new Date().toLocaleString());
        timer.schedule(myTask,dateref,5000);
        //delay时间大于sleep时间
        //运行了，时间是：Sun Jul 08 14:16:30 CST 2018
        //结束了，时间是：Sun Jul 08 14:16:34 CST 2018
        //运行了，时间是：Sun Jul 08 14:16:35 CST 2018
        //结束了，时间是：Sun Jul 08 14:16:39 CST 2018
        //运行了，时间是：Sun Jul 08 14:16:40 CST 2018
        //结束了，时间是：Sun Jul 08 14:16:44 CST 2018
        System.out.println("a");

    }

}