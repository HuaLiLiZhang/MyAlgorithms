package InterviewDirectory.meituan2019;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/7.
 */
public class Main2ali {
    public static void main(String[] args)
    {
        int x0 = 3;
        int y0 = 4;

        int [][] arr = {{0,0},{0,2},{2,2},{2,0}};
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxy = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++)
        {
            minx = Math.min(arr[i][0],minx);
            maxx = Math.max(arr[i][0],maxx);
            miny = Math.min(arr[i][1],miny);
            maxy = Math.max(arr[i][1],maxy);

        }
    }
}