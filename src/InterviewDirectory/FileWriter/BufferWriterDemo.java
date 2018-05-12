package InterviewDirectory.FileWriter;

        import java.io.*;

/**
 * Created by huali on 2018/5/12.
 */
public class BufferWriterDemo {
    public static final String PATH = "E:\\JavaBook\\MyprojectTouTiao\\MyAlgorithms\\filewriter\\" ;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String [] args) throws IOException
    {
        FileWriter fw = new FileWriter(PATH+"buf.txt");
        //创建一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联。
        BufferedWriter bufw = new BufferedWriter(fw);

        //    使用缓冲区的写入方法将数据先写入到缓冲区中。
        bufw.write("abcdef\r\ngsdagdfg");
        bufw.newLine();
        bufw.write("sdfsgsd");
        //    使用缓冲区的刷新方法将数据刷新到目的地。
        bufw.flush();

        //缓冲区读取数据
        FileReader fr = new FileReader(PATH+"buf.txt");
        BufferedReader bufr = new BufferedReader(fr);
        String line = null;
        while ((line=bufr.readLine())!=null)
            System.out.println(line);
        //关闭缓冲区，相当于关闭了流对象
        bufw.close();
    }
}