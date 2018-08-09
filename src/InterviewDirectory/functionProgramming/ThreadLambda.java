package InterviewDirectory.functionProgramming;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by huali on 2018/8/8.
 */
public class ThreadLambda {
    public static void main(String[] args)
    {
        //HashMap<String, Integer> map = new HashMap<>(26);
        //map.put("adf",1);
        //System.out.println(map);
        //System.out.println(map.size());
        //hashMap强制利用tableSizeFor()使得threshold是2的次幂。

        //TreeSet<Integer> treeset = new TreeSet<>(new Comparator<Integer>() {
        //    @Override
        //    public int compare(Integer o1, Integer o2) {
        //        return o1-o2;
        //    }
        //});
        TreeSet<Integer> treeset = new TreeSet<>();
        treeset.add(13);
        treeset.add(15);
        treeset.add(5);
        System.out.println(treeset);





        //Runnable runnable = ()->{System.out.println("hello"); try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //};
        //Thread t1 = new Thread(runnable);
        //t1.start();
        //Thread t2 = new Thread(runnable);
        //t2.start();
        ////try {
        ////    Thread.sleep(1000);
        ////} catch (InterruptedException e) {
        ////    e.printStackTrace();
        ////}
        //System.out.println("main");

        MathOperation mathAdd = (int a, int b)->a+b;
        MathOperation mathsub = (a, b)->a-b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;
        ThreadLambda tl = new ThreadLambda();
        System.out.println("10 + 5 = " + tl.operate(10,5, mathAdd));
        System.out.println("10 - 5 = " + tl.operate(10,5,mathsub));
        System.out.println("10 x 5 = " + tl.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tl.operate(10, 5, division));
        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}