package InterviewDirectory.reflect;

import java.lang.reflect.Field;

/**
 * Created by huali on 2018/5/19.
 */
public class reflectDemo {
    public static void main(String[]args)  throws  Exception
    {
        getFieldDemo();

    }

    //获取字节码文件的字段。
    private static void getFieldDemo() throws Exception {
        Class clazz = Class.forName("InterviewDirectory.reflect.person");
        Field field = null;
        //field = clazz.getField("age");//只能获取公有的。
        field = clazz.getDeclaredField("age");  //只获取本类但包含私有。
        System.out.println(field);
    }
}