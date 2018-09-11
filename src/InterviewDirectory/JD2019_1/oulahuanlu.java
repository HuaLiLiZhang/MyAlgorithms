package InterviewDirectory.JD2019_1;

import java.util.*;

/**
 * Created by huali on 2018/9/9.
 */
public class oulahuanlu {
    //    Fleury(佛罗莱）算法求欧拉回路的学习
//    若图G中存在这样一条路径，使得它恰通过G中每条边一次,则称该路径为欧拉路径。
// 若该路径是一个圈，则称为欧拉(Euler)回路。
//


    //此方法是判断是否存在欧拉回路。
    final int MAXN = 111;

    static Stack<Integer> S = new Stack<>();
    static int edge[][] = new int[1000][1000];
    static int n, m;
    static List<Integer> list ;
    static List<String> re = new ArrayList<>();
   static void dfs(int x) {
        S.push(x);
        for (int i = 1; i <= n; i++) {
            if (edge[x][i] > 0) {
                edge[i][x] = edge[x][i] = 0;//删除此边
                dfs(i);
                break;
            }
        }
    }

    //Fleury算法的实现
    static void Fleury(int x) {
        S.push(x);
        while (!S.empty()) {
            int b = 0;
            for (int i = 1; i <= n; i++) {
                if (edge[S.peek()][i] > 0) {
                    b = 1;
                    break;
                }
            }
            if (b == 0) {
                //System.out.printf("%d", S.peek());
                list.add(S.peek());
                S.pop();
            } else {
                int y = S.peek();
                S.pop();
                dfs(y);//如果有，就dfs
            }
        }
        //System.out.printf("\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (--T >= 0) {
            list = new ArrayList<>();
            String s = sc.nextLine();
            String[] str = s.split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);//读入顶点数以及边数
//3

//5 7
//1 3
//1 5
//2 3
//2 5
//3 4
//4 5
//3 5

//4 3
//1 2
//2 3
//3 4

//5 6
//2 1
//2 4
//2 5
//3 1
//3 4
//3 5
//yes
//no
//no
            //Arrays.fill(edge,0);
            //int x, y;
            for (int i = 1; i <= m; i++) {
                String s0 = sc.nextLine();
                String[]str0 = s0.split(" ");
                int x = Integer.parseInt(str0[0]);
                int y = Integer.parseInt(str0[1]);
                edge[x][y] = edge[y][x] = 1;
            }
            //如果存在奇数顶点，则从奇数顶点出发，否则从顶点0出发
            int num = 0, start = 1;
            for (int i = 1; i <= n; i++) {                        //判断是否存在欧拉回路
                int degree = 0;
                for (int j = 1; j <= n; j++) {
                    degree += edge[i][j];
                }
                if ((degree&1)!=0) {  //度为奇数。
                    start = i;  //度为奇数的起始点，如果没有度为奇数的点，那么初始点就为1.
                    num++;  //度为奇数的个数
                }
            }
            //度为奇数的个数为0，或者为2的话，表示没有奇数的度的结点。
            if (num == 0 || num == 2) {
                Fleury(start);
                //list中存路径，如果最后一个元素和第一个元素相同，代表回到原点，
                // 如果不等代表不存在欧拉回路
                if(list.get(0)==list.get(list.size()-1))
                    re.add("yes");
                else
                    re.add("no");
            } else  //存在奇数度的结点的话，肯定不存在欧拉回路。
                System.out.printf("No Euler Path\n");
            //return ;
        }
        for(String sss:re)
            System.out.println(sss);

    }
}