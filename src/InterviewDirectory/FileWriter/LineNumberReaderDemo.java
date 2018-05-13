package InterviewDirectory.FileWriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Created by huali on 2018/5/13.
 */
public class LineNumberReaderDemo {
    public static final String PATH = "E:\\JavaBook\\MyprojectTouTiao\\MyAlgorithms\\filewriter\\" ;

    public static void main(String []args) throws IOException
    {
        FileReader fr = new FileReader(PATH+"buf.txt");

        LineNumberReader lnr = new LineNumberReader(fr);
        String line = null;
        //以行读取，并设置行号。
        lnr.setLineNumber(0);
        //1:abcdef
        //2:gsdagdfg
        //3:absdfskjdf
        //4:sagsfg
        //5:sfsagsaabcde
        //6:hahahah
        while ((line = lnr.readLine())!=null)
        {
            System.out.println(lnr.getLineNumber()+":"+line);
        }
    }
}