package InterviewDirectory.LeetCode_after;

/**
 * Created by huali on 2018/9/12.
 */
public class double00000 {
    public static void main(String[] args)
    {
        double i = 0.0/0.0;   //NaN
        double i1 = 1.0/0.0;  //Infinity
        Double i2 = 0.0/0.0;  //NaN
        Double i3 = 1.0/0.0;  //Infinity
        double i4 = 0.0/0;    //NaN
        double i5 = 1.0/0;  //Infinity
        //int i6 = 0/0;  // java.lang.ArithmeticException: / by zero
        System.out.println(i==i);     //false
        System.out.println(i1==i1);   //true
        System.out.println(i2==i2);   //true  //这个为啥系true呢？NaN，Double，包装类
        System.out.println(i3==i3);   //true
        System.out.println(i4==i4);   //false
        System.out.println(i5==i5);   //true
//false
//true
//true
//true
//false
//true
    }
}