package InterviewDirectory.StringProblem;

import java.util.Comparator;

/**
 * Created by huali on 2018/4/8.
 */
public class MyComparator implements Comparator<String> {
    //实现了父类接口public interface Comparator<T>
    @Override   //并重写compare方法。int compare(T o1, T o2);
    public int compare(String a, String b) {
        return (a + b).compareTo(b + a);
    //自己重写的compare方法，根据自己的实际需求写出代码。这时候我们要比较的是：
    //    字符串从小到大排列，abc , ac, bc,应该排列成，abc ac bc //所以要找最小的排列在前面
    //                                              ac abc bc//这种排列比第一种要大。
    //  因为可以证明的是：a.c<b.c  a.b>b.a
    //    以及AM1M2M3......L<LM1M2M3.....A
    //    所以使用连接 ，证明大小， a+b的字符串的值小于b+a的话，返回-1 ，否则返回1
    //                            a+b<b+a  return -1;
    //                            a+b>b+a  return 1;
    }
}