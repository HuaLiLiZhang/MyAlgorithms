package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/4.
 */
public class Main {
    public static void main(String []args)
    {
        String a = "123";
        String b = "312";
        isRotation is = new isRotation();
        boolean rotation  = is.isrotation(b, a);
        System.out.println(rotation);
    }
}