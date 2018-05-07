package InterviewDirectory.huawei2016;

import java.util.*;

/**
 * Created by huali on 2018/5/7.
 */
public class charSet {
//    输入一个字符串，求出该字符串包含的字符集合
//
//输入描述:
//每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
//
//
//输出描述:
//每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
//
//输入例子1:
//abcqweracb
//
//输出例子1:
//abcqwer
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            Set<String> set = new LinkedHashSet<>();
            String s = sr.next();
            char [] ch = s.toCharArray();
            for(int i=0;i<ch.length;i++)
            {
                set.add(String.valueOf(ch[i]));
            }
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext())
            {
                System.out.print(iterator.next());
            }
            System.out.println();
        }
        sr.close();
    }
}