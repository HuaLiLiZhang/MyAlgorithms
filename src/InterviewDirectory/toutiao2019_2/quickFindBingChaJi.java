package InterviewDirectory.toutiao2019_2;

/**
 * Created by huali on 2018/9/1.
 */
public class quickFindBingChaJi {
    //并查集： 就是有“合并集合”和“查找集合中的元素”两种操作的关于数据结构的一种算法

    //连接两个对象
    //判断是否这两个对象是连接的

    //1.快速查找，这里用到的数据结构是数组
    //对象索引整数数组，用索引来表示N个对象，0表示第一个对象，以此类推。
    //如果p和q是连接的，那么它们数组的值相同。
    //初始化一个索引数组：index：0 1 2 3 4 5 6 7 8 9
    //                  value: 0 1 2 3 4 5 6 7 8 9

    //然后输入需要判断联通的数组：
    //index：0 1 2 3 4 5 6 7 8 9
    //value: 0,1,9,4,9,6,6,7,8,9



    private static int []id;

    public static void main(String[] args)
    {

        int [] input = {0,1,9,4,9,6,6,7,8,9};
        int n = input.length;

        id = new int[n];
        for(int i = 0;i<n;i++)
        {
            id[i]=i;//初始化
        }

        for(int i = 0;i<input.length;i++)
        {
            if(!connected(i,input[i]))
            {
                union(i, input[i]);
                //每连通一个就会减少。
                n--;
            }
        }
        System.out.println(n);
    }

    //将其进行联通的标识，pid !=qid
    //那么每次进行联通，将id[i]=pid的id[i]=qid，
    //就是如果3->4,4->9，那么3->9，据将index= 3的位置标识为9.
    private static void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0;i<id.length;i++)
        {
            if(id[i]==pid)
                id[i] = qid;
        }
    }

    //id数组中的索引所对应的值相等，代表联通，不相等的话，在将他们连接起来。
    private static boolean connected(int p, int q) {
        return id[p]==id[q];
    }
}