package InterviewDirectory.ali2019;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/7.
 */
public class MInlength {

    //题目描述：
    //题目描述：
    //小广附近有家盒马店，该店提供配送服务，配送范围是系统根据各项指标决策出的一个多边形，
    // 假设小广现在的位置为（x,y），请问小广是否在该盒马店的配送范围内，
    // 如果不在配送范围内请问他要最少要走多少距离才能到盒马店配送范围内。
    // 假设坐标点在二维平面上，不考虑地球曲率等因素。
    //输入：
    //x,y(代表小广所在的位置，x表示横坐标，y表示纵坐标)
    //x1,y1,x2,y2,x3,y3....xn,yn(代表该盒马店的配送范围多边形，
    // 其中x表示横坐标，y表示纵坐标，xi和yi代表多边形一个点，
    // 点与点按顺序相连形成边，并且最后一个点(xn,yn)与第一个点(x1,y1)相连）
    //输出：
    //请问小广是否在盒马店的配送范围内，
    // 如果不在配送范围内请问他要最少走多少距离才能到盒马店配送范围内，
    // 输出结果为整数（四舍五入）
    //举例说明：
    //输入：
    //1,1
    //0,0,0,2,2,2,2,0
    //输出：
    //yes,0
    //输入：
    //2,2
    //0,0,0,2,2,2,2,0
    //输出：
    //yes,0
    //输入：
    //3,0
    //0,0,0,2,2,2,2,0
    //输出：
    //no,1
    //输入：
    //3,4
    //0,0,0,2,2,2,2,0
    //输出：
    //no,2


    //先求出最大的多边形，然后判断点的距离。
    private final double EPS = Math.pow(10, -6);

    private double[] coordinates;   //存放坐标点,e.g.[x0,y0,x1,y1,...]
    private List<Integer> ptsIdx = new LinkedList<>();

    public MInlength(double[] coordinates) {
        this.coordinates = coordinates;
        if (coordinates.length % 2 != 0)
            throw new IllegalArgumentException("坐标点coordinates长度必须是偶数");
        for (int i = 0; i < coordinates.length / 2; i++) ptsIdx.add(i);
    }
    public double[] run() {
        List<Integer> res = getMaxPolygon(ptsIdx);
        double[] validPts = new double[res.size() * 2];
        for (int i = 0; i < res.size(); i++) {
            validPts[i * 2] = coordinates[res.get(i) * 2];
            validPts[i * 2 + 1] = coordinates[res.get(i) * 2 + 1];
        }
        return validPts;
    }
    private List<Integer> getMaxPolygon(List<Integer> ptsIdx) {
        if (ptsIdx.size() == 3) {
            int[] idx = new int[]{ptsIdx.remove(0), ptsIdx.remove(0), ptsIdx.remove(0)};
            //生成两个向量
            double[] vectors = makeVector(idx[0], new Integer[]{idx[1], idx[2]}); // 0 -> 1, 0 -> 2
            //求交叉积
            int res = cross_mul_sign(vectors[0], vectors[1], vectors[2], vectors[3]);
            switch (res) {
                case -1: //保证点是顺时针顺序
                    ptsIdx.add(idx[0]);
                    ptsIdx.add(idx[1]);
                    ptsIdx.add(idx[2]);
                    break;
                case 1:
                    ptsIdx.add(idx[0]);
                    ptsIdx.add(idx[2]);
                    ptsIdx.add(idx[1]);
                    break;
                case 0: //在同一条直线上，去掉中间的点
                    int minIdx = 0, maxIdx = 0;
                    if (coordinates[idx[0] * 2] == coordinates[idx[1] * 2]) { //x 相同
                        for (int i = 1; i < idx.length; i++) {
                            if (coordinates[idx[minIdx] * 2 + 1] > coordinates[idx[i] * 2 + 1]) minIdx = i;
                            if (coordinates[idx[maxIdx] * 2 + 1] < coordinates[idx[i] * 2 + 1]) maxIdx = i;
                        }
                    } else {
                        for (int i = 1; i < idx.length; i++) {
                            if (coordinates[idx[minIdx] * 2] > coordinates[idx[i] * 2]) minIdx = i;
                            if (coordinates[idx[maxIdx] * 2] < coordinates[idx[i] * 2]) maxIdx = i;
                        }
                    }
                    ptsIdx.add(idx[minIdx]);
                    ptsIdx.add(idx[maxIdx]);
                    break;
            }
            return ptsIdx;
        } else {
            int firstIdx = ptsIdx.remove(0);
            List<Integer> poly_point_idx = getMaxPolygon(ptsIdx);
            double[] vectors = makeVector(firstIdx, poly_point_idx.toArray(new Integer[poly_point_idx.size()]));
            int[] cm_results = cross_mul_sign(vectors);

            int first_01 = -1, last_01 = -1; //寻找连续0或者1序列的起点和终点
            for (int i = 0; i < cm_results.length; i++) { //把数组看成一个环?0:
                if (first_01 == -1 && cm_results[i] >= 0 && cm_results[i == 0 ? cm_results.length - 1 : i - 1] < 0)
                    first_01 = i;
                if (last_01 == -1 && cm_results[i] >= 0 && (cm_results[0] < 0 || cm_results[i + 1 == cm_results.length ? 0 : i + 1] < 0))
                    last_01 = i;
                if (last_01 > -1 && first_01 > -1) break;
            }

            //元素全部是负数，那么这个单点肯定在已知多边形的内部；这个单点应该直接抛弃；
            if (first_01 == -1 || last_01 == -1)
                return poly_point_idx;
            //如果只有一个零，其它都是负数，那么这个单点一定在对应的边上；这个单点也应该直接抛弃；
            if (first_01 == last_01 && cm_results[first_01] == 0)
                return poly_point_idx;

            // 如果有一个或者多个连续的正数或者0，那么这个单点一定在这几条连续边的外面
            // 如果只有一个单独的正数叉乘结果，那就不需要删除任何原来的顶点，而仅需要将新的单点插入即可。
            int cnt_should_delete = last_01 - first_01;
            if (cnt_should_delete < 0)
                cnt_should_delete = poly_point_idx.size() - first_01 + last_01;
            //将firstIdx插入到poly_point_idx的first_01后面
            poly_point_idx.add(first_01 + 1, firstIdx);
            for (int i = 0; i < cnt_should_delete; i++) {
                int idx2del = first_01 + 2; //remove the points between first01 and last01
                if (idx2del >= poly_point_idx.size()) idx2del = 0;
                poly_point_idx.remove(idx2del);
            }

            return poly_point_idx;
        }
    }

