package InterviewDirectory.toutiao2019_2;

import java.util.*;

/**
 * Created by huali on 2018/8/25.
 */
public class isSameSetUnionSet {
//    一个团队有10个人，每一行代表这个人认识那个人，如果相互认识，或者a->c，c->b，那么a->b，
//10
//0
//5 3 0
//8 4 0
//9 0
//9 0
//3 0
//0
//7 9 0
//0
//9 7 0

    public static class Node{
        public Set<Integer> friends = new HashSet<>();
    }

    public static HashMap<Node,Node> fatherMap;
    public static HashMap<Node, Integer> sizeMap;

    public static void main(String[] args)
    {

    //    并查集
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0||n>=10000)
        {
            System.out.println(0);
            return;
        }

        Node[] nodes = new Node[n+1];
        int tmp;
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for(int i = 1;i<=n;i++)
        {
            nodes[i] = new Node();
            fatherMap.put(nodes[i],nodes[i]);
            sizeMap.put(nodes[i],1);
            while ((tmp=sc.nextInt())!=0)
            {
                nodes[i].friends.add(tmp);
            }
        }
    //    2.遍历每一个节点，根据合并策略进行合并
        for(int i = 1;i<nodes.length;i++)
        {
            if(nodes[i].friends.size()==0)
                continue;
            for(Iterator<Integer> iterator = nodes[i].friends.iterator();iterator.hasNext();)
            {
                Integer one = iterator.next();
                if(!IsSameSet(nodes[i], nodes[one]))
                {
                    union(nodes[i], nodes[one]);
                    n--;
                }
            }
        }
        System.out.println(n);


    }

    private static void union(Node a, Node b) {
        if(a==null||b==null)
        {
            return ;
        }
        Node ahead = findHead(a);
        Node bhead = findHead(b);
        if(ahead!=bhead)
        {
            int asetSize = sizeMap.get(ahead);
            int bsetSize = sizeMap.get(bhead);
            if(asetSize<=bsetSize)
            {
                fatherMap.put(ahead, bhead);
                sizeMap.put(bhead,asetSize+bsetSize);
            }else {
                fatherMap.put(bhead,ahead);
                sizeMap.put(ahead,asetSize+bsetSize);
            }
        }

    }

    private static boolean IsSameSet(Node a, Node b) {
        return findHead(a) == findHead(b);

    }

    private static Node findHead(Node node) {
        //Node father = fatherMap.get(node);
        //if (father!=node)
        //{
        //    father = fatherMap.get(father);
        //}
        Node father = node;
        while (father!=fatherMap.get(father))
        {
            father = fatherMap.get(father);
        }
        fatherMap.put(node, father);
        return father;

    }
}

//#include <iostream>
//#include <vector>
//using namespace std;
//class peoplenum {
//    vector<int> parent;
//    vector<int> rank;
//    vector<int> sz;
//    public:
//    peoplenum(int N) : parent(N), rank(N), sz(N, 1) {
//        for (int i = 0; i < N; ++i)
//            parent[i] = i;
//    }
//
//    int find(int x) {
//        if (parent[x] != x) parent[x] = find(parent[x]);
//        return parent[x];
//    }
//
//    void Union(int x, int y) {
//        int xr = find(x), yr = find(y);
//        if (xr == yr) return;
//
//        if (rank[xr] < rank[yr]) {
//            int tmp = yr;
//            yr = xr;
//            xr = tmp;
//        }
//        if (rank[xr] == rank[yr])
//            rank[xr]++;
//
//        parent[yr] = xr;
//        sz[xr] += sz[yr];
//    }
//
//    int size(int x) {
//        return sz[find(x)];
//    }
//
//    int top() {
//        return size(sz.size() - 1) - 1;
//    }
//};
//
//int main()
//        {
//        int n; cin >> n;
//        peoplenum d(n + 1);
//        for (int i = 0; i < n; ++i)
//        {
//        int v;
//        while (cin >> v && v)
//        {
//        d.Union(i + 1, v);
//        }
//        }
//        int ans = 0;
//        for (int i = 1; i <= n; ++i)
//        {
//        if (d.find(i) == i) ans++;
//        }
//        cout << ans << endl;
//        }
