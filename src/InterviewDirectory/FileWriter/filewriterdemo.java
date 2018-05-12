package InterviewDirectory.FileWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by huali on 2018/5/12.
 */
public class filewriterdemo {
    public static final String PATH = "E:\\JavaBook\\MyprojectTouTiao\\MyAlgorithms\\filewriter\\" ;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String []args) throws IOException {

        FileWriter fw = new FileWriter(PATH+"demo.txt");
        //第一步创建对象，必须明确该文件（用于存储数据的目的地。
    //    如果文件不存在，自动建立。若存在，则被覆盖
        fw.write("absdfskjdf");
    //    调用writer对象中的writer(String)方法，写入数据。
    //        其实数据是写入临时缓冲区

        fw.write(LINE_SEPARATOR);
        //若要实现写入时换行。
        fw.write("sagsfg\r\nsfsagsa");
        //或者调用系统的换行属性
        fw.write("abcde"+LINE_SEPARATOR+"hahahah");

        fw.flush();
    //    刷新以后，将数据写进目的地；
        fw.close();
    //    关闭流，关闭资源。关闭之后不能写数据。



    }
}