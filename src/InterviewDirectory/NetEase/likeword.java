package InterviewDirectory.NetEase;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/21.
 */
public class likeword {
//    小易喜欢的单词具有以下特性：
//1.单词每个字母都是大写字母
//2.单词没有连续相等的字母
//3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。
//例如：
//小易不喜欢"ABBA"，因为这里有两个连续的'B'
//小易不喜欢"THETXH"，因为这里包含子序列"THTH"
//小易不喜欢"ABACADA"，因为这里包含子序列"AAAA"
//小易喜欢"A","ABA"和"ABCBA"这些单词
//给你一个单词，你要回答小易是否会喜欢这个单词。
//输入描述:
//输入为一个字符串，都由大写字母组成，长度小于100
//
//
//输出描述:
//如果小易喜欢输出"Likes",不喜欢输出"Dislikes"
//
//输入例子1:
//AAA
//
//输出例子1:
//Dislikes


    //使用正则表达式，简则666的不行

    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            String  word = sr.nextLine();
            if(isAllUpCase(word) && isConEql(word) && isThrEql(word))
            {
                System.out.println("Likes");
            }
            else {
                System.out.println("Dislikes");
            }

        }
        sr.close();

    }

    private static boolean isConEql(String word) {
        //2.单词没有连续相等的字母
        return !word.matches(".*(.)(\\1).*");
    }

    private static boolean isThrEql(String word) {
//3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。
        return !word.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
    }

    //
    //word.matches(".*(.).*(.)(.*\\1)(.*\\2).*")
    //简单分析：
    //首先这里很明显是正则表达式
    //    .*   表示0或多个字母
    //（.） 是分组表达式，分组之后括号内的子串为一个整体，这里取一个大写字母
    //（.*\\1）当一个正则表达式被分组之后，每一个组会自动被赋予一个组号，该组号可以代表该组的表达式。
    // 分组的编制规则：从左至右，以左括号为标志，第一个分组为1，第二个分组为2，以此类推。
    // 反向引用提供了查找重复字符组的方便方法。它可被认为是再次匹配同一个字符串的快捷指令。
    // 所以我认为括号\\1表示存在一个字母和前面第一组内容相同。
    //  (.*\\2)   同理，都是再找符合XYXY规则的形式子串。

    private static boolean isAllUpCase(String word) {
        //单词每个字母都是大写字母
        return word.matches("[A-Z]+");
    }


    //题目测试用例的漏洞
    //public static void main(String []args)
    //{
    //    Scanner sr = new Scanner(System.in);
    //    while (sr.hasNext())
    //    {
    //        String  str = sr.nextLine();
    //        char [] ch = str.toCharArray();
    //        int i=0;
    //        for(;i<ch.length;i++)
    //        {
    //            if(ch[i]>'Z'&&ch[i]<'A')
    //            {
    //                System.out.println("Dislikes");
    //                break;
    //            } else  if(i<ch.length-1&&ch[i]==ch[i+1])
    //            {
    //                System.out.println("Dislikes");
    //                break;
    //            }
    //
    //        }
    //        if(i==ch.length)
    //        {
    //            System.out.println("Likes");
    //        }
    //
    //
    //    }
    //    sr.close();
    //
    //}


//真正的解答。
//import java.util.*;
// 
//public class Main{
//    public static boolean judge(String s){
//        char [] chars = s.toCharArray();
//        char tmp = 0;
//        for (char c : chars){
//            if (c >'Z' || c < 'A') return false;
//            if (tmp == c) return false;
//            tmp = c;
//        }
//        Set<Character> charSet = new HashSet<>();
//        int count;
//        for (int i = 0; i < chars.length; i++){
//            charSet.clear();
//            count = 1;
//            for (int j = i + 1; j < chars.length; j++){
//                if (chars[i] == chars [j])
//                {
//                    count++;
//                    if (count > 3)
//                          return false;
//                }else if (count > 1 && charSet.contains(chars[j])) return false;
//                else if (count == 1) charSet.add(chars[j]);
// 
//            }
//        }
//        return true;
//    }
//    public static void  main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s = sc.nextLine();
//            System.out.println(judge(s)?"Likes":"Dislikes");
//        }
//        sc.close();
//    }
//}
}