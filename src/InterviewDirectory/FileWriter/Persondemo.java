package InterviewDirectory.FileWriter;

/**
 * Created by huali on 2018/5/13.
 */
public class Persondemo {
    public static void main(String[] args)
    {
        person p = new person();
        newperson np = new newperson(p);
        np.chifan();
    }
}
class person
{
    void chifan()
    {
        System.out.println("吃饭");
    }
}

class newperson{
    private person p;
    newperson(person p)
    {
        this.p = p;
    }
    public void chifan()
    {
        System.out.println("开胃酒");
        p.chifan();
        System.out.println("甜点");
    }
}