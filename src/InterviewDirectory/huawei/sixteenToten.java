package InterviewDirectory.huawei;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/19.
 */
public class sixteenToten {
    public static  void main(String []args) {
        Scanner sr = new Scanner(System.in);
        //String str =null;
        while (sr.hasNext())
        {
            String str = sr.nextLine();
            int n = Integer.parseInt(str.substring(2), 16);
            System.out.println(n);
        }
        sr.close();
    }
}