package offer;

import java.util.ArrayList;

/**
 * Created by huali on 2018/6/19.
 */
public class printMatrix {
    public static  void main(String[]args)
    {
        //int [][]arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][]arr = {{1,2,3,4}};
        ArrayList<Integer> list = printMatrix(arr);
        System.out.println(list);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int columns = matrix[0].length;
        int rows = matrix.length;
        if(matrix==null||columns<=0||rows<=0)
            return list;
        int start = 0;
        while(columns>start*2&&rows>start*2)
        {
            printMatrixInCircle(matrix, columns, rows, start, list);
            ++start;
        }
        return list;
    }
    private static void printMatrixInCircle(int[][]matrix, int col, int row, int start, ArrayList<Integer> list)
    {
        int endX = col-1-start;
        int endY = row -1 -start;
        //从左到右打印一行。
        for(int i=start;i<=endX;++i)
        {
            int number = matrix[start][i];
            list.add(number);
        }
        //从上到下打印一列
        if(start<endY)
        {
            for(int i=start+1;i<=endY;++i)
            {
                int number = matrix[i][endX];
                list.add(number);
            }
        }
        //    从右到左打印一行
        if(start<endX&&start<endY)
        {
            for(int i = endX-1;i>=start;--i)
            {
                int number = matrix[endY][i];
                list.add(number);
            }
        }
        //    从下到上打印一列
        if(start<endX&&start<endY-1)
        {
            for(int i=endY-1;i>=start+1;--i)
            {
                int number = matrix[i][start];
                list.add(number);
            }
        }

    }
}