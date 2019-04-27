package InterviewDirectory.nowcode_middle.String1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by huali on 2018/10/10.
 */
public class concatzuixiaostring {
    //字符串拼接最小，满足最小，可以使用str1+str2<str2+str1,则str1在前面，用String的方法comparaTo
    public static void main(String[] args)
    {
        String []str1 = {"ba", "b","a","ab"};

        Arrays.sort(str1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String temp = "";
        for(String s : str1)
            temp += s;
        System.out.println(temp);

    }
}