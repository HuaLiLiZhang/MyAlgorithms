package InterviewDirectory.neteaseGame;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/25.
 */
public class putbox {
//    大家一定玩过“推箱子”这个经典的游戏。
// 具体规则就是在一个N*M的地图上，
// 有1个玩家、1个箱子、1个目的地以及若干障碍，其余是空地。
// 玩家可以往上下左右4个方向移动，但是不能移动出地图或者移动到障碍里去。
// 如果往这个方向移动推到了箱子，箱子也会按这个方向移动一格，
// 当然，箱子也不能被推出地图或推到障碍里。
// 当箱子被推到目的地以后，游戏目标达成。
// 现在告诉你游戏开始是初始的地图布局，
// 请你求出玩家最少需要移动多少步才能够将游戏目标达成。
//输入描述:
//每个测试输入包含1个测试用例
//第一行输入两个数字N，M表示地图的大小。其中0<N，M<=8。
//接下来有N行，每行包含M个字符表示该行地图。其中 . 表示空地、X表示玩家、*表示箱子、#表示障碍、@表示目的地。
//每个地图必定包含1个玩家、1个箱子、1个目的地。
//
//
//输出描述:
//输出一个数字表示玩家最少需要移动多少步才能将游戏目标达成。当无论如何达成不了的时候，输出-1。
//
//输入例子1:
//4 4
//....
//..*@
//....
//.X..
//6 6
//...#..
//......
//#*##..
//..##.#
//..X...
//.@#...
//
//输出例子1:
//3
//11



    //核心流程：
    //人走到了一个点，需要先判断该点是不是墙，出没出界，是墙或出界就用continue终止该次循环；再判断这个点是不是箱子，若是，那么箱子要与人同样的方向移动一步；最后再判断箱子的位置是否都满足既不是墙，也不出界。
    //
    //开个四维数组visit，前面两维记录人的X、Y，另外两维记录箱子的X、Y。
    //
    //显而易见，这就是一个BFS，何为BFS？请见下方图解：


    private static class State{
        int px ,py, bx, by;
        State pre;

        public State(int px, int py, int bx, int by, State pre) {
            this.px = px;
            this.py = py;
            this.bx = bx;
            this.by = by;
            this.pre = pre;
        }
    }

    public static void main(String[] args)
    {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext())
        {
            String s = sr.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int px = -1,py=-1,bx=-1,by=-1;
            char [][] maze = new char[n][n];
            for(int i=0;i<n;i++)
            {
                maze[i] = sr.nextLine().toCharArray();
                for(int j=0;j<maze[i].length;j++)
                {
                    if(maze[i][j]=='X')
                    {
                        px = i;
                        py = j;
                    }else if(maze[i][j]=='*')
                    {
                        bx = i;
                        by = j;
                    }
                }
            }


            State start = new State(px,py,bx,by,null);
            List<State> list = bfs(maze, start);
            System.out.println(list.size()-1);
        }
        sr.close();
    }

    private static List<State> bfs(char[][] maze, State start) {
        int n = maze.length;
        int m = maze[0].length;

        boolean [][][][] added = new boolean[n][m][n][m];
        //前面两维，代表人的位置，后面两维代表箱子的位置
        Queue<State> queue = new LinkedList<>();
        LinkedList<State> list = new LinkedList<>();
        queue.add(start);//根节点，即人和箱子最开始的位置
        added[start.px][start.py][start.bx][start.by] = true;  //人的初始位置和箱子的初始位置
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        State end = null;
        while (!queue.isEmpty()) {
            State cur = queue.poll();//当前节点

            //判断是否到达终点
            if (maze[cur.bx][cur.by] == '@') {
                end = cur;
                break;
            }
            for (int[] a : move) {
                //先将人移动到箱子的位置。
                State next = new State(cur.px + a[0], cur.py + a[1], cur.bx, cur.by, cur);
                //如果人移动到与箱子的位置相同，则箱子和人一起移动。
                if (next.px == next.bx && next.py == next.by)
                {
                    next.bx += a[0];
                    next.by += a[1];
                    //如果箱子移动到边界或者遇到障碍物，则重新继续向其他方向移动
                    if (next.bx < 0 || next.bx >= n || next.by < 0 || next.by >= m || maze[next.bx][next.by] == '#')
                        continue;
                }
                ////如果人移动到边界或者遇到障碍物，则重新继续向其他方向移动
                else if (next.px < 0 || next.px >= n || next.py < 0 || next.py >= m || maze[next.px][next.py] == '#') {
                    continue;
                }
                //如果人和物体都没有到达之前的位置。，则往队列中添加这个位置，并将此位置设为true
                //若该节点在前面没被continue，那么，就将这些未曾去过的节点加入到队列中
                if (!added[next.px][next.py][next.bx][next.by]) {
                    queue.add(next);
                    added[next.px][next.py][next.bx][next.by] = true;
                }
            }
        }


        if (end != null) {
            while (end != null) {
                list.addFirst(end);  //当end一直有前驱的话，就把它加入到list中，说明走过这些节点才能到达目的地
                end = end.pre;
            }
        }
        return list;
    }


}