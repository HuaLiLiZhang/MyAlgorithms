package InterviewDirectory.NetEase;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/2.
 */
public class reverse {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);

        while (sr.hasNext())
        {
            int n = sr.nextInt();
            String s = "";
            if(n%2==0)
            {
                for (int i = 0; i < n; i++)
                {
                    if(i%2==0)
                    {
                        int num = sr.nextInt();
                        s += String.valueOf(num);
                    }
                    else {
                        int num = sr.nextInt();
                        s = String.valueOf(num)+s;
                    }
                }
            }
            else {
                for (int i = 0; i < n; i++)
                {
                    if(i%2!=0)
                    {
                        int num = sr.nextInt();
                        s += String.valueOf(num);
                    }
                    else {
                        int num = sr.nextInt();
                        s = String.valueOf(num)+s;
                    }
                }
            }
            char[] ch = s.toCharArray();
            for(int j =0;j<n;j++)
            {
                if(j==n-1)
                    System.out.print(ch[j]);
                else
                    System.out.print(ch[j]+" ");
            }
        }
        sr.close();
    }
}