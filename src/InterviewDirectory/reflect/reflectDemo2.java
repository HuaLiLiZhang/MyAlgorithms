package InterviewDirectory.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by huali on 2018/5/19.
 */
public class reflectDemo2 {
    public static void main(String[]args)  throws  Exception
    {
        MainBoard md = new MainBoard();
        md.run();
    //    每次添加一个设备都需要修改代码传递一个新创建的对象，（也就是多态问题）
    //    md.UsePCI()
    //    不用new老获得，只获得class的文件，其内部实现创建对象的动作。
        File configfile = new File("E:\\JavaBook\\MyprojectTouTiao\\MyAlgorithms\\src\\InterviewDirectory\\reflect\\PCI.properties");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(configfile);
        prop.load(fis);
        for(int x =0;x<prop.size();x++)
        {
            String pciname = prop.getProperty("pci"+(x+1));
            Class clazz = Class.forName(pciname);
            PCI p = (PCI)(clazz.newInstance());
            md.UsePCI(p);
        }
        fis.close();

    }

}