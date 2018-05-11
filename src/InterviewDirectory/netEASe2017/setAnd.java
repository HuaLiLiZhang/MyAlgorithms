package InterviewDirectory.netEASe2017;

import java.util.ArrayList;

/**
 * Created by huali on 2018/5/11.
 */
public class setAnd {
    //    有两个有序的集合，集合的每个元素都是一段范围，
// 求其交集，例如集合{[4,8],[9,13]}和{[6,12]}的交集为{[6,8],[9,12]}
    public static void main(String[] args) {
        Range r1 = new Range(4, 8);
        Range r2 = new Range(9, 13);
        Range r3 = new Range(6, 12);
        Range r4 = new Range(7, 10);
        Range[] aR = new Range[]{r1, r2};
        Range[] bR = new Range[]{r3, r4};
        ArrayList<Range> result = getrangeset(aR, bR);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static ArrayList<Range> getrangeset(Range[] aR, Range[] bR) {
        ArrayList<Range> ranges = new ArrayList<Range>();
        for (int i = 0; i < bR.length; i++) {
            for (int j = 0; j < aR.length; j++) {
                if (aR[j].right < bR[i].left) {
                    break;  //无交集
                } else if (aR[j].right > bR[i].left) {
                    int left = aR[j].left > bR[i].left ? aR[j].left : bR[i].left;   //选大的那个
                    int right = aR[j].right < bR[i].right ? aR[j].right : bR[i].right;   //选小的那个
                    Range range = new Range(left, right);
                    ranges.add(range);
                }

            }

        }
        return ranges;
    }
}

class Range{
    public int left ;
    public int right;
    Range(int left,int right){
        this.left=left;
        this.right = right;
    }
    @Override
    public String toString()
    {
        return " [left=" + left + ", right=" + right + "]";
    }
}
