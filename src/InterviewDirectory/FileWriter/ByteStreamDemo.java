package InterviewDirectory.FileWriter;




import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huali on 2018/5/13.
 */
public class ByteStreamDemo {
    public static final String PATH = "E:\\JavaBook\\MyprojectTouTiao\\MyAlgorithms\\filewriter\\" ;

    public static void  main(String []args) throws IOException
    {
        //demo_write();
        demo_read();
    }

    private static void demo_read() throws IOException {
    //    1.创建一个读取流对象，和指定文件关联。
        FileInputStream fi = new FileInputStream(PATH+"bytedemo.txt");

        byte [] buf = new byte[1024];
        int len = 0;
        while ((len=fi.read(buf))!=-1)
        {
            System.out.println(new String(buf, 0, len));
        }
        //byte [] buf = new byte[fi.available()];
        //fi.read(buf);
        //System.out.println(new String(buf));
    }

    private static void demo_write() throws IOException
    {
    //       1.创建字节输出流对象，用于操作文件。
        FileOutputStream fos = new FileOutputStream(PATH+"bytedemo.txt");
    //    2.写入数据，直接写入到目的地。
        fos.write("absdfsdf".getBytes());
    //    不需要刷新。flush()
    //    直接关闭流
        fos.close();
    }
}
