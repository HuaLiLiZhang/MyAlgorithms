package InterviewDirectory.offerTwice;

/**
 * Created by huali on 2018/9/6.
 */
public class DrowColor_1 {
    //一个圆分成n个扇形，用4种颜色上色，要求相邻两个颜色不同，求多少种不同的方法。
    public static void main(String[] args)
    {
        int n = 5;//圆分为几个区域。
        int m = 4;//有几种颜色可选上色
        int count = colornum(n,m);
        System.out.println(count);
    }

    private static int colornum(int n, int m) {
        if(n==1)
            return m;
        if(n==2)
            return m*(m-1);
        if(n==3)
            return m*(m-1)*(m-2);
        else  //在判断最后一种颜色的时候，有两种情况：
            //1.如果倒数第二个和第一个不相同，那么最后一个有(m-2)种情况，去掉这一个对（n-1）个继续
            //2.如果倒数第二个和第一个相同，最后一个有（m-1）中情况，由于倒数第二个和第一个已经绑定，那么就只有（n-2）个继续
            return colornum(n-1,m)*(m-2)+colornum(n-2,m)*(m-1);
    }
}