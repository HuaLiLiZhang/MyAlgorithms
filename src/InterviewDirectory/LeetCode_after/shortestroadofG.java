package InterviewDirectory.LeetCode_after;


import java.util.*;

/**
 * Created by huali on 2018/9/25.
 */
public class shortestroadofG {
//a d
//a b 1 c 2
//c d 4
//b d 3

//结果
//a b d
//4
    static List<Edge> list = new ArrayList<>();
    static  int edgeSize = 0;
    static char start0 ;
    static char end0;

    static List<List<Character>> li1 = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        start0 = s.charAt(0);
        end0 = s.charAt(2);
        while (sc.hasNext())
        {
            String sttep = sc.nextLine();
            char start1 = sttep.charAt(0);
            for(int i = 2;i<sttep.length();i+=4)
            {
                char end1 =  sttep.charAt(i);
                int weight = sttep.charAt(i+2)-'0';
                Edge edge0 = new Edge(start1,end1, weight);
                list.add(edge0);
                edgeSize++;
            }
        }
        createMinSpanTreeKruskal();

    }

    public static void createMinSpanTreeKruskal() {
        // 定义一个一维数组，下标为连线的起点，值为连线的终点
        /*char[] parent = new char[edgeSize];
        for (int i = 0; i < edgeSize; i++) {
            parent[i] = '0';
        }*/

        //HashMap<Character, Character> parent = new HashMap<>();
        //for (int i = 0; i < edgeSize; i++) {
        //    parent.put(list.get(i).start, list.get(i).end);
        //}
        int shortlength = Integer.MAX_VALUE;
        int[] sum = {0};
        for (Edge edge : list) {
            List<Character> li = new ArrayList<>();
            // 找到起点和终点在临时连线数组中的最后连接点
            char end = find(start0,li,sum);

            // 通过起点和终点找到的最后连接点是否为同一个点，是则产生回环
            if (edge.start ==start0&&end0== end) {

                // 没有产生回环则将临时数组中，起点为下标，终点为值
                //System.out.println("访问到了节点：{" + start0 + "," + end + "}，权值：" + edge.weight);
                li.add(end);
                li1.add(new ArrayList<>(li));
                shortlength = Math.min(shortlength,sum[0]);
            }
        }
        Collections.sort(li1, new Comparator<List<Character>>() {
            @Override
            public int compare(List<Character> o1, List<Character> o2) {
                return o1.size()-o2.size();
            }
        });
        for(char ch : li1.get(0))
            System.out.print(ch+" ");
        System.out.println();
        System.out.println(shortlength);  //"最小生成树的权值总和：" +
    }



    /**
     * 获取集合的最后节点
     */
    private static char find(char index,List<Character> li,int []sum) {

        while (true) {
            int i= 0;
            for(;i<list.size();i++)
            {
                if(list.get(i).start==index)
                {
                    li.add(index);
                    index = list.get(i).end;
                    sum[0] += list.get(i).weight;
                }
            }
            if(i>=list.size())
                 break;
        }
        return index;
    }



    static class Edge {

        private char start;
        private char end;
        private int weight;

        public Edge(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}