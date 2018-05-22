package InterviewDirectory.NetEase;

import java.util.*;

/**
 * Created by huali on 2018/5/21.
 */
public class twosortmethod {
//    考拉有n个字符串字符串，任意两个字符串长度都是不同的。
// 考拉最近学习到有两种字符串的排序方法：
// 1.根据字符串的字典序排序。例如：
//"car" < "carriage" < "cats" < "doggies < "koala"
//2.根据字符串的长度排序。例如：
//"car" < "cats" < "koala" < "doggies" < "carriage"
//考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
//输入描述:
//输入第一行为字符串个数n(n ≤ 100)
//接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
//
//
//输出描述:
//如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",
//
//如果根据长度排列而不是字典序排列输出"lengths",
//
//如果两种方式都符合输出"both"，否则输出"none"
//
//输入例子1:
//3
//a
//aa
//bbb
//
//输出例子1:
//both

    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int n = sr.nextInt();
            List<String> list = new ArrayList<>();
            String [] str = new String[n];
            for(int i=0;i<n;i++)
            {
                String s = sr.next();
                str[i] = s;
                list.add(s);
            }
            boolean length = true;
            boolean sortabc = true;
            Collections.sort(list);
            for(int i=1;i<n;i++)
            {
                if(str[i].length()<str[i-1].length())
                {
                    length = false;
                    break;
                }


            }
            for(int i=1;i<n;i++)
            {
                if(!list.get(i).equals(str[i]))
                {
                    sortabc = false;
                    break;
                }
            }


            if(sortabc&&length)
                System.out.println("both");
            else if(sortabc)
                System.out.println("lexicographically");
            else if(length)
            {
                System.out.println("lengths");
            }
            else
                System.out.println("none");


        }
        sr.close();

    }
}