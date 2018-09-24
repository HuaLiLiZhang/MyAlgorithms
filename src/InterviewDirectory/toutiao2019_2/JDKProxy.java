package InterviewDirectory.toutiao2019_2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by huali on 2018/8/26.
 */

public class JDKProxy implements InvocationHandler {

    private Object target;
    public JDKProxy(Object target)
    {
        this.target = target;
    }

    /**
     * 获取代理对象，当前类继承InvocationHandler
     *
     * @return
     */
    public Object getProxyObject()
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        //添加功能
        System.out.println("增强代码，添加日志功能");
        //执行原有方法
        return method.invoke(target, args);
    }


    //@Test
    //public void JdkProxyTest() {
    public static void main(String []args){
        //创建目标对象
        UserService userService = new UserServiceImpl();
        //创建工厂对象
        JDKProxy jdkProxyFactory = new JDKProxy(userService);
        UserService proxy = (UserService) jdkProxyFactory.getProxyObject();
        proxy.save();
        System.out.println("=========================");
        int num = proxy.select();
        System.out.println(num);
    }






    //private UserDao userdao;
    //public JDKProxy(UserDao userDao)
    //{
    //    super();
    //    this.userdao = userDao;
    //}
    //
    //@Override
    //public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //    if("add".equals(method.getName()))
    //    {
    //        System.out.println("日志记录————————");
    //        Object result = method.invoke(userdao, args);
    //        return result;
    //    }
    //    return method.invoke(userdao,args);
    //}
}