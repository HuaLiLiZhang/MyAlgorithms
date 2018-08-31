package InterviewDirectory.haoweilai2019;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/28.
 */
public class diceProbability {
        //有一个n面的骰子，掷每一面都是等概率的，其中有m个奖励面，
    // 如果掷到奖励面则可以在掷一次骰子，玩家每掷一次都能获得掷到那一面的分数。求玩家可以得到分数的期望。

        //思路：
        //  玩家掷一次的概率：1/n, 每个面的分数为1,1,1,1,1,1,。期望为 sum/n；
        //玩家掷两次的概率就是 m/n，第二次期望(m/n)*(sum/n);
        //玩家掷n次  ：(m/n)^n  ,期望为（m/n）^n*(sum/n)
        // ....(m/n+(m/n)^2+...(m/n)^n) = (m/(n-m))
        //所以期望的综合为（1+m/(n-m)）*sum/n = sum/(n-m)

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int count = 0;
            for(int i = 0;i<n;i++){
                count+=in.nextInt();
            }
            Double re = (double)count/(double)(n-m);

            DecimalFormat format   = new DecimalFormat("######0.00");
            System.out.println(format.format(re));

        }

}