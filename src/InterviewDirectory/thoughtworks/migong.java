package InterviewDirectory.thoughtworks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by huali on 2018/7/31.
 */
public class migong {

    public static void main(String[] args)
    {
        Scanner sr = new Scanner(System.in);
        int row = sr.nextInt();
        int col =sr.nextInt();
        boolean flag = true;
        boolean flag0 = true;
        int [][] inner = new  int[2*row-1][2*col-1];
        String [][] outer = new String[2*row+1][2*row+1];
        sr.nextLine();
        String s = sr.nextLine();
        int [] arr = new int[s.split(";").length*2*2];
        for(int i =0;i<s.length();i++)
        {
            if(i%2==0)
            {
                if(outrange(s, i)&&Invalidnum(s, i,  row, col))
                {
                    arr[i/2]=s.charAt(i)-'0';
                }
                else
                {
                    flag = false;
                    break;
                }
            }
            else if(Incorrectcom(s,i))
            {
                continue;
            }
            else {
                flag0 = false;
                break;
            }
        }
        int i = 0;
        for(;i<arr.length;i+=4)
        {
            int x1 = arr[i];
            int y1 = arr[i+1];
            int x2 = arr[i+2];
            int y2 = arr[i+3];
            if(x1==x2)
            {
                for(int k=2*y1;k<=2*y2;k++)
                {
                    outer[2*x1+1][k+1]="[R]";
                    inner[2*x1][k] = 1;
                }

            }else if(y1==y2)
            {
                for(int k=2*x1;k<=2*x2;k++)
                {
                    outer[k+1][2*y1+1]="[R]";
                    inner[k][2*y1] = 1;
                }
            }
        }
        if(flag&&flag0&&i!=arr.length)
        {
            System.out.println("Incorrect command format.");
        }

        Maze cell = new Maze();
        cell.setStart(0,0);
        cell.setEnd(2*row-2, 2*col-2);
        cell.visited(inner, 0,0,0);
        //if(flag&&flag0&&i==arr.length&&cell.shortestPath.length()== 0)
        //    System.out.println("Maze format error");
        //System.out.println(cell.shortestPath.toString());
        if(flag&&flag0&&i==arr.length&&cell.c== 9999)
                System.out.println("Maze format error");
        System.out.println(cell.c);
        for(int m = 0;m< outer.length;m++)
        {
            for(int n = 0;n<outer.length;n++)
            {
                if(outer[m][n]==null)
                {
                    if (n == outer.length - 1)
                        System.out.print("[W]");
                    else
                        System.out.print("[W] ");
                }
                else {
                    if (n == outer.length - 1)
                        System.out.print("[R]");
                    else
                        System.out.print("[R] ");
                }
            }
            System.out.println();
        }

    }

    private static boolean Invalidnum(String s, int i, int row ,int col) {
        if(s.charAt(i)<'0'||s.charAt(i)>'9'||s.charAt(i)-'0'>Math.max(row,col))
        {
            System.out.println("Invalid number format.");
            return false;
        }
        return true;
    }

    private static boolean outrange(String s, int i) {
        if(s.charAt(i)=='-')
        {
            System.out.println("Number out of range.");
            return false;
        }
        return true;
    }

    private static boolean Incorrectcom(String s, int i) {
        if(i%4==1)
        {
            if(s.charAt(i)==',')
                return true;
            else
            {
                System.out.println("Incorrect command format.");
                return false;
            }
        }
        if(i%8==3)
        {
            if(s.charAt(i)==' ')
                return true;
            else
            {
                System.out.println("Incorrect command format.");
                return false;
            }
        }
        if(i%8==7)
        {
            if(s.charAt(i)==';')
                return true;
            else
            {
                System.out.println("Incorrect command format.");
                return false;
            }
        }
        return true;
    }

}

class Maze {
    static String path = "";
    static String shortestPath = "";
    private static int startPosI;//入口的i下标
    private static int startPosJ;//入口的j下标
    private static int endPosI;//出口的i下标
    private static int endPosJ;//出口的j下标

    //设置迷宫入口的坐标
    public void setStart(int startPosI,int startPosJ)
    {
        Maze.startPosI = startPosI;
        Maze.startPosJ = startPosJ;
    }

    //设置迷宫出口的坐标
    public void setEnd(int endPosI,int endPosJ)
    {
        Maze.endPosI = endPosI;
        Maze.endPosJ = endPosJ;
    }

    //迷宫搜索通路的算法
    /*  cell:迷宫地图
     *  i: 入口的i坐标
     *  j: 入口的j坐标
     **/
    //public void visited(int[][] cell,int i,int j)
    //{
    //    if(i<0||j<0)
    //        return ;
    //    if(i>endPosI||j>endPosJ||cell[i][j]==0)
    //        return ;
    //    if(cell[i][j]==0)
    //        return ;
    //    if(i==endPosI&&j==endPosJ)
    //    {
    //        path = path + "(" + i + "," + j + ")";
    //        if (shortestPath.length() == 0 || path.length() > shortestPath.length())
    //            shortestPath = path;
    //        return;
    //    }
    //    String temp = path;
    //    path = path + "(" + i + "," + j + ")" + "-"; // 记录路线
    //    cell[i][j] = 0;
    //    visited(cell,i+1,j);
    //    visited(cell,i-1,j);
    //    visited(cell,i,j+1);
    //    visited(cell,i,j-1);
    //    cell[i][j] = 1;
    //    path = temp;
    //    return ;
    //}
    public static int c = 9999;
    int [][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public void visited(int[][] cell,int x,int y,int t)
    {
        int i, xx, yy;
        if(x==endPosI&&y==endPosJ)
        {
            c = Math.min(t, c);
            return;
        }
        //if(cell[x][y]==0)
        //    return ;

        cell[x][y] = 0;
        for(int m = 0;m<4;m++)
        {
            xx = x+dir[m][0];
            yy = y+dir[m][1];
            if(xx<startPosI||xx>endPosI||yy>endPosJ||yy<startPosJ||cell[xx][yy]==0)
                continue;
            visited(cell, xx,yy,t+1);
            cell[xx][yy] = 1;
        }
    }
}
