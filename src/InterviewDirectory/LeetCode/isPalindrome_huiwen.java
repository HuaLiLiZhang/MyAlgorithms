package InterviewDirectory.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huali on 2018/7/6.
 */
public class isPalindrome_huiwen {
// Given a string, determine if it is a palindrome,
// considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama"is a palindrome.
//"race a car"is not a palindrome.
    public boolean isPalindrome(String s) {
        if(s.equals("")||s.length()<=0)
            return true;

        s = s.replaceAll("\\W","");
        s = s.toUpperCase();
        int start = 0;
        int end = s.length()-1;


        while (start<end)
        {

            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[]args)
    {
        isPalindrome_huiwen is = new isPalindrome_huiwen();
        boolean re = is.isPalindrome("1， a. 1");
        System.out.println(re);
    }
}