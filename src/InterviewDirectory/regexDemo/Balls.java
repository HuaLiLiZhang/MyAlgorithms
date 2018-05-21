package InterviewDirectory.regexDemo;

/**
 * Created by huali on 2018/5/20.
 */
public class Balls {
    public static void main(String []args)
    {
        int sum = calcDistance(100,90,80,70);
        System.out.println(sum);
    }
    public static int calcDistance(int A, int B, int C, int D) {
        // write code here
        double sum = (A+B+C+D);
        for(double i=A;i>0;)
        {
            double temp = i/2;
            sum = sum+2*temp;
            i = temp;
        }

        for(double i=B;i>0;)
        {
            double temp = i/2;
            sum = sum+2*temp;
            i = temp;
        }for(double i=C;i>0;)
        {
            double temp = i/2;
            sum = sum+2*temp;
            i = temp;
        }
        for(double i=D;i>0;)
        {
            double temp = i/2;
            sum = sum+2*temp;
            i = temp;
        }

        return (int) Math.ceil(sum);
    }
}