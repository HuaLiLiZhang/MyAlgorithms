package InterviewDirectory.didi2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/18.
 */
public class yingyuwordcorrectwrong {
    //英文单词拼写的时候可能会出现拼写错误的情况。下面的题目，我们尝试实现拼写错误推荐的功能。
    //字串编辑距离：是指字串间相似度的常见手段。
    //1.字串编辑距离是指字串操作，吧字符串A换成字符串B所需要的手段。
    //删除，修改，插入字符。
    //3。并利用相似度进行排序。得分越高，认为相似度越高。
    //只设计26个英文字符。不区分大小写。
    //删除：3分，插入 3分，修改：两个分组内修改1分，分组间修改2分

    //slep slap sleep step shoe shop snap slep
    //slep
    //slap
    //step
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String [] str = s.split(" ");
        //slep slap sleep step shoe shop snap slep
        String [] ste = {"slep","slap" ,"step" };
        for(String s0 : ste)
        {
            System.out.println(s0);
        }
    }
}