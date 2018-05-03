package InterviewDirectory.NetEase;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/2.
 */
public class Independent {
    //小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
    // 一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
    // 当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。
    // 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
    public static void main(String []args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            int houseRenting = sr.nextInt();
            int hasfruit = sr.nextInt();
            int hasmoney = sr.nextInt();
            int priceeverfruit = sr.nextInt();
            int counttime = 0;
            if(hasmoney>=hasfruit*houseRenting)
            {
                counttime = hasfruit+(hasmoney-hasfruit*houseRenting)/(houseRenting+priceeverfruit);
            }
            else
            {
                counttime = hasmoney/houseRenting;
            }
            System.out.println(counttime);
        }
        sr.close();
    }
}