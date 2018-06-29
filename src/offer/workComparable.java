package offer;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by huali on 2018/6/29.
 */
public class workComparable {
    public static void main(String[] args) {
        //创建TreeSet并加入worker对象
        TreeSet<Worker> set = new TreeSet<Worker>();
        set.add(new Worker("zhang3", 18));
        set.add(new Worker("li4", 25));
        set.add(new Worker("wang5", 22));
        set.add(new Worker("lao6", 22));
        set.add(new Worker("xiaoming", 22));

        //遍历输出信息
        Iterator<Worker> iterator = set.iterator();
        while (iterator.hasNext()) {
            Worker worker = iterator.next();
            System.out.println(worker);
        }
    }
}

class Worker implements Comparable<Worker> {
    private String name;
    private int age;

    public Worker(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    /*
     * 先按年龄排，次要按名字排
     * 负整数、零或正整数，根据此对象是小于、等于还是大于指定对象。
     */
    @Override
    public int compareTo(Worker w) {
        int sub = this.age - w.age;
        if (sub == 0)
            return this.name.compareTo(w.name);//使用String的comareTo方法
        else
            return sub;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Worker [name=" + name + ", age=" + age + "]";
    }
}