package InterviewDirectory.NetEase2017Spring;

import java.util.*;

/**
 * Created by huali on 2018/5/6.
 */
public class rememberWord {
//    小易参与了一个记单词的小游戏。游戏开始系统提供了m个不同的单词，
// 小易记忆一段时间之后需要在纸上写出他记住的单词。
// 小易一共写出了n个他能记住的单词，如果小易写出的单词是在系统提供的，
// 将获得这个单词长度的平方的分数。注意小易写出的单词可能重复，但是对于每个正确的单词只能计分一次。
//输入描述:
//输入数据包括三行：
// 第一行为两个整数n(1 ≤ n ≤ 50)和m(1 ≤ m ≤ 50)。以空格分隔
// 第二行为n个字符串，表示小易能记住的单词，以空格分隔，每个单词的长度小于等于50。
// 第三行为m个字符串，系统提供的单词，以空格分隔，每个单词的长度小于等于50。
//
//
//输出描述:
//输出一个整数表示小易能获得的分数
//
//输入例子1:
//3 4 apple orange strawberry strawberry orange grapefruit watermelon
//
//输出例子1:
//136

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //表示小艺能记住的单词数。
        int m = sc.nextInt();
        Set<String>  rember = new HashSet<String>();
        for(int i =0;i<n;i++)
        {
            rember.add(sc.next());
        }
        Set<String> system = new HashSet<>();
        for(int i =0;i<m;i++)
        {
            system.add(sc.next());
        }
        int sum = 0;
        Iterator<String> it = rember.iterator();
        while (it.hasNext())
        {
            String s = it.next();
            if(system.contains(s))
            {
                int length = s.length();
                sum +=length*length;
            }
        }
        System.out.println(sum);

    }
}