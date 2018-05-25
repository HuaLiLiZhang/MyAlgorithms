package InterviewDirectory.neteaseGame;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/25.
 */
public class strencoder {
//    给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。
// 比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。
//输入描述:
//每个测试输入包含1个测试用例
//每个测试用例输入只有一行字符串，字符串只包括大写英文字母，长度不超过10000。
//
//
//输出描述:
//输出编码后的字符串
//
//输入例子1:
//AAAABCCDAA
//
//输出例子1:
//4A1B2C1D2A

    public static void  main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            String str = sr.nextLine();
            String s = "";
            char  chr = str.charAt(0) ;
            int count = 1;
            for(int i=1;i<str.length();i++)
            {
                if(chr==str.charAt(i))
                {
                    count++;
                    chr = str.charAt(i);
                }else {
                    s += ""+count+chr;
                    count =1;
                    chr = str.charAt(i);
                }
            }
            s +=""+count+chr;
            System.out.println(s);
        }
        sr.close();
    }
}