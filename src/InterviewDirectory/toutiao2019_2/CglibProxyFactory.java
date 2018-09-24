package InterviewDirectory.toutiao2019_2;


import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by huali on 2018/8/27.
 */
public class CglibProxyFactory  implements MethodInterceptor{

    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 获取代理对象
     *
     * @return
     */
    //public Object getProxyObject() {
    //    Enhancer enhancer = new Enhancer();
    //    //设置两个参数
    //    //设置生成代理类的目标对象（代理类对象是目标对象的子类）
    //    enhancer.setSuperclass(target.getClass());
    //    //设置回调方法
    //    enhancer.setCallback(this);
    //    //生成代理对象
    //    return enhancer.create();
    //
    //
    //}

    @Override
    public Object intercept(Object o, Method method, Object[] objects, Proxy methodProxy) throws Throwable {
        //添加功能
        System.out.println("增强代码，添加日志功能");
        //执行原有方法
        return method.invoke(target, objects);
    }

    public static void main(String[] args)
    {

    }
}