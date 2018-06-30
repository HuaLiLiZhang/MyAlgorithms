package offer;

/**
 * Created by huali on 2018/6/29.
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        int [] tmp = new int[index];
        tmp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int count = 1;
        while (count<index)
        {
            int min = findmin(tmp[index2]*2,tmp[index3]*3,tmp[index5]*5);
            tmp[count] = min;
            while (tmp[index2]*2<=min)
                index2++;
            while (tmp[index3]*3<=min)
                index3++;
            while (tmp[index5]*5<=min)
                index5++;
            count++;
        }

        return tmp[index-1];
    }

    private int findmin(int i1, int i2, int i3) {
        int result = i1<i2?i1:i2;
        return result<i3?result:i3;
    }
}