package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/23.
 */
public class hanoi {
    public void hannoi1(int n)
    {
        if(n>0)
            func(n,"left","mid","right");
    }

    /**
     * 步骤1：把圆盘1->i-1从from移动到mid
     * 步骤2.把圆盘i 从from移动到to
     * 步骤3.把圆盘1->i-1从mid移动到to。
     * 如果圆盘只剩下一个，直接将这个圆盘，从from移动到to。
     * @param n
     * @param from
     * @param mid
     * @param to
     */
    public void func(int n ,String from, String mid,String to)
    {
        if(n==1)
            System.out.println("move from "+from+" to "+to);
        else {
            func(n-1,from,to,mid);
            func(1,from,mid,to);
            func(n-1,mid,from,to);
        }
    }

    //求所以移动步数之和。
   //进阶题目：首先求from柱子上的圆盘1->i，如果都移动到to上的最少步骤数，假设为s(i),
   // 根据上面的步骤，s(i) =步骤1的总数+1+步骤3的总数 = s(i-1)+1+s(i-1)
   // s(1) = 1,所以s(i) +1 = 2(s(i-1)+1) ,s(1)+1 ==2;
   // 由等比数列求和：s(i) = 2^i-1

    //递归函数，时间复杂度是：O(N),空间复杂度：O(N)
    public int step1(int[]arr)
    {
        if(arr ==null||arr.length==0)
            return -1;
        return process(arr,arr.length-1, 1,2,3);
    }
    public int process(int[]arr,int i,int from,int mid,int to)
    {
        if(i==-1)
            return 0;
        if(arr[i]!=from&&arr[i]!=to)
            return -1;
        if(arr[1]==from)
        {
            return process(arr,i-1,from,to,mid);
        }else{
            int rest = process(arr,i-1,mid,from,to);
            if(rest==-1)
                return -1;
            return (1<<i)+rest;
        }
    }

    //时间复杂度为O(N)，利用非递归的方法：给定数组int []arr={1,2,2,}
    public int step2(int[]arr)
    {
        if(arr==null||arr.length==0)
        {
            return -1;
        }
        int from = 1;
        int mid = 2;
        int to =3;
        int i =arr.length-1;
        int res = 0;
        int tmp = 0;
        while (i>=0)
        {
            if(arr[i]!=from&&arr[i]!=to)
            {
                return -1;
            }
            if(arr[i]==to)
            {
                res+=1<<i;
                tmp =from;
                from = mid;
            }else {
                tmp = to;
                to = mid;
            }
            mid = tmp;
            i--;
        }
        return res;
    }
}