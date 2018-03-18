package InterviewDirectory.binaryTree_example;

import java.util.Arrays;

/**
 * Created by huali on 2018/3/18.
 */
public class copyOf_clone_for {
    /**
     * System.arraycopy （浅拷贝）
     * Object.clone(对于对象而言，它是深拷贝，但是对于数组而言，它是浅拷贝)
     * Arrays.copyOf（浅拷贝）,
     * for
     */
    private static final byte[] buffer = new byte[1024*1024];
    static {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) (i & 0xFF);
        }
    }
    private static long startTime;

    public static void main(String[] args) {
        startTime = System.nanoTime();
        methodFor();
        calcTime("methodFor");

        startTime = System.nanoTime();
        methodClone();
        calcTime("methodClone");

        startTime = System.nanoTime();
        methodArraysCopyOf();
        calcTime("methodArraysCopyOf");

        startTime = System.nanoTime();
        methodSystemArraycopy();
        calcTime("methodSystemArraycopy");
    }

    private static void methodFor() {
        byte[] newBuffer = new byte[buffer.length];
        for(int i=0;i<buffer.length;i++) {
            newBuffer[i] = buffer[i];
        }
    }

    private static void methodClone() {
        byte[] newBuffer = buffer.clone();
    }

    private static void methodArraysCopyOf() {
        byte[] newBuffer = Arrays.copyOf(buffer, buffer.length);
    }

    private static void methodSystemArraycopy() {
        byte[] newBuffer = new byte[buffer.length];
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
    }

    private static void calcTime(String method) {
        long endTime = System.nanoTime();
        System.out.println(method + " cost " +(endTime-startTime)+ " nanosecond");
    }
}