package MultiThread.ThreadProgramming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huali on 2018/4/22.
 */
public class test {
    private static Timer timer = new Timer();
    public static class MyTash1 extends TimerTask
    {
        @Override
        public void run(){
            System.out.println("mytask1"+new Date());
        }
    }

    static public class mytask2 extends  TimerTask
    {
        @Override
        public void run()
        {
            System.out.println("mytask2"+new Date());
        }
    }

    static public void main(String[]args)
    {
        try {
            MyTash1 task1 = new MyTash1();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataString1= "2018-4-22 21:50:00";
            Date datesft= sdf1.parse(dataString1);
            System.out.println("mian"+datesft.toLocaleString()+"time"+new Date().toLocaleString());
            timer.schedule(task1, datesft, 3000);
        }catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}