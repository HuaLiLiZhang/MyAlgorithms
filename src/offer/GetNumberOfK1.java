package offer;

/**
 * Created by huali on 2018/6/29.
 */
public class GetNumberOfK1 {
    public int GetNumberOfK(int []array,int k)
    {
        int count = 0;
        for (int i=0;i<array.length;i++)
        {
            if(array[i]==k)
                count++;
        }
        return count ;
    }

}


