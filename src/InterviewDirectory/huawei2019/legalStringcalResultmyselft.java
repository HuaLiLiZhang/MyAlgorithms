package InterviewDirectory.huawei2019;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by huali on 2018/8/15.
 */
public class legalStringcalResultmyselft {
    //测试不通过，只通过83%，没判断合法，还没考虑大于9的数字
//(+ (* 2 3) (^ 4))
//11
    public static void main(String[] args)
    {
        //int temp0 = Integer.parseInt("12");
        //int temp1 = Integer.valueOf("12");
        //System.out.println(temp0);
        //System.out.println(temp1);

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Character> stack = new Stack<>();
        int pre = 0;
        int end = 0;
        int sum = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(isvalid(s.charAt(i)))
            {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)==' ')
                continue;
            else if(s.charAt(i)==')')
            {
                char temp = stack.pop();
                if(temp=='*')
                {
                    sum += pre*end;
                    end = 0;
                }
                if(temp=='+')
                {
                    sum += pre+end;
                    end = 0;
                }
                pre = 0;
                if(!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
            }else if(s.charAt(i)=='^'&&i+1<s.length())
            {
                pre = Integer.valueOf(s.charAt(i+2)-'0')+1;
                i+=2;
                sum += pre;
            }
            else {
                pre = Integer.valueOf(s.charAt(i)-'0');
                if(end==0)
                {
                    end = pre;
                    pre = 0;
                }
            }

        }
        System.out.println(sum);


    }

    private static boolean isvalid(char c) {
        if(c=='('||c=='*'||c=='+')
            return true;
        else
            return  false;
    }













    //public static void main(String[] args)
    //{
    //    Scanner in = new Scanner(System.in);
    //    String s = in.nextLine();
    //    for(int i =0;i<s.length();i++)
    //    {
    //        if(s.charAt(i)==')')
    //        {
    //            int j = i;
    //            while (j>=0&&s.charAt(j)!='(')
    //                j--;
    //            if(j<0)
    //            {
    //                System.out.println(-1);
    //                break;
    //            }
    //            int count = isleft(s, j, i);
    //            s = s.substring(0,j)+count+s.substring(i+1);
    //            i = j+1;
    //        }
    //    }
    //}
    //
    //private static int isleft(String s, int start, int end) {
    //
    //    char temp = s.charAt(start+1);
    //    if(temp=='^')
    //        return s.charAt(start+3)-'0'+1;
    //    int pre = s.charAt(start+3)-'0';
    //    int beh = s.charAt(end-1)-'0';
    //    if(temp=='*')
    //    {
    //        return pre*beh;
    //    }
    //    if(temp=='+')
    //    {
    //        return pre+beh;
    //    }
    //    return -1;
    //}
}