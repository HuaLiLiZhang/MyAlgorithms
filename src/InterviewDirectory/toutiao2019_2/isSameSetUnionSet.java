package InterviewDirectory.toutiao2019_2;

import java.util.*;

/**
 * Created by huali on 2018/8/25.
 */
public class isSameSetUnionSet {
//    一个团队有10个人，每一行代表这个人认识那个人，如果相互认识，则在一组，或者a->c，c->b，那么a->b，abc也很快认识，也在一组
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

class WeightedQuickUnion {  //思路与此题一样。
//    加权快速合并(Weighted quick-union)
//数据结构
//与快速合并类似，但是维护了一个额外的数组sz[i],它包含了以i为根节点的树的节点数量。
//
//查找
//与快速合并完全相同
//
//合并
//将小树指向大树的根节点
//更新sz[]数组

    private static int [] id ;
    private static int[] sz;//size of compoent for roots
    private static int count;//number of components

    //public static void main(String[] args)
    //{
    //    Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt(); //14
    //    id = new int[n];
    //    sz = new int[n];
    //    for(int i = 0;i<n;i++)
    //    {
    //        id[i] = i;
    //        sz[i] = 1;
    //    }
    //    count = n;
    //    //14
    //    //7
    //    int [] inputs = {0,1,9,4,9,6,6,7,8,9,10,12,10,11};
    //    //int [] inputs = {0,1,9,4,9,6,6,7,8,9};
    //    for(int i = 0;i<n;i++)
    //    {
    //        if(!isSameset(i,inputs[i]))
    //        {
    //            Union(i,inputs[i]);
    //            count--;
    //        }
    //    }
    //    System.out.println(count);
    //}

    private static void Union(int p, int q) {
        int pvalue = root(p);
        int qvalue = root(q);
        if(pvalue==qvalue)
            return ;
        if(sz[pvalue]<sz[qvalue])
        {
            id[pvalue] = qvalue;
            sz[qvalue]+=sz[pvalue];
        }else {
            id[qvalue] = pvalue;
            sz[pvalue] +=sz[qvalue];
        }
    }

    private static boolean isSameset(int p, int q) {
        return root(p)==root(q);
    }

    private static int root(int p) {
        while (p!=id[p])
            p = id[p];//p和id[p] 一起更新
        return p;
    }
}