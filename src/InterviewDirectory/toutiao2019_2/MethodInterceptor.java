package InterviewDirectory.toutiao2019_2;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by huali on 2018/8/27.
 */
public interface MethodInterceptor {
    public Object intercept(Object obj, Method method, Object[] args, Proxy proxy) throws Throwable;
}
