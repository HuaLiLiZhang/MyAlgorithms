package InterviewDirectory.NetEase;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/2.
 */
public class colorStown {
//    小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。现在有一个给定的字符串s,s中每个字符代表小易的某个砖块的颜色。小易想把他所有的砖块排成一行。如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。(如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
//例如: s = "ABAB",那么小易有六种排列的结果:
//"AABB","ABAB","ABBA","BAAB","BABA","BBAA"
//其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。

    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        String s = sr.nextLine();
        int i =0;
        //for(;i<50;i++)
        //{
        //    s += sr.next();
        //}
        char [] ch = s.toCharArray();
        Arrays.sort(ch);
        i = 1;
        int count =0;
        while (i<ch.length&&ch[i]>='A'&&ch[i]<='Z')
        {
            if(ch[i]!=ch[i-1])
                count ++;
            i++;
        }
        if(count>=2)
            System.out.println(0);
        else
            System.out.println(count==0?1:2);
    }
}