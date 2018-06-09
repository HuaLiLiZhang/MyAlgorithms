package InterviewDirectory.JD;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by huali on 2018/5/28.
 */
public class thelongestcommon_kuohao_sequence {
    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            //int count =0;
            Set<String> set = new HashSet<>();
            String str = sr.nextLine();

            for(int i=0;i<str.length();i++)
            {
                StringBuilder s1 = new StringBuilder();
                s1.append(str.substring(0,i));
                s1.append(str.substring(i+1,str.length()));
                for(int j=0;j<s1.length();j++)
                {
                    StringBuilder s2 = new StringBuilder();
                    s2.append(s1.subSequence(0,j));
                    s2.append(str.charAt(i));
                    s2.append(s1.subSequence(j,s1.length()));
                    if(isvalid(s2.toString()))
                    {
                        //count++;//有重复的字符串。
                        set.add(s2.toString());
                    }
                }
            }
            System.out.println(set.size()-1);

        }
        sr.close();
    }

    private static boolean isvalid(String s2) {
        int count =0;
        for(int i=0;i<s2.length();i++)
        {
            if(s2.charAt(i)==')')
            {
                count++;
            }
            else
                count--;
            if(count>0)
                return false;
        }
        return count==0;
    }
}