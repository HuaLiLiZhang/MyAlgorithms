package InterviewDirectory.regexDemo;

/**
 * Created by huali on 2018/5/19.
 */
public class regexDemo1 {

    public static void main(String[]args)
    {
        String qq = "213412343";
        //    之前一般判断一串数字是否符合QQ标准
        //checkQQ(qq);
        //    使用正则表达式的判断。
        //String regex = "[1-9][0-9]{4,14}";
        //boolean b = qq.matches(regex);
        //System.out.println(qq +":"+b);


        /**
         * 正则表达式对字符串的常见操作：
         * 1.匹配：
         *      其实使用的就是string类中的matches方法；
         * 2.切割
         *      其实使用的是String类的split方法；
         *
         * 3.替换
         *      其实使用的是String类中的replaceAll方法；
         * 4.获取
         */
        functiondemo_1();

    }

    private static void functiondemo_1() {
    //    演示匹配
        String str = "13838453849";

    }

    private static void checkQQ(String qq) {
        int length = qq.length();
        if(length>=5&&length<=15)
        {
            if(!qq.startsWith("0"))
            {
                try {
                    long l = Long.parseLong(qq);
                    System.out.println("正确");
                }catch (NumberFormatException e)
                {
                    System.out.println(qq+"含有非法字符");
                }
            }else
                System.out.println("不能以0开头");
        }
        else {
            System.out.println(qq+"长度错误");
        }
    }



}
