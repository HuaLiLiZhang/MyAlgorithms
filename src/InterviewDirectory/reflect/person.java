package InterviewDirectory.reflect;

/**
 * Created by huali on 2018/5/19.
 */
public class person {
    private int age;
    public person(int age){
        this.age = age;
    }
    public person(){

    }

    public int getAge() {
        System.out.println("get 方法 运行");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("set 方法运行" +age);
    }
}