    public static void main(String[] args) {

        //double[] test = new double[]{3, 0, 0, 0, 3, 3, 0, 3, 3, 4};


        Scanner sc = new Scanner(System.in);
        String s0 = sc.nextLine();
        String st0[] = s0.split(",");
        int x0 = Integer.parseInt(st0[0]);
        int y0 = Integer.parseInt(st0[1]);

        String s = sc.nextLine();
        String str[] = s.split(",");
//0,5
//3,0,0,0,3,3,0,3,3,4
//no,2 我的代码错误是：no,1

//        用面积计算，求最短距离。
//1,1
//0,0,0,2,2,2,2,0
//yes,0
//2,2
//0,0,0,2,2,2,2,0
//yes,0
//3,0
//0,0,0,2,2,2,2,0
//no,1
//3,4
//0,0,0,2,2,2,2,0
//no,2

        double[] test = new double[str.length];
        for(int i = 0;i<str.length;i++)
        {
            test[i] = Integer.parseInt(str[i]);
        }
        MInlength mcp = new MInlength(test);

        double[] res = mcp.run();
        //System.out.println();
        //res中存储最大的四边形。
        //for (double v : res) System.out.print(v + " ");
        double x = Integer.MAX_VALUE;
        double y = Integer.MAX_VALUE;
        double re = Integer.MAX_VALUE;
        for(int i = 0;i<res.length;i+=2)
        {
            //x = Math.min(x0-res[i],x);
            //y = Math.min(y0-res[i+1],y);
            re =  Math.min(Math.max(x0-res[i],y0-res[i+1]),re);
        }

        if(re>0)
            System.out.println("no,"+(int) Math.floor(re));
        else
            System.out.println("yes,0");

    }

    private double[] makeVector(int idx_fromPoint, Integer[] idx_toPoints) {
        double[] vectors = new double[idx_toPoints.length * 2];
        for (int i = 0; i < idx_toPoints.length; i++) {
            vectors[i * 2] = coordinates[idx_toPoints[i] * 2] - coordinates[idx_fromPoint * 2];
            vectors[i * 2 + 1] = coordinates[idx_toPoints[i] * 2 + 1] - coordinates[idx_fromPoint * 2 + 1];
        }
        return vectors;
    }
    public double[] makeVector(int idx_fromX, int idx_formY, int idx_toX, int idx_toY) {
        return new double[]{coordinates[idx_toX] - coordinates[idx_fromX],
                coordinates[idx_toY] - coordinates[idx_formY]};
    }
    private int[] cross_mul_sign(double[] vectors) {
        int[] res = new int[vectors.length / 2];
        for (int i = 0; i < res.length - 1; i++) {
            int idx = i * 2;
            res[i] = cross_mul_sign(vectors[idx], vectors[idx + 1], vectors[idx + 2], vectors[idx + 3]);
        }
        res[res.length - 1] = cross_mul_sign(vectors[vectors.length - 2], vectors[vectors.length - 1], vectors[0], vectors[1]);
        return res;
    }
    private int cross_mul_sign(double x0, double y0, double x1, double y1) {
        double res = x0 * y1 - y0 * x1;
        return res < 0 ? -1 : res > EPS ? 1 : 0;
    }

}