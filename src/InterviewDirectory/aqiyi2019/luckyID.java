package InterviewDirectory.aqiyi2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/15.
 */
public class luckyID {


        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String number = in.nextLine();

            if(number.length()!=6){
                System.out.println("error");
                return;
            }

            int a = number.charAt(0)-'0';
            int b = number.charAt(1)-'0';
            int c = number.charAt(2)-'0';
            int d = number.charAt(3)-'0';
            int e = number.charAt(4)-'0';
            int f = number.charAt(5)-'0';

            int sumA = a+b+c;
            int sumB = d+e+f;

            int change = sumA-sumB;

            if(change>0){
                if(decrese9(a, b, c)-sumB<=0 || sumA-add9(d, e, f)<=0){
                    System.out.println(1);
                }else if(decrese99(a, b, c)-sumB<=0 || sumA-add99(d, e, f)<=0){
                    System.out.println(2);
                }else{
                    System.out.println(3);
                }
            }else if(change<0)
            {
                if(add9(a, b, c)-sumB>=0 || sumA-decrese9(d, e, f)>=0){
                    System.out.println(1);
                }else if(add99(a, b, c)-sumB>=0 || sumA-decrese99(d, e, f)>=0){
                    System.out.println(2);
                }else{
                    System.out.println(3);
                }
            }
            else {
                System.out.println(0);
            }

        }

        //将一个最小的数变为9，返回改变之后的三个数的和
        private static int add9(int a,int b,int c){
            int min = a>b?b:a;
            min = min>c?c:min;
            return a+b+c-min+9;
        }


        //将最大的一个数变为0，返回改变之后的三个数的和
        private static int decrese9(int a,int b,int c){
            int max = a>b?b:a;
            max = max>c?max:c;
            return a+b+c-max;
        }
        //将最大的两个数变为0，返回改变之后的三个数的和
        private static int decrese99(int a,int b,int c){
            int min = a>b?b:a;
            min = min>c?c:min;
            return min;
        }
        //将最小的两个数变为9，返回改变之后的三个数的和
        private static int add99(int a,int b,int c){
            int max = a>b?b:a;
            max = max>c?max:c;
            return max+18;
        }
}