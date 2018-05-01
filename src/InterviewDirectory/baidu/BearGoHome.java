package InterviewDirectory.baidu;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/1.
 */
public class BearGoHome {
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        int num = sr.nextInt();
        String s = "";
        int [] x = new int[num];
        int [] y = new int[num];
        int [] z = new int[num];

        for(int i=0;i<num;i++)
        {
            s += sr.next();
            x[i] = sr.nextInt();
            y[i] = sr.nextInt();
            z[i] = sr.nextInt();
        }
        char [] ch = s.toCharArray();
        double Max = 0;
        for(int i =0;i<num;i++)
        {
            for(int j = i+1;j<num;j++)
            {
                for(int k = j+1;k<num;k++)
                {
                    if((ch[i]!=ch[j]&&ch[i]!=ch[k]&&ch[j]!=ch[k])||(ch[i]==ch[j]&&ch[i]==ch[k]))
                    {
                        if(isSan(x, y, z, i, j, k))
                        {
                            double area = Calarea(x, y, z, i, j, k);
                            if(area>Max)
                                Max = area;
                        }
                    }

                }
            }
        }
        System.out.println(String.format("%.5f", Max));
    }

    public static boolean isSan(int []x, int []y, int []z, int i, int j, int k)
    {
        double a = L3(x, y, z, i ,j);
        double b = L3(x, y, z, i ,k);
        double c = L3(x, y, z, k ,j);
        if(a<(b+c)&&b<(a+c)&&c<(a+b))
            return true;
        return false;

    }

    public static double L3(int []x, int []y, int []z, int i, int j )
    {
        return Math.sqrt(((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j])+(z[i]-z[j])*(z[i]-z[j])));
    }

    public static double Calarea(int []x, int []y, int []z, int i, int j, int k)
    {
        double a = L3(x, y, z, i, j);
        double b = L3(x, y, z, i, k);
        double c = L3(x, y, z, k, j);

        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

}