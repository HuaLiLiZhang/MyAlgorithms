package InterviewDirectory.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by huali on 2018/4/17.
 */
public class highgrade {
    //老师想知道从某某同学当中，分数最高的是多少，
    // 现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
    //输入描述:
    //输入包括多组测试数据。
    //每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
    //学生ID编号从1编到N。
    //第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
    //接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
    //当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

    public static void main(String[] args)throws Exception
    {
        Scanner sr = new Scanner(System.in);
        int []data = new int [2];
        do{
            data[0] = sr.nextInt();
            data[1] = sr.nextInt();
            ArrayList<Integer> array = new ArrayList<>();
            for(int i =0;i<data[0];i++)
            {
                array.add(sr.nextInt());
            }

            int num =0;
            char a;
            int b,c;
            while (num<data[1])
            {
                a = sr.next().charAt(0);
                b = sr.nextInt();
                c = sr.nextInt();
                if(a=='Q')
                {
                    int start ,end;
                    if(b<=c)
                    {
                        start = b-1;
                        end = c-1;
                    }else {
                        start = c-1;
                         end = b-1;
                    }
                    int max = array.get(start);
                    for(int index = start; index <=end;index++)
                    {
                        if(array.get(index)>max)
                            max = array.get(index);
                    }
                    System.out.println(max);
                }
                if(a=='U')
                {
                    int index1 = b-1;
                    int newvalue = c;
                    array.set(index1, newvalue);
                }
                sr.nextLine();
                num++;
            }
        }while (sr.hasNext());
        sr.close();
    }
}