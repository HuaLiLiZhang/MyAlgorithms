package InterviewDirectory.haoweilai2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/8/28.
 */
public class replacesubString {

    //替换String s中的子串s1为s2。
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String s3 = in.nextLine();
        System.out.println(replacesubstr(s1,s2,s3));

        }
        public static String replacesubstr(String s1,String s2,String s3){
            return s1.replaceAll(s2,s3);
        }

}