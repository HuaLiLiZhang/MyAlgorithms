package InterviewDirectory.JD2019_1;

/**
 * Created by huali on 2018/9/10.
 */
public class classLoader {
    public static void main(String[] args)
    {
        System.out.println(B.A);
        new B();

    }
}
class A{
    static {
        System.out.print(" A ");
    }
}
class B extends A{
    public final static String  A = " A ";
    static {
        System.out.print(" B ");
    }
}