package InterviewDirectory.reflect;

/**
 * Created by huali on 2018/5/19.
 */
public class soundcard implements PCI{
    @Override
    public void open() {
        System.out.println("soundcard open");
    }

    @Override
    public void close() {
        System.out.println("soundcard close");
    }
}