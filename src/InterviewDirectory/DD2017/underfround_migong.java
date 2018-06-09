package InterviewDirectory.DD2017;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by huali on 2018/6/7.
 */
public class underfround_migong {

    static int n, m, maxRemainEnery = 0;
    static int [][] map;
    static boolean flag = false;
    static String path = "";
    static LinkedList<String> linkedList = new LinkedList<>();

    public static void main(String[]args)
    {
        Scanner sr = new Scanner(System.in);
        n = sr.nextInt();
        m = sr.nextInt();
        int P = sr.nextInt();
        map = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                map[i][j] = sr.nextInt();
            }
        }

        runMap(0, 0, P);
        if(!flag)
        {
            System.out.println("Can not escape!");
        }
        else
            System.out.println(path);
    }

    private static void runMap(int x, int y, int energy) {
        if(energy<0||x<0|y<0||x>=n||y>=m||map[x][y]!=1)
            return ;
        else
        {
            linkedList.offer("["+x+","+y+"]");
            map[x][y]=0;
            if(x==0&&y==m-1)
            {
                if(energy>=maxRemainEnery)
                {
                    maxRemainEnery = energy;
                    updatePath();   //更新路径为从一开始到终点
                }
                map[x][y] = 1;  //到达终点以后，此时能量值部位零，更新完路径之后，将最后的终点设置为原来的1
                // ，并将linkedList移除最后一个路径，因为是终点。
                linkedList.removeLast();
                flag = true;
                return ;
            }
            runMap(x, y+1, energy-1);
            runMap(x+1, y, energy);
            runMap(x-1, y, energy-3);
            runMap(x, y-1, energy-1);
            map[x][y] =1;
            linkedList.removeLast();
        }
    }

    private static void updatePath() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext())
            sb.append(iterator.next()+",");
        if(sb.length()>0)
            sb.deleteCharAt(sb.length()-1);  //如果找到路径到达终点，还需要删除最后一个路径值。
        path = sb.toString();
    }

}