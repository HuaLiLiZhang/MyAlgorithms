package InterviewDirectory.kuaishou2019;

import java.util.*;

/**
 * Created by huali on 2018/9/10.
 */
public class aChuYibXunhuanxiaoshu {

    //求a/b的小数表现形式。如果可以整数b则不需要小数点。
    // 如果是有限小数，则可以直接输出，
    // 如果是无限循环小数，则需要吧小数循环的部分用（）括起来

    //例如：
    //10 1
    //10
    //1 2
    //0.5
    //1 3
    //0.(3)
    //1 6
    //0.1(6)
    //1 7
    //0.(142857)
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int []arr = new int[1000000];
        List<String> list = new ArrayList<>();
        list.add(""+a/b);

        a = a%b;
        if(a!=0)
        {
            list.add(".");
        }
        int c,d;
        int n = 0;
        Arrays.fill(arr,-1);
        while (true)
        {
            if(a==0)
            {
                c = n;
                d = 0;
                break;
            }

            if(arr[a]!=-1)
            {
                c = arr[a];  //c为开始循环的位置
                d = n-c;   //d为循环小数的长度
                break;
            }
            arr[a] = n;
            n++;
            list.add(""+(a*10/b));
            a = (a*10)%b;

        }

        if(c+2<list.size())  //前面两个数是list中的一个整数部分，一个小数点。
        {
            list.add(c+2,"(");
            list.add(")");
        }
        for(int i = 0;i<list.size();i++)
        {
            System.out.print(list.get(i));
        }


    }

//    d第二种解法
    /*public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int numerator = sc.nextInt();
        int denominator = sc.nextInt();
        String res = fractionToDecimal(numerator,denominator);
        System.out.println(res);

    }

    private static String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0)
        {
            //System.out.println(0);
            return 0+"";
        }
        String res = "";
        if(numerator*denominator<0)
            res +="-";

        numerator= Math.abs(numerator);
        denominator  = Math.abs(denominator);
        res += ""+(numerator/denominator);
        if(numerator%denominator==0)
        {
            //System.out.println(res);
            return res;
        }
        res +=".";
        int r = numerator % denominator;
        List<Integer> m  = new ArrayList<>(1000);
        for(int i = 0;i<1000;i++)
        {
            m.add(0);
        }
        while (r!=0)
        {
            if(m.get(r)!=0)
            {
                res = res.substring(0,m.get(r))+"("+res.substring(m.get(r))+")";
                break;
            }
            m.set(r, res.length())  ;
            r*=10;
            res += ""+ (r/denominator);
            r %=  denominator;
        }
        return res;

    }*/
}