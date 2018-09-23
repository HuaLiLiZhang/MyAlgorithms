package InterviewDirectory.didi2019;

/**
 * Created by huali on 2018/9/23.
 */
public class consistOf100 {

    //'9', '+', '8', '+', '7', '+', '6', '+', '5', '+', '4', '+', '3', '+',
    //'2', '+', '1'数的组合等于100，加号可以为加号可以为减号，也可以不加，直接98,987等。
    static char operator[] = new char[8];
    static char expre[] = new char[]
            { '9', '+', '8', '+', '7', '+', '6', '+', '5', '+', '4', '+', '3', '+',
                    '2', '+', '1' };

    public static void main(String[] args)
    {
        fun(0);
    }

    public static void fun(int n)
    {
        if (8 == n)
            handle(100);
        else
        {
            operator[n] = '+';
            expre[n * 2 + 1] = operator[n];   //一步一步的递归，继续+
            fun(n + 1);
            operator[n] = '-';               //+不可以等于100，退回一步变为-，继续递归+-
            expre[n * 2 + 1] = operator[n];
            fun(n + 1);
            operator[n] = '*';                 //+，-不可以等于100，退回一步变为*，继续递归，+-*
            expre[n * 2 + 1] = operator[n];
            fun(n + 1);
        }
    }

    private static void handle(int n)   //如果n 等于8，即8个符号已经完成，看是否和为100，那么要打印出来。
    {
        StringBuffer sb = new StringBuffer();
// 将乘法替换成空格
        for (int i = 0; i < expre.length; i++)
            if (expre[i] != '*')
                sb.append(expre[i]);
        String expression = sb.toString();
// 分割等式, 先根据运算符分割
        String[] num = expression.split("[+-]");
// 根据数字,分割出其中的运算符
        String[] operator = expression.split("[1-9]");

        int sum = Integer.parseInt(num[0]);

        for (int i = 0, j = 1; i < operator.length; i++)
        {
            if (operator[i].equals("+"))
                sum += Integer.parseInt(num[j++]);
            if (operator[i].equals("-"))
                sum -= Integer.parseInt(num[j++]);
        }

        if (sum == n)
            System.out.println(expression + " = " + n);
    }
}