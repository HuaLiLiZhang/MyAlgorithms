package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/20.
 */
public class travelMagickingdom {
        //只要找到最长的一条路径就好，
        // 只要保证最长路径只走一次，
        // 多余的步数再去访问其他节点，
        // 就能计算能够访问的最多节点数。
        //(1) 如果允许走的步数L小于等于最长路径，
        // 那么就直接只在最长路径上走，
        // 这样可以不重复地走完，
        // 步数为走过的边数count，
        // 经过的点数为count+1
        //(2) 如果允许走的步数L大于最长路径，
        // 那么需要走其他的分支，
        // 一旦经过，至少每条边走两次，
        // 并且只要两次就能完成读取点，
        // 所以其他路径上的点数为(L-maxDepth)/2，
        // maxDepth为树的深度，也就是最长路径上的边数。
        // 此时经过的点数为maxDepth+(L-maxDepth)/2+1，如果点数大于n，则输出n，否则直接输出总点数。
        public static void main(String[] args) {
            Scanner sr = new Scanner(System.in);
            int n = sr.nextInt(), L = sr.nextInt();
            int parent[] = new int[n];
            int depth[] = new int[n];
            int maxDepth = 0;
            for (int i = 1; i < n; i++) {
                parent[i] = sr.nextInt();
                depth[i] = depth[parent[i]] + 1;
                if (depth[i] > maxDepth)
                    maxDepth = depth[i];
            }
            sr.close();
            int count = 0;
            if (maxDepth >= L)
                count = L;
            else
                count = (L - maxDepth) / 2 + maxDepth;
            if(count >= n - 1)
                count = n - 1;
            System.out.println(count + 1);

        }
}