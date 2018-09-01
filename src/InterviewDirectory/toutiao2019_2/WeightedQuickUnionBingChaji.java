package InterviewDirectory.toutiao2019_2;

import java.util.Scanner;

/**
 * Created by huali on 2018/9/1.
 */
public class WeightedQuickUnionBingChaji {
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

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //14
        id = new int[n];
        sz = new int[n];
        for(int i = 0;i<n;i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
        count = n;
        //14
        //7
        int [] inputs = {0,1,9,4,9,6,6,7,8,9,10,12,10,11};
        for(int i = 0;i<n;i++)
        {
            if(!isSameset(i,inputs[i]))
            {
                Union(i,inputs[i]);
                count--;
            }
        }
        System.out.println(count);
    }

    private static void Union(int p, int q) {
        int pvalue = id[p];
        int qvalue = id[q];
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