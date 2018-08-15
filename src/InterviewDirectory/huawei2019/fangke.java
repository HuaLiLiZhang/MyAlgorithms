package InterviewDirectory.huawei2019;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/15.
 */
public class fangke {
    //public static void main(String[] args) {
    //
    //    Scanner in = new Scanner(System.in);
    //    int[] numbers = new int[8];
    //
    //    String s = in.nextLine();
    //    String[] strs = s.split(",");
    //    int start = Integer.valueOf(strs[0]);
    //    int end = Integer.valueOf(strs[1]);
    //
    //    while (start!=-1) {//注意while处理多个case
    //        start -=12;
    //        end -=12;
    //
    //        if(start<0) start=0;
    //        if(end>8) end=8;
    //
    //        for(int i = start;i<end;i++){
    //            numbers[i]++;
    //        }
    //
    //        s = in.nextLine();
    //        strs = s.split(",");
    //        start = Integer.valueOf(strs[0]);
    //        end = Integer.valueOf(strs[1]);
    //    }
    //
    //    for(int i = 0;i<numbers.length;i++){
    //        System.out.println("["+(i+12)+","+(i+13)+")"+":"+numbers[i]);
    //    }
    //}
    //测试用例:
//12,15
//16,17
//12,20
//-1,-1

//[12,13):2
//[13,14):2
//[14,15):2
//[15,16):1
//[16,17):2
//[17,18):1
//[18,19):1
//[19,20):1

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int []arr = new int[8];
        while (sc.hasNext())
        {
            String[] s = sc.next().split(",");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            if(start==-1&&end ==-1)
                break;
            for(int j = start-12;j<end-12;j++)
            {
                arr[j] +=1;
            }
        }
        for(int i = 0;i<arr.length;i++)
        {
            System.out.println("["+(i+12)+","+(i+13)+"):"+arr[i]);
        }
    }
//12,15
//16,17
//12,20
//-1,-1
//[12,13):2
//[13,14):2
//[14,15):2
//[15,16):1
//[16,17):2
//[17,18):1
//[18,19):1
//[19,20):1
}