package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/19.
 */
public class Main {
    public static void main(String []args)
    {
        //int[][]m = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        //int minpath = new minPathSum1().minpathsum(m);
        //System.out.println(minpath);
        //int minpath1 = new minPathSum1().minPathArr(m);
        //System.out.println(minpath1);
        //int min3 = new minPathSum1().minpath(m);
        //System.out.println(min3);

        //int[]arr={5,4,2,3,5,7,8,1};
        //mincoins1 mincoins1 =  new mincoins1();
        //int num = mincoins1.minCoins1(arr,15);
        //System.out.println(num);
        //int num2 = mincoins1.minCoins2(arr,15);
        //System.out.println(num2);
        //
        //minCoins3 minCoins3 = new minCoins3();
        //int num01 = minCoins3.minCoins3(arr,31);
        //System.out.println(num01);
        //int num01$1 = minCoins3.minCoin(arr,31);
        //System.out.println(num01$1);

        int[]arr = {5, 10, 25, 1};
        CoinsSUmNUm coinnum = new CoinsSUmNUm();
        int num = coinnum.coins1(arr, 15);
        System.out.println(num);
        int num2 = coinnum.coins2(arr, 15);
        System.out.println(num2);
    }
}