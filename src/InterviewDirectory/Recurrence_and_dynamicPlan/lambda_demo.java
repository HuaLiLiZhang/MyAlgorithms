package InterviewDirectory.Recurrence_and_dynamicPlan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by huali on 2018/3/30.
 */
public class lambda_demo {
    public void lambda0()
    {
        String []atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> asList = Arrays.asList(atp);
        //以前的循环方式
        for(String s :asList)
        {
            System.out.println(s+" : ");
        }

        // 使用 lambda 表达式以及函数操作(functional operation)
        asList.forEach((s) -> System.out.println(s + ":"));

        // 在 Java 8 中使用双冒号操作符(double colon operator)
        //asList.forEach(System.out::print);
        asList.forEach(System.out::println);

        //这里讲一讲双冒号操作符。


        //使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();

        //1.2使用lambda表达式
        Runnable  racel = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        //1.3使用lambda表达式，更简洁方式
        Runnable race2 = ()-> System.out.println("hello");

        //这里直接调用lambda表达式。直接调用run方法，没开新线程。
        racel.run();
        race2.run();


        //排序集合
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

// 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        // 1.2 使用 lambda expression 排序 players
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);

// 1.3 也可以采用如下形式:
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));

        // 1.1 使用匿名内部类根据 surname 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });

// 1.2 使用 lambda expression 排序,根据 surname
        Comparator<String> sortBySurname = (String s1, String s2) ->
                ( s1.substring(s1.indexOf(" ")).compareTo( s2.substring(s2.indexOf(" ")) ) );
        Arrays.sort(players, sortBySurname);

// 1.3 或者这样,怀疑原作者是不是想错了,括号好多...
        Arrays.sort(players, (String s1, String s2) ->
                ( s1.substring(s1.indexOf(" ")).compareTo( s2.substring(s2.indexOf(" ")) ) )
        );

// 2.1 使用匿名内部类根据 name lenght 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.length() - s2.length());
            }
        });

// 2.2 使用 lambda expression 排序,根据 name lenght
        Comparator<String> sortByNameLenght = (String s1, String s2) -> (s1.length() - s2.length());
        Arrays.sort(players, sortByNameLenght);

// 2.3 or this
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

// 3.1 使用匿名内部类排序 players, 根据最后一个字母
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
            }
        });

// 3.2 使用 lambda expression 排序,根据最后一个字母
        Comparator<String> sortByLastLetter =
                (String s1, String s2) ->
                        (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        Arrays.sort(players, sortByLastLetter);

// 3.3 or this
        Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));

        //使用Lambdas和Streams
        //Stream是对集合的包装,通常和lambda一起使用。
        // 使用lambdas可以支持许多操作,如 map, filter, limit, sorted, count, min, max, sum, collect 等等。
        // 同样,Stream使用懒运算,他们并不会真正地读取所有数据,遇到像getFirst() 这样的方法就会结束链式语法。

        //若要用list存放很多person类的对象。
        //List<Person> javaProgrammers = new ArrayList<Person>() {
        //  {
        //    add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
        //    add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
        //    add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
        //    add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
        //    add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
        //    add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
        //    add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
        //    add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
        //    add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
        //    add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
        //  }
        //};

        //可以用lambda表达式的forEach()方法迭代输入
        //System.out.println("所有程序员的姓名:");
        //javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        //phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        //我们同样使用forEach方法,增加程序员的工资5%:
        //System.out.println("给程序员加薪 5% :");
        //Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        //javaProgrammers.forEach(giveRaise);
        //phpProgrammers.forEach(giveRaise);

        //另一个有用的方法是过滤器filter() ,让我们显示月薪超过1400美元的PHP程序员:
        //System.out.println("下面是月薪超过 $1,400 的PHP程序员:")
        //phpProgrammers.stream()
        //          .filter((p) -> (p.getSalary() > 1400))
        //          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        //// 定义 filters
        //Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        //Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        //Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
        //
        //System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
        //phpProgrammers.stream()
        //          .filter(ageFilter)
        //          .filter(salaryFilter)
        //          .filter(genderFilter)
        //          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        //
        //// 重用filters
        //System.out.println("年龄大于 24岁的女性 Java programmers:");
        //javaProgrammers.stream()
        //          .filter(ageFilter)
        //          .filter(genderFilter)
        //          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));


        //使用limit方法,可以限制结果集的个数:

        //System.out.println("最前面的3个 Java programmers:");
        //javaProgrammers.stream()
        //          .limit(3)
        //          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        //
        //
        //System.out.println("最前面的3个女性 Java programmers:");
        //javaProgrammers.stream()
        //          .filter(genderFilter)
        //          .limit(3)
        //          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));



    }



    public static void main(String []args)
    {
        lambda_demo demo = new lambda_demo();
        demo.lambda0();
    }
}