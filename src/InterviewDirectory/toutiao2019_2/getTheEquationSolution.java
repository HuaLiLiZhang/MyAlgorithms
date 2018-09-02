package InterviewDirectory.toutiao2019_2;

import java.util.*;

/**
 * Created by huali on 2018/8/25.
 */
public class getTheEquationSolution {
//形如y = 4 - x 的约束关系，查询形如y-x的值
//   y = k - x

//输入：
//3 2
//a = 0 - b
//b = 2 - c
//c = 4 - d
//b - d
//b - c
//输出：
//-2
//cannot_answer


    //3 4
    //a = 0 - b
    //b = 2 - c
    //c = 4 - d
    //b - d
    //b - c
    //a - c
    //a - d
    //-2
    //cannot_answer
    //-2
    //cannot_answer


    //其本质是一道无向图的寻找路径题，
    // 每添加一个y=k-x等式，相当于向一副加权无向图中分别添加了y、x、yy、xx四个顶点，
    // 以及y点到xx点权重为k的无向边和x点到yy点权重为-k的无向边。
    // 而想要求y-x的值就看是否存在一条从y点到x点的路径，并求出该路径的值。
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String[] str = scan.nextLine().split(" ");
            int num1 = Integer.parseInt(str[0]);
            int num2 = Integer.parseInt(str[1]);
            Graph G = new Graph();
            for (int i = 0; i < num1; i++) {
                str = scan.nextLine().split(" ");
                G.addEdge(new Edge(str[0], str[4] + "2", Integer.parseInt(str[2])));
                G.addEdge(new Edge(str[0] + "2", str[4], -(Integer.parseInt(str[2]))));
            }
            String[] result = new String[num2];
            for (int i = 0; i < num2; i++) {
                str = scan.nextLine().split(" ");
                String v = str[0];
                String w = str[2];
                List<String> marked = new ArrayList<>();  //维护一个标记列表，用于DFS解决路径问题
                result[i] = path(G, v, w, marked);
            }
            for (int i = 0; i < num2; i++) {
                System.out.println(result[i]);
            }
        }


        // 加权无向边
       public static class Edge{
            public String v;
            public String w;
            public int weight;
            public Edge(String v, String w, int weight){
                this.v = v;
                this.w = w;
                this.weight = weight;
            }
            public int weight() {
                return weight;
            }
            public String either(){
                return v;
            }
            public String other(String vertex){
                if (vertex.equals(v)) return w;
                else return v;
            }
        }

        // 加权无向图
        public static class Graph {
            public Map<String, List<Edge>> adj = new HashMap<>();
            public void addEdge(Edge e){
                String v = e.either(), w = e.other(v);
                if (adj.get(v) == null) adj.put(v, new ArrayList<>());
                adj.get(v).add(e);
                if (adj.get(w) == null) adj.put(w, new ArrayList<>());
                adj.get(w).add(e);
            }
            public List<Edge> adj(String v)
            {
                return adj.get(v);
            }
        }

        // 加权无向图的路径问题使用DFS
        public static String path(Graph G, String v, String target, List<String> marked){
        marked.add(v);
        for (Edge e : G.adj(v)){
            String w = e.other(v);
            if (w.equals(target)) return Integer.toString(e.weight);
            else if (marked.contains(w)) continue;
            else {
                String result = path(G, w, target, marked);
                if (result.equals("cannot_answer"))
                    continue;
                else
                    return Integer.toString(e.weight + Integer.parseInt(result));
            }
        }
        return "cannot_answer";
    }


}