package InterviewDirectory.netEASe2017;

import java.io.*;
import java.util.Random;

/**
 * Created by huali on 2018/5/11.
 */
public class multiThreadPrint {
    private static final String path = "E:\\JavaBook\\MyprojectTouTiao\\MyAlgorithms\\fileprint\\";
//一个文件中有10000个数，
// 用Java实现一个多线程程序将这个10000个数输出到5个不用文件中（不要求输出到每个文件中的数量相同）。
// 要求启动10个线程，两两一组，分为5组。
// 每组两个线程分别将文件中的奇数和偶数输出到该组对应的一个文件中，
// 需要偶数线程每打印10个偶数以后，就将奇数线程打印10个奇数，如此交替进行。
// 同时需要记录输出进度，每完成1000个数就在控制台中打印当前完成数量，
// 并在所有线程结束后，在控制台打印”Done10”.
    public static void main(String[]args)
    {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(new File(path+"input.txt")),true);
            Random random = new Random();
            for(int i =0;i<10000;i++)
            {
                pw.print(Math.abs(random.nextInt())%100+" ");
            }
            pw.flush();
            pw.close();  //输出10000个数到文件中。

            BufferedReader reader = new BufferedReader(new FileReader(path+"input.txt"));
            String str = reader.readLine();
            reader.close();
            String []strs = str.split(" ");
            int j =0;
            for(int i=0;i<5;i++)
            {
                int []records = new int [2000];
                for(int k=0;k<2000;k++)
                {
                    records[k] = Integer.parseInt(strs[j]);
                    j++; //读入每一个字符。数字
                }
                PrintWriter writer = new PrintWriter(new FileWriter(new File(path+"output"+i+".txt")), true);
                myThreadGroup group = new myThreadGroup(records, writer);
                new Thread(group).start();
                new Thread(group).start();
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}

class myThreadGroup implements Runnable{
    private static int count = 0;
    private static Object lock = new Object();
    public static final int EVEN = 0;
    public static final int ODD = -1;
    //myThreadGroup成员变量ODD应该是-1，代码的type=~type 0按位取反应该是-1；1的话break的条件不能成立，容易造成边界溢出
    //Exception in thread "Thread-3" java.lang.ArrayIndexOutOfBoundsException: 2000
    //	at InterviewDirectory.netEASe2017.myThreadGroup.print(multiThreadPrint.java:116)
    //	at InterviewDirectory.netEASe2017.myThreadGroup.run(multiThreadPrint.java:83)
    //	at java.lang.Thread.run(Thread.java:748)
    private int type;
    private int records[];
    private PrintWriter writer;
    private int oddPoint = 0;
    private int evenPoint = 0;


    public myThreadGroup(int [] records, PrintWriter writer) {
        this.records = records;
        this.writer = writer;
        this.type = EVEN;
    }

    public void run()
    {
        while (print());  //两个线程进来之后会一直循环，直到循环输出2000个数字为止。
    }

    private synchronized boolean print() {
        for(int i =0;i<10;)
        {
            if(oddPoint>=records.length&&evenPoint>=records.length)
            {
                notifyAll();
                return false;
            }
            if((oddPoint>=records.length&&type==ODD)||(evenPoint>=records.length&&type==EVEN))
                break;
            if(type==EVEN)
            {
                if(records[evenPoint]%2==0)
                {
                    i++;
                    writer.print(records[evenPoint]+" ");
                    writer.flush();
                    synchronized (lock)
                    {
                        count++;
                        if(count%1000==0)
                        {
                            System.out.println("当前完成量："+count);
                            if(count==10000)
                                System.out.println("Done!");
                        }
                    }
                }
                evenPoint++;
            }else {
                if(records[oddPoint]%2==1)
                {
                    i++;
                    writer.print(records[oddPoint]+" ");
                    writer.flush();
                    synchronized (lock)
                    {
                        count++;
                        if(count%1000==0)
                        {
                            System.out.println("当前完成量："+ count);
                            if(count==10000)
                            {
                                System.out.println("Done!");
                            }
                        }
                    }
                }
                oddPoint++;
            }
        }
        type=~type;
        notifyAll();
        try {
            wait();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return true;
    }


}