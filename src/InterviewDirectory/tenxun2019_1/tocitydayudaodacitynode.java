package InterviewDirectory.tenxun2019_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/16.
 */
public class tocitydayudaodacitynode {
    //有n个结点，m条边。
    // 对于一个节点v，从节点v出发的可以到达的结点数量为x,从某个结点到达这个结点的数量为y，
    // 如果y>x,代表这个结点是重要结点。求多少个重要结点
    //输入：
    //4 3
    //2 1
    //3 2
    //4 3
    //输出：2
    public static void main(String[] args)
    {
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //int m = sc.nextInt();
        //int[][]arr =  new int[n][n];
        //for(int i = 0;i<n;i++)
        //{
        //    int x = sc.nextInt()-1;
        //    int y = sc.nextInt()-1;
        //    arr[x][y] = arr[y][x] = 1;
        //}
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int m = sc.nextInt();

                int[][] toOrFrom = new int[n][2];//0表示到达的城市数量，1表示可以被多少城市到达。
                int[][] road = new int[m][2];
                for(int i = 0;i<m;i++){
                    road[i][0] = sc.nextInt()-1;
                    road[i][1] = sc.nextInt()-1;
                }

                for(int i = 0;i<n;i++){
                    int[] flags = new int[n];
                    Arrays.fill(flags, 0);
                    flags[i]=1;
                    findresult(i,i,flags,road,toOrFrom);
                }
                int resultnode = 0;
                for(int i = 0;i<toOrFrom.length;i++){
                    if(toOrFrom[i][0]<toOrFrom[i][1]){
                        resultnode++;
                    }
                }
                System.out.println(resultnode);
            }

            private static void findresult(int pre, int start, int[] flags, int[][] roads, int[][] toOrfrom) {
                for(int i = 0;i<roads.length;i++){
                    if(roads[i][0]==start&&flags[roads[i][1]]==0){  //到达的结点
                        flags[roads[i][1]]=1;
                        toOrfrom[pre][0]++;
                        toOrfrom[roads[i][1]][1]++;
                        findresult(pre,roads[i][1],flags,roads,toOrfrom);
                    }
                }
            }

}