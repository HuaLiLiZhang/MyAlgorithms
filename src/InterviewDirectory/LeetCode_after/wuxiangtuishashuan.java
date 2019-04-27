package InterviewDirectory.LeetCode_after;

import java.util.*;

/**
 * Created by huali on 2018/10/9.
 */
public class wuxiangtuishashuan {
    //无向图根据点的度数判断是否有环
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = T;i>0;i--)
        {
            int sum = 0;
            int n = sc.nextInt();
            int [] arr = new int[n];
            for(int j= 0;j<n;j++)
            {
                arr[j] = sc.nextInt();
                sum +=arr[j];
                if(arr[j]>=n-1)
                {
                    System.out.println("No");
                    break;
                }
                if(sum>=2*n)
                    System.out.println("No");
                else
                    System.out.println("Yes");
            }


        }
    }
/*    //从某点出判断无向图是否有回路（图用邻接矩阵表示）。假如有N个点，需要调用N次该函数。因为考虑到孤立点的因素，需要从每个点都开始一次。
    boolean isHuiLu(int begin, int temp[][])
    {
        boolean flag[] = new boolean[Integer.MAX_VALUE];
        int i, j;
        Stack<Integer> stk;
        Queue<Integer> vexQueue = new ArrayDeque<>();
        for (i = 0; i<vexnum; i++)
            flag[i] = false;
        //从a或b点出发，广度遍历所有点
        //如果该点和之前已访问过的点（除了它父亲）有边，
        //说明有回路
        vexQueue.add(begin);
        flag[begin] = true;
        int father;
        while (vexQueue.isEmpty()) {
            father = vexQueue.peek();
            vexQueue.poll();
            for (int i = 0; i < vexnum; ++i) {
                if (temp[father][i] != MAX && flag[i] == false) {
                    vexQueue.push(i);
                    flag[i] = true;
                    //看看当前点和其他已访问点是否有边
                    for (int j = 0; j < vexnum; ++j) {
                        if (temp[i][j] != MAX && j != father && flag[j] == true) {
                            return true;//如果有边，说明有回路
                        }
                    }

                }

            }
        }
        return false;
    }*/
}