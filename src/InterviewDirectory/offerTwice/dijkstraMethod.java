package InterviewDirectory.offerTwice;


/**
 * Created by huali on 2018/8/9.
 */
public class dijkstraMethod {
    private final int INF = Integer.MAX_VALUE;
    int [][] Matrix;
    char[] Nodes;
    public dijkstraMethod(char[] Nodes, int [][] Matrix)
    {
        this.Nodes = Nodes;
        this.Matrix = Matrix;
    }

    /**
     *
     * @param node
     * @param distance
     */
    public void dijkstra(int node, int [] distance)
    {
        boolean [] flag = new boolean[Nodes.length];
        for(int i = 0 ;i<Nodes.length;i++)
        {
            flag[i] = false;
            distance[i] = Matrix[node][i];
        }
        flag[node] = true;
        distance[node] = 0;
        int k = 0;
        for(int i = 1;i<Nodes.length;i++)
        {
            int min = INF;
            for(int j = 0;j<Nodes.length;j++)
            {
                if(!flag[j]&&distance[j] < min)
                {
                    k = j;
                    min = distance[j];
                }
            }
            flag[k] = true;

            for(int j = 0;j<Nodes.length;j++)
            {
                int len = Matrix[k][j] ==INF?INF:min+Matrix[k][j];
                if(!flag[j]&&len<distance[j])
                    distance[j] = len;
            }
        }
        System.out.printf("Dijkstra(%c): \n", Nodes[node]);
        for(int i = 0; i<Nodes.length;i++)
        {
            System.out.printf(" shortest(%c, %c) = %d\n", Nodes[node],Nodes[i], distance[i]);
        }
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;

        char[] Nodes = {'A', 'B', 'C', 'D', 'E'};
        int matrix[][] = {
                /*A*//*B*//*C*//*D*/
                /*A*/ {0,1,5,INF,INF},
                /*B*/ {1,0,2,4,INF},
                /*C*/ {5,2,0,1,1},
                /*D*/ {INF,4,1,0,2},
                      {INF,INF,1,2,0}
        };

        int[] dist = new int[Nodes.length];

        dijkstraMethod dijkstra = new dijkstraMethod(Nodes, matrix);
        dijkstra.dijkstra(2, dist);

    }

}