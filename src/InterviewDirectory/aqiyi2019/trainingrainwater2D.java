package InterviewDirectory.aqiyi2019;

import java.util.PriorityQueue;

/**
 * Created by huali on 2018/9/22.
 */
public class trainingrainwater2D {
    //Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
    // compute the volume of water it is able to trap after raining.
    //
    //Note:
    //Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
    //
    //Example:
    //
    //Given the following 3x6 height map:
    //[
    //  [1,4,3,1,3,2],
    //  [3,2,1,3,2,4],
    //  [2,3,3,2,3,1]
    //]
    //
    //Return 4.

    //所以这题的思想是：
    //1、构造一个优先队列，每次都取出高度最矮的一个。
    //2、首先将四周的桩都加入，因为记得四周是无法盛水的
    //3、每次从优先队列中取出一个最矮的cell，若他比未访问过的四周的四个高了delta h，
    // 那么总的盛水量多加delta h，否则不加，注意四周只要一访问过下次就不能访问了。
    //
    //因为若当前cell被取出，且其某个邻居cell-n高度低于cell，
    // 那么可以得出：cell-n的邻居里面最矮的就是cell，所以cell可以决定cell-n的盛水量。
    static int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args)
    {
        int [][] heightmap  = {{1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}};
        int res = trapRainWater(heightmap);
        System.out.println(res);
    }

    private static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = m==0?0:heightMap[0].length;
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);//优先队列中放入数组，这些数组要进行排序
        //排序的准则是，数组中存的是前两个是位置，第三个是当前的高度，a[2]，a[2]-b[2]表示按照高度升序排序。
        boolean[][] visited = new boolean[m][n];

        for(int i = 0;i<m;i++)
        {
            pq.offer(new int[] {i,0,heightMap[i][0]});
            pq.offer(new int[] {i,n-1,heightMap[i][n-1]});
            visited[i][0] = visited[i][n-1] = true;
        }
        //将第一列和最后一列的位置和高度加入到优先队列
        for(int j = 1;j<n-1;j++)
        {
            pq.offer(new int[]{0,j,heightMap[0][j]});
            pq.offer(new int[] {m-1,j,heightMap[m-1][j]});
            visited[0][j] = visited[m-1][j] = true;
        }
        //将第一行和最后一行的位置和高度加入优先队列。
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();  //取出第一个元素，表示高度最低的那个位置开始向四周遍历。

            for (int[] d : dirs) {
                int i = cell[0] + d[0], j = cell[1] + d[1];
                //从这个位置开始向四周每个位置开始遍历{1, 0}, {-1, 0}, {0, 1}, {0, -1}。
                if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) continue;  //如果越界或者已经遍历，那么continue
                res += Math.max(0, cell[2] - heightMap[i][j]);  //否则的话，res 求和，
                // 如果四周的高度比当前位置矮的话，那么当前的位置比其他四周的位置（除了边界和已经遍历过的位置）都高的话，
                // 肯定能存储cell[2] - heightMap[i][j]那么多的水
                //
                pq.offer(new int[] {i, j, Math.max(heightMap[i][j], cell[2])});
                //如果四周的高度比当前位置矮的话，然后在把当前位置的周围位置都设置成当前位置的高度，因为水的存储cell[2] - heightMap[i][j]
                //或者不能存水，此时设置为heightMap[i][j]，因为cell[2]的高度都不能存水。
                visited[i][j] = true;
            //    计算完之后就将此位置设置为true，表示已经遍历过。
            }
        }
        return res;
    }
}