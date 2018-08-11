package InterviewDirectory.pingduoduo2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/7/22.
 */
public class pingduoduohuowu {
    public static void main(String[] args)
    {
        //Scanner sc = new Scanner(System.in);
        //List<Integer> list = new ArrayList<>();
        //int count = 0;
        //while (sc.hasNext())
        //{
        //    int s = sc.nextInt();
        //    list.add(s);
        //    if(s==100)
        //    {
        //        count++;
        //        list.remove(list.size()-1);
        //    }
        //}
        //sc.close();
        //
        //int g = count/3;
        //int yu = count%3;
        //while (yu--!=0)
        //    list.add(100);
        //Collections.sort(list);
        //while (list.size()!=0)
        //{
        //    int i = list.size()-2;
        //    int first = list.get(i+1);
        //    while (i>=0)
        //    {
        //        int second = list.get(i);
        //        if(first+second<=300)
        //        {
        //            g++;
        //            list.remove(list.size()-1);
        //            list.remove(i);
        //            break;
        //        }
        //        i--;
        //    }
        //    if(i<0)
        //    {
        //        list.remove(list.size()-1);
        //        g++;
        //    }
        //}
        //System.out.println(g);

        huowu2();
    }


    public static void huowu2() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str= s.split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<str.length;i++){
            list.add(Integer.valueOf(str[i]));
        }

  /* for(Integer l:list)
     System.out.println(l);*/
        Collections.sort(list);
        int i=0;
        int j=list.size()-1;
        int num=0;
        //没考虑到都是100的情况。
        while(i<j){
            if(list.get(i)+list.get(j)>300){
                num++;
                j--;
            }
            if(list.get(i)+list.get(j)<=300){
                num++;
                j--;
                i++;
            }
        }
        if(i==j){
            num++;
        }
        System.out.println(num);
    }
}