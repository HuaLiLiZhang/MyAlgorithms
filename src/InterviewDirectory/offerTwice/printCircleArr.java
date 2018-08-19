package InterviewDirectory.offerTwice;


/**
 * Created by huali on 2018/8/16.
 */
public class printCircleArr {
    public static void main(String[] args)
    {
        int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printmatrixClockWisely(arr, arr.length, arr[0].length);
    }

    private static void printmatrixClockWisely(int[][] arr, int rows, int columns)
    {
        if(arr==null||rows<=0||columns<=0)
            return;
        int start = 0;
        while (rows>start*2&&columns>start*2)
        {
            printmatrixCircle(arr,rows, columns, start);
            start++;
        }
    }

    private static void printmatrixCircle(int[][] arr, int rows, int columns, int start)
    {
        int endX = columns-1-start;
        int endY = rows -1 -start;
        for(int i = start;i<=endX;i++)
        {
            System.out.print(arr[start][i]+" ");
        }
        if(start<endY)
        {
            for(int i = start+1;i<=endY;i++)
            {
                System.out.print(arr[i][endX]+" ");
            }
        }
        if(start<endX&&start<endY)
        {
            for(int i = endX-1;i>=start;i--)
            {
                System.out.print(arr[endY][i]+" ");
            }
        }
        if(start<endX&&start<endY-1)
        {
            for(int i = endY-1;i>start;i--)
            {
                System.out.print(arr[i][start]+" ");
            }
        }

    }

}