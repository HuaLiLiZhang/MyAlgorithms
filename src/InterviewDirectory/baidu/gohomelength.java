package InterviewDirectory.baidu;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/2.
 */
public class gohomelength {
    //一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
    //但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？

    public static  void main(String [] args)
    {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int i =0;
        int ans = 0;
        int []arr = new int[50];
        for (;i<n;i++)
        {
            arr[i] = sr.nextInt();
            if(i!=0)  /* 计算两个相邻节点之间的距离，ans为所有相邻节点距离的总和 */
                ans+=Math.abs(arr[i]-arr[i-1]);
        }

        int _m = 0;
        //计算相邻的3个节点之间的距离总和，A->B,B->C,A->C
        for(i = 0;i<n-2;i++)
        {
            _m = Math.max(_m, Math.abs(arr[i]-arr[i+1])+Math.abs(arr[i+1]-arr[i+2])-Math.abs(arr[i]-arr[i+2]));

        }
        System.out.println(ans - _m);

    }
}