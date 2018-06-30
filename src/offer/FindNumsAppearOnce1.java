package offer;

/**
 * Created by huali on 2018/6/29.
 */
public class FindNumsAppearOnce1 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int k1 = 0;
        int k2 =0;
        for(int i=0;i<array.length;i++)
        {
            int j=0;
            for(;j<array.length;j++)
            {
                if(j==i)
                    continue;
                int issame = array[i]^array[j];
                if(issame==0)
                {
                    break;
                }
            }
            if(j==array.length&&k1==0)
            {
                k1=i;
            }
            else if(j==array.length&&k2==0)
            {
                k2=i;
            }
        }
        num1[0] = array[k1];
        num2[0] = array[k2];
    }
}