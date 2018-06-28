package offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by huali on 2018/6/28.
 */
public class finalClass {
    public static void main(String[]args)
    {
      //  Integer i= 3;
      //  String s = "abc";
      //  AtomicInteger a = new AtomicInteger(1);
      //  List<Integer> li = new  ArrayList<>();
      //  li.add(1);
      //  Vector vector = new Vector(1);
      //  vector.add(1);
      //  LinkedList<Integer> linked = new LinkedList<>();
      //
      //  Thread t1 = new Thread(new Runnable() {
      //      @Override
      //      public void run() {
      //          for(int i=0;i<10;i++)
      //          {
      //              try {
      //                  Thread.sleep(1000);
      //                  System.out.print(i+"——");
      //              } catch (InterruptedException e) {
      //                  e.printStackTrace();
      //              }
      //
      //          }
      //          System.out.println();
      //      }
      //  });
      //t1.start();

        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //executorService.submit(new Runnable() {
        //    @Override
        //    public void run() {
        //        for(int i=0;i<10;i++)
        //        {
        //            System.out.print(i+" ");
        //        }
        //        System.out.println();
        //    }
        //});
        //executorService.shutdown();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                {
                    //try {
                        //Thread.sleep(1000);
                        System.out.println("Execute1 "+i);
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                }
                System.out.println();
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                {
                    //try {
                    //    Thread.sleep(1000);
                        System.out.println("Execute2 "+i);
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                }
                System.out.println();
            }

        });
        executor.shutdown();



    }
}