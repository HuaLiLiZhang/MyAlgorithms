package InterviewDirectory.souhu2019;

import java.util.*;

/**
 * Created by huali on 2018/9/13.
 */
public class brotherString {
    //兄弟串的定义，通过交换两个字符得到的字符串。
    //ab ab
    //0
    //ab ba
    //1
    //aa aa
    //1
    //aaaaabc aaaaacb
    //1
    //aaaaa aaaaa
    //1
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            String s1 = s.split(" ")[0];
            String s2 = s.split(" ")[1];
            char [] c1 = s1.toCharArray();
            char [] c2 = s2.toCharArray();
            boolean flag = isbrotherchar(c1,c2);
            if(flag)
                System.out.println(1);
            else
                System.out.println(0);
        }

    }

    private static boolean isbrotherchar(char[] c1,char[]c2) {
        List<Integer> list =new ArrayList<>();
        if(c1.length!=c2.length)
            return false;
        for(int i = 0;i<c1.length;i++)
        {
            if(c1[i]!=c2[i])
                list.add(i);
        }
        if(list.size()==2)
        {
            if(c1[list.get(0)]==c2[list.get(1)]&&c1[list.get(1)]==c2[list.get(0)])
                return true;
            else
                return false;
        }
        else {
            if(list.size()==0)
            {
                HashMap<Character,Integer> map = new HashMap<>();
                for(char c :c1)
                {
                    if(map.containsKey(c))
                        return true;
                    map.put(c,1);
                }
                return false;
            }
        }
        return false;
    }

    //public static boolean isIncludeSameChar(String str1, String str2) {
    //    boolean flag = true;
    //
    //    if (str1.length() != str2.length()) {
    //        flag = false;
    //    } else {
    //        char[] str1Arr = str1.toCharArray();
    //        Arrays.sort(str1Arr);
    //        char[] str2Arr = str2.toCharArray();
    //        Arrays.sort(str2Arr);
    //        for (int i = 0; i < str2Arr.length; i++) {
    //            if (str2Arr[i] == str1Arr[i]) {
    //                continue;
    //            } else {
    //                flag = false;
    //            }
    //        }
    //    }
    //    return flag;
    //}
    /*static boolean Judge(char[] a,char[] b) {
        int i=0, j=0;
        char temp1, temp2;
        if (a.length != b.length) {
            return false;
        }

        for (i = 0; i < a.length - 1; i++) {
            for (j = 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp1 = a[i];
                    a[i] = a[j];
                    a[j] = temp1;
                }

                if (b[i] > b[j]) {
                    temp2 = b[i];
                    b[i] = b[j];
                    b[j] = temp2;
                }
            }



        for (i = 0; i < a.length; i++) {
            if (a[i] != a[j]) {
                return false;
                }
            }
        }
        return true;
    }*/
}