package InterviewDirectory.NetEase2017Spring;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huali on 2018/5/5.
 */
public class set {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double w=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt(),z=sc.nextInt();

        Set<Double> set=new HashSet<Double>();

        for(double i=w;i<=x;i++)
        {
            for(double j=y;j<=z;j++)
            {
                if(!set.contains(i/j))
                set.add(i/j);
            }
        }
        System.out.println(set.size());
        sc.close();
        }

}