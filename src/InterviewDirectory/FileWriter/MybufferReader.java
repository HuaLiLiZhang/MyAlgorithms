package InterviewDirectory.FileWriter;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by huali on 2018/5/12.
 */
public class MybufferReader {
    private FileReader fr;
    //定义一个缓冲区。
    private char[] buf = new char[1024];
    //定义一个指针用于操作这个数组中的元素，当操作到最后一个元素后，指针归零。
    private int pos = 0;
    //定义一个计数器用于记录缓冲区中的数据个数，当该数据减到0时，就从源中继续获取数据到缓冲区中。
    private int count = 0;
    MybufferReader(FileReader r)
    {
        this.fr = r;
    }

    public int myread() throws IOException
    {
        if(count==0)
        {
            count = fr.read(buf);
            pos=0;
        }
        if(count<0)
            return -1;
        char ch = buf[pos++];
        count--;
        return ch;

    }

    public String myreaderLine() throws IOException
    {
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while ((ch=myread())!=-1)
        {
            if(ch=='\r')
                continue;
            if(ch=='\n')
                return sb.toString();
        //    将缓冲区中读取的字符，存储到缓冲行数据的缓冲行中
            sb.append((char)ch);
        }
        if(sb.length()!=0)
            return sb.toString();  //对于最后一个没有回车的行，也要返回才对。
        return null;
    }
    public void myclose() throws IOException
    {
        fr.close();
    }
}