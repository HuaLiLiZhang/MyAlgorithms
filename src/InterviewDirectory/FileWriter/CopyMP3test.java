package InterviewDirectory.FileWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huali on 2018/5/13.
 */
public class CopyMP3test {
    public static final String PATH = "E:\\JavaBook\\MyprojectTouTiao\\MyAlgorithms\\filewriter\\" ;

    public static void main(String []args) throws IOException
    {
        copy_1();
    }

    private static void copy_1() throws IOException{
        FileInputStream fi = new FileInputStream(PATH+"1.mp3");
        FileOutputStream fo = new FileOutputStream(PATH+"2.mp3");
        byte [] buf = new byte[1024];
        int len =0;
        while ((len=fi.read(buf))!=-1)
        {
            fo.write(buf, 0,len);
        }
        fo.close();
        fi.close();
    }
}