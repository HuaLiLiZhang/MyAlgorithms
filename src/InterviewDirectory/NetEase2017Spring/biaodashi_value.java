package InterviewDirectory.NetEase2017Spring;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by huali on 2018/5/5.
 */
public class biaodashi_value {
    public static void main(String[] args) {
        Scanner sr=new Scanner(System.in);
        String s = sr.next();
        char[] ch = s.toCharArray();
        int sum = ch[0] -'0';
        for(int i=1;i<s.length()-1;i++)
        {
            int tmp = ch[i+1]-'0';
            if(ch[i]=='+')
            {
                sum = sum+tmp;
            }
            if(ch[i]=='-')
            {
                sum = sum-tmp;
            }
            if(ch[i]=='*')
            {
                sum = sum*tmp;
            }
        }
        System.out.println(sum);
        sr.close();
    }
    //
    //private static void putNumtostack(Stack<Character> stack, int val2) {
    //    int less = 0;
    //    while (val2!=0)
    //    {
    //        less = val2%10;
    //        stack.push();
    //    }
    //}
    //
    //private static int getnextnum(Stack<Character> stack)
    //{
    //    int val = 0;
    //    int temp=1;
    //   while (stack.peek()!='+'||stack.peek()!='-'||stack.peek()!='*')
    //   {
    //       int c = stack.pop()-'0';
    //       val+=c*temp;
    //       temp*=10;
    //   }
    //   return val;
    //}

}