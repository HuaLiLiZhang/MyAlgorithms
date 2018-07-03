package offer;

/**
 * Created by huali on 2018/6/30.
 */
public class Sum_Solution {
//    求1+2+3+...+n，
// 要求不能使用乘除法、for、while、if、else、switch、
// case等关键字及条件判断语句（A?B:C）。
    public int sum(int n)
    {
        int sum = n;
        boolean flag = (sum>0)&((sum+=sum(n-1))>0);
        return sum;
    }
}