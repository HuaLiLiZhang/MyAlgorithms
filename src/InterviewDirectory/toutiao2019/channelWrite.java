package InterviewDirectory.toutiao2019;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by huali on 2018/8/24.
 */
public class channelWrite {
    //String  data  int  bool  char  long  float  double short byte
    public static void main(String[] args) throws Exception, InterruptedException
    {
        RandomAccessFile accessFile = new RandomAccessFile("data.txt","rw");
        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.put("hello WebClient this is from WebServer".getBytes());
        byteBuffer.flip();
        int bytecount = fileChannel.write(byteBuffer, 66);
        System.out.println(bytecount);

        ByteBuffer bufferread = ByteBuffer.allocate(200);
        bytecount = fileChannel.read(bufferread);
        StringBuilder stringBuffer=new StringBuilder();
        //4.将Buffer从写模式变为可读模式
        bufferread.flip();
        while (bufferread.hasRemaining()) {
            stringBuffer.append((char) bufferread.get());
        }
        System.out.println("从客户端接收到的数据："+stringBuffer);
        byteBuffer.clear();
        bytecount = fileChannel.read(byteBuffer);
        System.out.println(bytecount);

    //    结果：
//38
//从客户端接收到的数据：String
//data
//int
//bool
//char
//long
//float
//double
//short
//byte
//hello WebClient this is from WebServer
//-1
    }

}