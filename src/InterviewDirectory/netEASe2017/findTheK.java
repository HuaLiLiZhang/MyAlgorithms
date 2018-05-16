package InterviewDirectory.netEASe2017;

import java.util.Arrays;

/**
 * Created by huali on 2018/5/15.
 */
public class findTheK {
//    有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
//
//给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
//
//测试样例：
//[1,3,5,2,2],5,3
//返回：2

    public static void main(String []args)
    {
        int []a = {1332802,1177178,1514891,871248,753214,
                123866,1615405,328656,1540395,968891,1884022,
                252932,1034406,1455178,821713,486232,860175,
                1896237,852300,566715,1285209,1845742,883142,259266,
                520911,1844960,218188,1528217,332380,261485,1111670,
                16920,1249664,1199799,1959818,1546744,1904944,51047,
                1176397,190970,48715,349690,673887,1648782,1010556,
                1165786,937247,986578,798663};
        System.out.println(findKth(a, 49, 24));
    }
    public static int findKth(int[] a, int n, int K) {
        // write code here
        Arrays.sort(a);
        int TheK = 0;
        for(int i =n-1;i>=0;i--)
        {
            if(a[i]!=a[i-1])
                K--;
            if(K==0)
            {
               TheK = a[i] ;
                break;
            }

        }
        return TheK;
    }
}