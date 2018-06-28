package offer;

/**
 * Created by huali on 2018/6/28.
 */
public class NumberOf1Between1AndN_Solution1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int i=1;
        int low = 0;
        int high = 0;
        int count1 = 0;
        int current = 0;

        while ((n/i)!=0)
        {
            current = (n/i)%10;
            high  = n/(i*10);
            low = n-(n/i)*i;
            if(current==0)
                count1 += high*i;
            else if(current==1)
            {
                count1 +=high*i+low +1;
            }
            else
                count1 +=(high+1)*i;
            i = i*10;

        }
        return count1;
    }

    public static void main(String []args)
    {
        System.out.println(new NumberOf1Between1AndN_Solution1().NumberOf1Between1AndN_Solution(45));
    }
}