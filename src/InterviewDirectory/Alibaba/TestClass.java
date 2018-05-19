package InterviewDirectory.Alibaba;

/**
 * Created by huali on 2018/5/19.
 */
public class TestClass {
    private static void testMethod(){
        System.out.println("testMethod");
    }
    public static void main(String[] args) {
        ((TestClass)null).testMethod();
    }
}