package InterviewDirectory.netEASe2017;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/9.
 */
public class scan {

public static void main(String []args) {
    Scanner sr = new Scanner(System.in);
    while (sr.hasNext())
    {
        int result = 0;
        int i = sr.nextInt();
        switch (i)
        {
            case 1:
                result = result+i;
            case 2:
                result = result+i*2;
            case 3:
                result = result +i*3;

        }
        System.out.println(result);
    }
    sr.close();
    }

}