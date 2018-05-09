package InterviewDirectory.netEASe2017;

import java.util.Scanner;

/**
 * Created by huali on 2018/5/9.
 */
public class Scantoujing {
    //    在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,而且蘑菇是隐形的.
// 只 有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇,于是他回了一趟战争学院,买了2个扫描透镜,
// 一个 扫描透镜可以扫描出(3*3)方格中所有的蘑菇,然后兰博就可以清理掉一些隐形的蘑菇.
// 问:兰博最多可以清理多少个蘑菇?
//注意：每个方格被扫描一次只能清除掉一个蘑菇。
//输入描述:
//第一行三个整数:N,M,K,(1≤N,M≤20,K≤100),N,M代表了草地的大小;
//接下来K行,每行两个整数x,y(1≤x≤N,1≤y≤M).代表(x,y)处提莫种了一个蘑菇.
//一个方格可以种无穷个蘑菇.
//
//
//输出描述:
//输出一行,在这一行输出一个整数,代表兰博最多可以清理多少个蘑菇.
    public static int LENGTH = 2;
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);

        while (sr.hasNext())
        {
            int N = sr.nextInt();
            int M = sr.nextInt();
            int K = sr.nextInt();
            int [][] arr = new int[N][M];
            for(int i=0;i<K;i++)
            {
                int x = sr.nextInt()-1;
                int y = sr.nextInt()-1;
                if(x<N&&y<M)
                    arr[x][y] ++;
            }
            Point point1 = findMaxNum(N, M, arr);
            clear(point1, arr, N, M);  //arr的内部减1.
            Point point2 = findMaxNum(N, M, arr);
            System.out.println(point1.count+point2.count);
        }
        sr.close();

    }

    private static void clear(Point point, int[][] arr, int n, int m) {
        for(int i=point.x;i<=point.endX;i++)
        {
            for(int j = point.y;j<=point.endY;j++)
            {
                if(arr[i][j]>0&&i<n&j<m)
                    arr[i][j]--;
            }
        }
    }

    private static Point findMaxNum(int n, int m, int[][] arr) {
        Point point = new Scantoujing().new Point();
        point.count=0;
        point.x = 0;
        point.y=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                Point temppoint = getNumInLocation(n,m,arr,i,j);
                if(point.count<temppoint.count)
                    point = temppoint;
            }
        }
        return point;
    }

    private static Point getNumInLocation(int n, int m, int[][] arr, int startx, int starty) {

        int endX , endY;
        if(startx+ LENGTH>n-1)
            endX = n-1;
        else
            endX = startx+LENGTH;
        if(starty+LENGTH>m-1)
            endY = m-1;
        else
            endY = starty+LENGTH;

        //统计个数
        Point point = new Scantoujing().new Point();
        point.count = 0;
        point.x =startx;
        point.y = starty;
        point.endY = endY;
        point.endX = endX;
        for(int i =startx;i<=endX;i++)
        {
            for(int j=starty;j<=endY;j++)
            {
                if(arr[i][j]>0)
                    point.count++;
            }
        }
        return point;
    }
    class Point
    {
        int x;
        int y;
        int count;
        int endX;
        int endY;
    }
}
