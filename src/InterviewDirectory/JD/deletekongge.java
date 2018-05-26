package InterviewDirectory.JD;

/**
 * Created by huali on 2018/5/26.
 */
public class deletekongge {
//    给定字符串（ASCII码0-255）数组，
// 请在不开辟额外空间的情况下删除开始和结尾处的空格，
// 并将中间的多个连续的空格合并成一个。例如："   i    am a      little boy.    "，
// 变成"i am a little boy",语言不限，但不要用伪代码作答。
    public static void main(String[]args)
    {
        //String str = "   i    am a      little boy.    ";
        String str = "i am a boy. ";
        char [] ch = str.toCharArray();
        formatString(ch, ch.length);
        //for(int i=0;i<ch.length;i++)
        //{
        //    if(ch[i]==ch[i+1]&&ch[i]==' ')
        //        break;
        //    System.out.print(ch[i]);
        //}
        System.out.println();
    }

    private static void formatString(char[] ch, int length) {
        int count = 0;
        char be = ' ';
        for(int i=0;i<ch.length;i++)
        {
                if(ch[i]==' ')
                {
                    be = ' ';
                    continue;
                }
                else
                {
                    if(count!=0&&be ==' ')
                        System.out.print(' ');
                    char tmp = ch[i];
                    ch[i] = ch[count];
                    ch[count] = tmp;
                    System.out.print(ch[count]);
                    be = tmp;
                    count++;
                }
        }
    }
}