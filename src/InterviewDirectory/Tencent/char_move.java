package InterviewDirectory.Tencent;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/16.
 */
public class char_move {
    //字符移位

    public static  void main(String[]arga)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            String str = sr.nextLine();
            System.out.println(new char_move().uppermoveend(str));
        }
    }
    public String uppermoveend(String str)
    {
        if(str==null||str.equals(""))
            return "";
        char [] ch = str.toCharArray();
        int lastUp = ch.length-1;
        for(int i=ch.length-1;i>=0;i--)
        {
            if(ch[i]>='A'&&ch[i]<='Z')
            {
                char temp = ch[i];
                for(int j=i+1;j<=lastUp;j++)//平移一位
                {
                    ch[j-1] = ch[j];
                }
                ch[lastUp] = temp;
                lastUp--;
            }
        }
        return String.valueOf(ch);

    }

}