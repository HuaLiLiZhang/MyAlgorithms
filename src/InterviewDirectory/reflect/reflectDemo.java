package InterviewDirectory.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by huali on 2018/5/19.
 */
public class reflectDemo {
    public static void main(String[]args)  throws  Exception
    {
        //getFieldDemo();

        getMethoddemo2();
    }

    private static void getMethoddemo2() throws Exception {
        Class clazz = Class.forName("InterviewDirectory.reflect.person");
        Method method = clazz.getMethod("getAge",null);   //获取空参数的一般方法
        Object obj = clazz.newInstance();
        //person p1 = (person)clazz.newInstance();
        method.invoke(obj,null);

        Method method1 = clazz.getMethod("setAge", int.class);
        Object object = clazz.newInstance();
        method1.invoke(object, 4576);

    }

    //获取字节码文件的字段。
    private static void getFieldDemo() throws Exception {
        Class clazz = Class.forName("InterviewDirectory.reflect.person");
        Field field = null;
        //field = clazz.getField("age");//只能获取公有的。
        field = clazz.getDeclaredField("age");  //只获取本类但包含私有。
        System.out.println(field);
        //对私有字段的访问取消权限检查，暴力访问。
        field.setAccessible(true);
        //直接访问字段。默认为0.
        Object obj = clazz.newInstance();
        Object o = field.get(obj);
        System.out.println(o);
        //反射设置字段的值。不用使用对象进行设置。
        field.set(obj, 89);
        Object o1 = field.get(obj);
        System.out.println(o1);


    //    当获取指定名称对应类中所体现的对象时，
        // 而对象初始化不使用空参数的构造函数怎么办？
    //    可以获取指定的构造函数，通过字节码文件对象即可完成。
        // 该方法： getConstructor(paramterType)

        String name = "InterviewDirectory.reflect.person";
    //    寻找该名称的文件，并加载进内存，并产生class对象。
        Class class1 = Class.forName(name);
        //获取指定构造函数对象。
        Constructor constructor = class1.getConstructor(int.class);
    //    通过该构造器对象的newInstance方法进行对象初始化。
        Object obj1 = constructor.newInstance(46);
        Object o2 = field.get(obj1);
        System.out.println(o2);


        Method[] methods = class1.getMethods();//获取公有的方法
        methods = class1.getDeclaredMethods();    //只获取本类的方法，包含私有
        for(Method me : methods)
        {
            System.out.println(me);
        }
    }
}