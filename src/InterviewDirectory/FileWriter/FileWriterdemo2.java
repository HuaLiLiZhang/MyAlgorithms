package InterviewDirectory.FileWriter;


import java.io.FileReader;
import java.io.IOException;

/**
 * Created by huali on 2018/5/12.
 */
public class FileWriterdemo2 {
    public static final String PATH = "E:\\JavaBook\\MyprojectTouTiao\\MyAlgorithms\\filewriter\\" ;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[]args)
    {
        FileReader fr = null;
        try {
            fr = new FileReader(PATH+"demo.txt");
            //    使用read(char[])读取文本文件数据
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fr.read(buf))!=-1)
            {
                System.out.println(new String(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fr!=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}