package InterviewDirectory.toutiao2019_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/25.
 */
public class ShuangShengCiTwoStr_randomCut_reverse {
    //题目描述：双生词满足如下条件的两个字符串：（假如两个字符串分别为S和S'）
//    1.字符串S和S'长度相同
//    2.将字符串S首尾相连，再选一个位置切开，顺时针或逆时针能够得到字符串S'
//    容易得到，若S和S'为双生词，则s'和S也为双生词。给定一批仅由英文字母组成的字符串，询问他们之中是否存在双生词。

//    首先给出测试组数t，表示总共有多少数据。
//    对于每组数据，第一行为一个整数n，表示一共有多少个字符串，接下来的n行，每一行表示一个字符串

//    若存在双生词则输出：Yeah，否则输出Sad



//思路解析：S和S’字符串，将S'字符串复制一个加上变成S'S'，然后拿S和S'S'进行字符串匹配，或者拿S和（S'的逆序）'S'S进行字符串匹配
////helloworld
////hdlrowollehdlrowolle  或者elloworldhelloworldh进行匹配。




//测试结果：
//3
//2
//helloworld
//hdlrowolle
//Yeah
//2
//helloworld
//worldhello
//Yeah
//2
//abcde
//acbde
//Sad

//2
//2
//ggsd
//sfgfdgg
//Sad
//3
//asdfg
//dfgas
//gfdsa
//Yeah
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++)
        {
            int m = sc.nextInt();
            sc.nextLine();
            StringBuffer s = new StringBuffer();
            List<StringBuffer> list = new ArrayList<>();
            for(int j =  0;j<m;j++)
            {
                s.append(sc.nextLine());
                list.add(s);
                s = new StringBuffer();
            }
            boolean flag = false;
            for(int k = 0;k<m;k++)
            {
                StringBuffer stemp = list.get(k);
                for(int j = k+1;j<m;j++)
                {
                    StringBuffer stemp1 = list.get(j);
                    if(ifshaungshengci(stemp,stemp1)||ifshaungshengci(stemp,stemp1.reverse()))
                    {
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
            if(flag)
                System.out.println("Yeah");
            else
                System.out.println("Sad");
        }
    }

    private static boolean ifshaungshengci(StringBuffer s1, StringBuffer s2) {
        StringBuffer stemp = new StringBuffer();
        stemp.append(s2);
        stemp.append(s2);
        int [] next = new int[s1.length()];
        int p = 2;
        int cn = 0;
        next[0] = -1;
        next[1] = 0;
        while (p<s1.length())
        {
            if(s1.charAt(p-1)==s1.charAt(cn))
            {
                next[p++] = ++cn;
            }else if(cn>0)
            {
                cn = next[cn];
            }else
            {
                next[p++] = 0;
            }
        }

        int i = 0,j=0;
        while (i<s1.length()&&j<stemp.length())
        {
            if(s1.charAt(i)==stemp.charAt(j))
            {
                j++;
                i++;
            }else if(next[i]==-1)
            {
                j++;
            }else
            {
                i = next[i];
            }
        }
        return i==s1.length();

    }

}