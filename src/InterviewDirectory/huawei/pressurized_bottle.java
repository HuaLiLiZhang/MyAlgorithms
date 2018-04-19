package InterviewDirectory.huawei;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/19.
 */
public class pressurized_bottle {
    public static void main(String []argz)
    {
        Scanner sr = new Scanner(System.in);
        int num ,count, remain, shang;
        int i=0;
        while (sr.hasNextInt())
        {
            i++;
            num = sr.nextInt();
            if(num<=0||num>100||i>10)
                break;
            int n = drinknum(num);
            System.out.println(n);

        }
        sr.close();


    }
    public static  int drinknum(int num)
    {
        int count=0;
        int remain=0;
        int shang = 0;
        while (num>=0)
        {
            count += shang;
            if(num==2)
            {
                count+=1;
                break;
            }
            shang=num/3;
            remain = num%3;
            num = shang + remain;
            if(shang==0)
                break;
        }
        return count;
    }
}
