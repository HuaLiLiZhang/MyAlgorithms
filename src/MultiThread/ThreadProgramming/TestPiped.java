package MultiThread.ThreadProgramming;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by huali on 2018/4/20.
 */
public class TestPiped {
    //通过管道进行线程间的通信。一个线程将数据发送到管道，另一个线程将数据从管道中取出。
    public static void main(String[] args) {

        Sender sender = new Sender();
        Recive recive = new Recive();
        PipedInputStream pi = recive.getPipedInputputStream();
        PipedOutputStream po = sender.getPipedOutputStream();
        try {
            pi.connect(po);  //这一步使得输入和读取通道进行通信链接。po.connect(pi);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        new Thread(sender).start();
        new Thread(recive).start();

    }
}

class Sender implements Runnable {
    PipedOutputStream out = null;

    public PipedOutputStream getPipedOutputStream() {
        out = new PipedOutputStream();
        return out;
    }

    @Override
    public void run() {

        try {
            out.write("Hello , Reciver!".getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}

class Recive implements Runnable {
    PipedInputStream in = null;

    public PipedInputStream getPipedInputputStream() {
        in = new PipedInputStream();
        return in;
    }

    @Override
    public void run() {

        byte[] bys = new byte[1024];
        try {
            in.read(bys);
            System.out.println("读取到的信息：" + new String(bys).trim());
            in.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}