package InterviewDirectory.toutiao2019_2;

import java.util.Scanner;

/**
 * Created by huali on 2018/8/25.
 */
public class num1 {
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
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        sc.nextLine();
        for(int i = 0;i<n;i++)
        {
            String temp = sc.nextLine();
            String [] a = temp.split(" ");
            for(int j = 0;j<a.length;j++)
            {
                arr[i][j] = Integer.parseInt(a[j]);
            }
        }
    //    并查集

        System.out.println(arr);

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
