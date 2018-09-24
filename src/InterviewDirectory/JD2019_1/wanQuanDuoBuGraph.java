package InterviewDirectory.JD2019_1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/9.
 */
public class wanQuanDuoBuGraph {
        //判断是否为完全多部图
        //给定一张包含N个点，M条边的无向图，每条边链接两个不同的点，且任意两点间最多只有一条边
        //对于这样的无向图，如果能将所有的点划分为若干个集合，使得任意两个同一集合内的点之间没有边相连，
        //任意两个不同集合内的点有边相连。称为完全多部图
        //


        //思路：跟一个点没有边相连的所有点构成一个集合
        //找到所有的集合，然后在算出如果是完全多部图应该有多少边，跟实际的边进行比较，如果相等就yes
        //如果不等就no，再加一步，还要判断集合中的点没有边相连。
        public static void main(String[] args)
        {
               Scanner sc = new Scanner(System.in);

        }



       /* public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int T = in.nextInt();  //输入几组数据
            List<String> result = new ArrayList<>();
            for(int i = 0;i<T;i++){
                int N = in.nextInt();  //代表有N个点
                int M = in.nextInt();  //代表有M条边

                int[][] edges = new int[M][2];
                for(int m = 0;m<2*M ; m++){
                    edges[m/2][m%2] = in.nextInt()-1;  //点从0开始。
                    //edges[m/2][m%2] = in.nextInt();//从1开始
                }

                List<List<Integer>> lists = new ArrayList<>();

                for(int j = 0;j<N;j++){
                    boolean f = false;
                    for(int m = 0;m<lists.size();m++){
                        if(lists.get(m).contains(j)){
                            f = true;
                        }
                    }
                    if(!f){
                        List<Integer> list = getList(j,N,edges);
                        if(list!=null){
                            lists.add(list);
                        }
                    }
                }
                int count = 0;
                for(int n = 0;n<lists.size();n++){
                    int l = lists.get(n).size();
                    for(int j = 0;j<lists.size();j++){
                        int t = lists.get(j).size();
                        if(n!=j){
                            count+=l*t;
                        }
                    }
                }
                //count所有的边算了两次，故要除以2
                String re = (count/2==edges.length?"Yes":"No");
                result.add(re);
            }
            for(String sss: result)
            {
                System.out.println(sss);
            }
        }
        private static List<Integer> getList(int start,int N, int[][] edges) {
            int[] points = new int[N];
            for(int i = 0;i<N ;i++){
                points[i] = 0;
            }
            for(int i = 0;i<edges.length;i++){
                if(edges[i][0]==start||edges[i][1]==start){
                    points[edges[i][0]] = 1;
                    points[edges[i][1]] = 1;
                }
            }
            List<Integer> list = new ArrayList<>();
            list.add(start);
            for(int i = 0;i<N ;i++){
                if(points[i] == 0){
                    list.add(i);
                }
            }
            // TODO Auto-generated method stub
            return list;
        }*/

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
//Yes
//No
//Yes
}
