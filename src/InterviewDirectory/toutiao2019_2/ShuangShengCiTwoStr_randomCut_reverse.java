package InterviewDirectory.toutiao2019_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/25.
 */
public class num3 {
    //

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