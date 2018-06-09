package InterviewDirectory.qihu360;

import java.util.HashMap;

/**
 * Created by huali on 2018/6/1.
 */

public class test {
    static int count = 0;
    public static void main(String[]args)
    {
        HashMap map = new HashMap();
        map.put("name",null);
        map.put("name","Jack");
        System.out.println(map.size());

        fib(10);
        System.out.println(count);
    }

    static int fib(int n){
        count++;
        if(n==0)
            return 1;
        else if(n==1)
            return 2;
        else
            return fib(n-1)+fib(n-2);
    }
}