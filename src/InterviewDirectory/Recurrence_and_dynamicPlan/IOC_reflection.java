package InterviewDirectory.Recurrence_and_dynamicPlan;

import java.lang.reflect.*;
import java.util.List;

/**
 * Created by huali on 2018/3/31.
 */
public class IOC_reflection {
    public String name;
    public int age;
    IOC_reflection(){
        System.out.println("IOC_reflection constructor "+age);
    }
    public static void main(String[]args)
    {

        //反射机制：往往在运行时检查java类的信息。class类，类名，，，，
        //这个例子通过调用类的class属性获取对应的class对象，
        // 通过这个 Class 类的对象获取 MyObject 类中的方法集合
        Method []methods = zi.class.getMethods();
        for(Method method: methods)
        {
            System.out.println("method: "+method.getName());
        }
        System.out.println(zi.class.getName());
        //结果：
        //method: addzi
        //method: wait
        //method: wait
        //method: wait
        //method: equals
        //method: toString
        //method: hashCode
        //method: getClass
        //method: notify
        //method: notifyAll
        //InterviewDirectory.Recurrence_and_dynamicPlan.zi

        Method[] declaredMethods = zi.class.getDeclaredMethods();
        for(Method m:declaredMethods)
            System.out.println(m);
        //public void InterviewDirectory.Recurrence_and_dynamicPlan.zi.addzi()

        //1.Class 对象
        //在你想检查一个类的信息之前，你首先需要获取类的 Class 对象。
        // Java 中的所有类型包括基本类型(int, long, float等等)，
        // 即使是数组都有与之关联的 Class 类的对象。
        // 如果你在编译期知道一个类的名字的话，
        // 那么你可以使用如下的方式获取一个类的 Class 对象。
        Class<?> classInt = Integer.TYPE;
        System.out.println(classInt.getClass());  // class java.lang.Class

        //2.获取类名。
        Class<?> klass = int.class;
        System.out.println(klass.getName());  // int

    //    (3)调用某个对象的getClass()方法,比如:
        StringBuilder str = new StringBuilder("123");
        Class<?> klass1 = str.getClass();
        System.out.println(klass1); //        class java.lang.StringBuilder

        //3.修饰符
        //可以通过 Class 对象来访问一个类的修饰符，
        // 即public,private,static 等等的关键字，
        // 你可以使用如下方法来获取类的修饰符：
        //
        Class  aClass = IOC_reflection.class ;//获取Class对象
        int modifiers = aClass.getModifiers();
        System.out.println(modifiers);  //1

        //4、判断是否为某个类的实例
        //一般地，我们用instanceof关键字来判断是否为某个类的实例。
        // 同时我们也可以借助反射中Class对象的isInstance()方法来判断是否为某个类的实例，
        // 它是一个Native方法：
        //public native boolean isInstance(Object obj);
        zi z = new zi(1);
        fu f = new fu();
        System.out.println(zi.class.isInstance(f));  //false
        System.out.println(fu.class.isInstance(f));  //true

        //4.包信息
        //可以使用 Class 对象通过如下的方式获取包信息：
        //
        Class  aClass1 = zi.class; //获取Class对象
        Package p = aClass1.getPackage();
        System.out.println(p);   //package InterviewDirectory.Recurrence_and_dynamicPlan

        //5.父类
        //通过 Class 对象你可以访问类的父类，如下例：
        //
        Class superclass = zi.class.getSuperclass();
        System.out.println(superclass.getName());  //fu 类的父类java.lang.Object
        //InterviewDirectory.Recurrence_and_dynamicPlan.fu

        //6.获取成员变量
        //主要是这几个方法
        //getFiled: 访问公有的成员变量
        //getDeclaredField：所有已声明的成员变量。但不能得到其父类的成员变量
        //getFileds和getDeclaredFields用法同上（参照Method）
        Field[] method = zi.class.getFields();
        for (int i = 0;i<method.length;++i)
        {
            System.out.println(method[i]);
        }
        //public java.lang.String InterviewDirectory.Recurrence_and_dynamicPlan.zi.major
        //public int InterviewDirectory.Recurrence_and_dynamicPlan.zi.grade
        //public java.lang.String InterviewDirectory.Recurrence_and_dynamicPlan.fu.name
        //public int InterviewDirectory.Recurrence_and_dynamicPlan.fu.age

        //7.创建实例：
        try{
            //、、通过反射来生成对象主要有两种方式。
            //（1）使用Class对象的newInstance()方法来创建Class对象对应类的实例。
            Class<?> c = IOC_reflection.class;
            Object fuO = c.newInstance();
            System.out.println(fuO.getClass());  //IOC_reflection constructor 0
            //class InterviewDirectory.Recurrence_and_dynamicPlan.IOC_reflection
            //（2）先通过Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建实例。这种方法可以用指定的构造器构造类的实例。

            //获取String所对应的Class对象
            Class<?> c1 = String.class;
            //获取String类带一个String参数的构造器
            Constructor constructor = c1.getConstructor(String.class);
            //根据构造器创建实例
            Object obj = constructor.newInstance("22233");
            System.out.println(obj);  //22233

            //8. 利用反射创建数组
            //数组在Java里是比较特殊的一种类型，
            // 它可以赋值给一个Object Reference。
            // 下面我们看一看利用反射创建数组的例子：
            Class<?> cls = Class.forName("java.lang.String");
            Object array = Array.newInstance(cls,25);
            //往数组里添加内容
            Array.set(array,0,"hello");
            Array.set(array,1,"Java");
            Array.set(array,2,"fuck");
            Array.set(array,3,"Scala");
            Array.set(array,4,"Clojure");
            //获取某一项的内容
            System.out.println(Array.get(array,3));  //Scala
        //    其中的Array类为java.lang.reflect.Array类。
            // 我们通过Array.newInstance()创建数组对象，它的原型是:
            //public static Object newInstance(Class<?> componentType, int length)
            //        throws NegativeArraySizeException {
            //        return newArray(componentType, length);
            //    }
            //而newArray()方法是一个Native方法，它在Hotspot JVM里的具体实现我们后边再研究，这里先把源码贴出来
            //private static native Object newArray(Class<?> componentType, int length)
            //        throws NegativeArraySizeException;


            //9.运用泛型反射的经验法则
            //
            //下面是两个典型的使用泛型的场景：
            //1、声明一个需要被参数化（parameterizable）的类/接口。
            //2、使用一个参数化类。

            Method method1 = MyClass.class.getMethod("getStringList", null);

            Type returnType = method1.getGenericReturnType();

            if(returnType instanceof ParameterizedType){
                ParameterizedType type = (ParameterizedType) returnType;
                Type[] typeArguments = type.getActualTypeArguments();
                for(Type typeArgument : typeArguments){
                    Class typeArgClass = (Class) typeArgument;
                    System.out.println("typeArgClass = " + typeArgClass);
                }//打印出：typeArgClass = class java.lang.String,
                //Type[]数组typeArguments 只有一个结果
                // – 一个代表 java.lang.String 的 Class 类的实例。
                // Class 类实现了 Type 接口。
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
class fu
{
    public String name;
    public int age;
    fu(){
        System.out.println("fu constructor "+name + age);
    }
}
class zi extends fu{
    public String major;
    public int grade;
    zi(int grade)
    {
        this.grade = grade;
        System.out.println("zi construtor "+grade);
    }
    public void addzi()
    {
        System.out.println(grade+1);
    }
}

class MyClass {

    protected List<String> stringList ;

    public List<String> getStringList(){
        return this.stringList;
    }
}