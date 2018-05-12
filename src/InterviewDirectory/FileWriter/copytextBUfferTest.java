package InterviewDirectory.FileWriter;

import java.io.*;

/**
 * Created by huali on 2018/5/12.
 */
public class copytextBUfferTest {
    public static final String PATH = "E:\\JavaBook\\MyprojectTouTiao\\MyAlgorithms\\filewriter\\" ;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
/**
 * 缓冲的原理：
 * 就是从源中获取一批数据装进缓冲区中，
 * 在从缓冲区中不断的取出一个一个数据。
 *
 * 在此次取完后，再从源中继续读取一批数据经缓冲区。
 * 当源中数据取光时， 用-1作为结束的标志。
 */
    public static void main(String [] args) throws IOException {
        //FileWriter fw = new FileWriter(PATH + "buf_copy.txt");
        ////创建一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联。

        //缓冲区读取数据
        FileReader fr = new FileReader(PATH + "buf.txt");
        //BufferedReader bufr = new BufferedReader(fr);


        MybufferReader bufr = new MybufferReader(fr);
        String line = null;
        while ((line=bufr.myreaderLine())!=null)
        {
            System.out.println(line);
        }
        bufr.myclose();



    }
}