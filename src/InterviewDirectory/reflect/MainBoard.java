package InterviewDirectory.reflect;

/**
 * Created by huali on 2018/5/19.
 */
public class MainBoard {
    public void run() {
        System.out.println("main board run!!1");
    }

    public void UsePCI(PCI pci) {
        pci.open();
        pci.close();
    }
}