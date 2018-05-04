package InterviewDirectory.NetEase2017Spring;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/4.
 */
public class GoToCompany {
    public static void main(String []args)
    {
        Scanner sr =new Scanner(System.in);
        while (sr.hasNext())
        {
            int numtaix = sr.nextInt();
            int []x = new int[numtaix];
            int []y = new int[numtaix];
            for(int i =0;i<numtaix;i++)
            {
                x[i] = sr.nextInt();
            }
            for(int i =0;i<numtaix;i++)
            {
                y[i] = sr.nextInt();
            }

            int xcompany = sr.nextInt();
            int ycompany = sr.nextInt();
            int walkTime = sr.nextInt();
            int taxitime = sr.nextInt();



            int lengthmaxi = calNearTaci(x, y, numtaix, walkTime, taxitime, xcompany,ycompany);
            int lengthwalk = (Math.abs(xcompany)+Math.abs(ycompany))*walkTime;
            int end = lengthmaxi>lengthwalk?lengthwalk:lengthmaxi;
            System.out.println(end);


        }
        sr.close();
    }
    public static int calNearTaci(int []x, int []y, int n, int walkTime, int taxitime, int xcompany,int ycompany)
    {
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++)
        {
            int minxy = (Math.abs(x[i]-xcompany)+Math.abs(y[i]-ycompany))*taxitime+
                    (Math.abs(x[i])+Math.abs(y[i]))*walkTime;
            if(minxy<min)
            {
                min = minxy;
            }
        }
        return min;
    }
}