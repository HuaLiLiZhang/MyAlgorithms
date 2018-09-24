package InterviewDirectory.meituan2019;

import java.util.*;

/**
 * Created by huali on 2018/9/6.
 */
public class connectGraphMinPath {
    //第一题
    //给定一张包含N个点、N-1条边的无向连通图，节点从1到N编号，每条边的长度均为1。
    // 假设你从1号节点出发并打算遍历所有节点，那么总路程至少是多少？
    //输入
    //第一行包含一个整数N，1≤N≤100000。
    //接下来N-1行，每行包含两个整数X和Y，表示X号节点和Y号节点之间有一条边，1≤X，Y≤N。
    //输出
    //输出总路程的最小值。
    //思路：走完所有节点类似于深度优先搜索，也就是说除了最后一条路径外，别的路径都经历了正着走，再返回
    //的过程，也就是两遍，设最后一条路径为x，总分支数为n-1，总路径=2*(n-1-x)+x=2*n-2-x，当x最大时
    //
    //总路径最小，所以转化为求二叉树的深度。

//4
//1 2
//1 3
//3 4


    public static void main(String[] args)
    {
           
    }








    /*public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();
        sc.nextLine();
        int [] lst = new int[N+1];
        Arrays.fill(lst, 0);
        for(int i = 0;i<N-1;i++)  //N 个点，有N-1条边，所以是0——N-2，即N-1个输入
        {
            int start = sc.nextInt();  //边的第一个结点
            int end = sc.nextInt();   //边的第二个结点。
            lst[end] = lst[start]+1;//当前结点的深度。  数组lst记录从某个点开始的最长联通路径
            sc.nextLine();
        }
        int depth = 0;
        for(int i = 1;i<=N;i++)
        {
            depth = lst[i]>depth?lst[i]:depth; //找到最大值，所有路径中最长的联通路径
        }

        System.out.println(2*(N-1)-depth);
        //总路径=2*(N-1)-depth ，代表所有边重复两次，走两次，（边等于点-1，）
        // 减去最长的一天路径（不重复走），则表示最少走的路径


    }*/






}

//#include<bits/stdc++.h>
//using namespace std;
//int lst[100005];
//int main(){
//    int n;
//    while(cin>>n){
//        memset(lst,0,sizeof(lst));
//        for(int i = 0;i<n-1;i++){
//            int a,b;
//            cin>>a>>b;
//            lst[b] = lst[a]+1;//当前节点的深度
//        }
//        int depth = 0;
//        for(int i = 1;i<=n;i++)
//            depth = lst[i]>depth?lst[i]:depth;//找到最大值
//        cout<<2*n-2-depth<<endl;
//    }
//    return 0;
//}