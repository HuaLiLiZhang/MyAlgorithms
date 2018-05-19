package InterviewDirectory.reflect;

/**
 * Created by huali on 2018/5/19.
 */
public class netcard implements PCI{
    @Override
    public void open() {
        System.out.println("netcars open");
    }

    @Override
    public void close() {
        System.out.println("netcard close");
    }
}