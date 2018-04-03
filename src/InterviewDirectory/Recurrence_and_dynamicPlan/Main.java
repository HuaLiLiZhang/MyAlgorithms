package InterviewDirectory.Recurrence_and_dynamicPlan;

import java.lang.reflect.Array;
import java.util.Arrays;

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

        //int[]arr = {5, 10, 25, 1};
        //CoinsSUmNUm coinnum = new CoinsSUmNUm();
        //int num = coinnum.coins1(arr, 15);
        //System.out.println(num);
        //int num2 = coinnum.coins2(arr, 15);
        //System.out.println(num2);

        //int []arr1 = {2,1,5,3,6,4,8,9,7};
        //int []list1 = new generateLIS().list1(arr1);
        //System.out.println(Arrays.toString(list1));
        //int []list2 = new generateLIS().list2(arr1);
        //System.out.println(Arrays.toString(list2));

        //hanoi  han= new hanoi();
        //han.hannoi1(2);

        //String str1 = "A2BDC";
        //String str2 = "AB2CD";
        //getdp_long_common_array getmax = new getdp_long_common_array();
        ////String res = getmax.lcse(str1,str2);
        ////System.out.println(res);
        ////System.out.println(res.substring(0, 3));
        //String str11= "bebcd";
        //String str22 = "abcde";
        //String res =new theLOngSubString().lcst2(str11,str22);
        //System.out.println(res);

        //String str1 ="ab12cd3";
        //String str2 = "abcdf";
        //int num = new minCost_twoStr().mincost1(str1,str2,5,3,2);
        //System.out.println(num);
        //int num1 = new minCost_twoStr().minCost(str1,str2,5,3,2);
        //System.out.println(num1);

        //String str1 = "AB";
        //String str2 = "12";
        //String aim = "AB12";
        //boolean result = new strIsCross1().isCross1(str1,str2,aim);
        //boolean result1 = new strIsCross1().isCross2(str1,str2,aim);
        //System.out.println(result);
        //System.out.println(result1);

        //int [][]map = {{-2,-3,3},{-5,-10,1},{0,30,-5}};
        //int num = new MinHp1().minHP1(map);
        //System.out.println(num);
        //int num2 = new MinHp1().minHp2(map);
        //System.out.println(num2);

        //String str = "1111";
        //int num = new str_to_num1A().num1(str);
        //System.out.println(num);
        //int num1 = new str_to_num1A().num2(str);
        //System.out.println(num1);

        //String str="1^0|0|1";
        //boolean desired = false;
        //str_01_boolean strn = new str_01_boolean();
        //int num0 = strn.str_01_num1(str, desired);
        //System.out.println(num0);
        //int num1 = strn.num2(str, desired);
        //System.out.println(num1);


        //int arr [] = {1,2,100,4};
        //        //int num1 = new getArr_win1().win1(arr);
        //        //System.out.println(num1);
        //        //int num2 = new getArr_win1().win2(arr);
        //        //System.out.println(num2);

        //int []arr={3,2,3,1,1,4};
        //int num = new jumpNumLest().jump1(arr);
        //System.out.println(num);

        int []arr = {100,4, 200, 2,1,3};
        longestConsecutive longest = new longestConsecutive();
        int result = longest.longestConse(arr);
        System.out.println(result);

        //Nqueue queuq = new Nqueue();
        //int num1 = queuq.num1(4);
        //System.out.println(num1);
        //
        //int num2 = queuq.num2(4);
        //System.out.println(num2);

    }
}