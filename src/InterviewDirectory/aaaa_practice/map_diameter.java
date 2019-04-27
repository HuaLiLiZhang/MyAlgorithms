package InterviewDirectory.aaaa_practice;

import java.util.Scanner;

/**
 * Created by huali on 2019/4/18.
 */
public class map_diameter {
    static int diameter ;
    static boolean[][] adj;
    public static void main(String[] args)
    {
        diameter = 0;   // 初始化
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while (--N>=0)
        {
            int M;
            M = sc.nextInt();
            sc.nextLine();
            adj = new boolean[M][M];
            int root = 0;   // 隨便選一個樹根
            while (--M>0)
            {
                String s = sc.nextLine();
                String[] s1= s.split(" ");
                int start = Integer.valueOf(s1[0]);
                int end = Integer.valueOf(s1[1]);
                adj[start-1][end-1] = true;

            }
            DFS(root, root);
            System.out.println(diameter);
        }

        sc.close();

    }



    static int DFS(int x, int px)  // px是x的父親
    {
        int h1 = 0, h2 = 0; // 紀錄最高與次高的高度
        for (int y=0; y<9; ++y)
            if ((!adj[x][y]) && (y != px))//记录父亲节点，防止重复访问
            {
                int h = DFS(y, x) + 1;
                if (h > h1)
                {
                    h2 = h1;
                    h1 = h;
                }
                else if (h > h2)
                    h2 = h;
            }
        diameter = Math.max(diameter, h1 + h2);
        return h1;
    }


}