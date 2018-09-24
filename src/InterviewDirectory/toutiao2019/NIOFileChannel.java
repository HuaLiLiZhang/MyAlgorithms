package InterviewDirectory.toutiao2019;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by huali on 2018/8/24.
 */
public class NIOFileChannel {
//String
//data
//int
//bool
//char
//long
//float
//double
//short
//byte
    public static void main(String[] args) throws IOException, InterruptedException {

        RandomAccessFile accessFile = new RandomAccessFile("data.txt","rw");
        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(42);
        //read 48
        //String  data  int  bool  char  long  float  doub
        //15
        //表示没有写完，缓冲区大小有限制，只读入48，剩下的等读完，清空缓存区，再次继续读入。
        int bytecount = fileChannel.read(byteBuffer);
        while (bytecount!=-1)
        {
            System.out.println("read "+ bytecount);
            byteBuffer.flip();
            bytecount = -1;
        }
        String temp = "";
        while (byteBuffer.hasRemaining())
        {
            char c = (char) byteBuffer.get();
            if(c!='\r'&&c!='\n')
            {
                temp +=c;
            }else
            {
                System.out.print(temp+" ");
                temp = "";
            }
        }
        System.out.println(temp);
        byteBuffer.clear();
        bytecount = fileChannel.read(byteBuffer);
        System.out.println(bytecount);


        //没读完继续读
        //read 50
        //String  data  int  bool  char  long  float  double
        //13
        //read 13
        //short byte
        //-1

        while (bytecount!=-1)
        {
            System.out.println("read "+ bytecount);
            byteBuffer.flip();
            bytecount = -1;
        }
        temp = "";
        while (byteBuffer.hasRemaining())
        {
            char c = (char) byteBuffer.get();
            if(c!='\r'&&c!='\n')
            {
                temp +=c;
            }else if(!temp.equals(""))
            {
                System.out.print(temp+" ");
                temp = "";
            }
        }
        System.out.println(temp);
        byteBuffer.clear();
        bytecount = fileChannel.read(byteBuffer);
        System.out.println(bytecount);
        accessFile.close();









        //RandomAccessFile accessFile = new RandomAccessFile("data.txt","rw")   ;
        //FileChannel fileChannel = accessFile.getChannel();
        //ByteBuffer buffer = ByteBuffer.allocate(48); //申请48字节的缓冲区
        //int byteRead  = fileChannel.read(buffer);
        //
        //while (byteRead!=-1)
        //{
        //    System.out.println("read"+byteRead);
        //    Thread.sleep(500);
        //    buffer.flip();
        //    byteRead = -1;
        //}
        //
        //while (buffer.hasRemaining())
        //{
        //    System.out.println((char) buffer.get());
        //}
        //buffer.clear();
        //byteRead = fileChannel.read(buffer);
        //accessFile.close();

    }
}