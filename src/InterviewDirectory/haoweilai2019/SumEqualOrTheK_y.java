package InterviewDirectory.haoweilai2019;

/**
 * Created by huali on 2018/8/28.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SumEqualOrTheK_y {
    //题目描述：一个等式x+y=x|y（x|y表示或运算），
    // 给定一个正整数x,满足等式的正整数y有很多个，
    // 从第一个开始由小到大数y,给定一个正整数求第K个y是多少。

    //分析：
    //两个数的和等于两个数的或，就是不能发生进位，
    // 也就是x中为1的二进制位，y中一定的为0，
    // 那么计算除去为1的x中的剩下的位数，算出第k大的数字
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t =  sc.nextInt();
        for(int i = 0;i<t;i++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = 0;   //记住：是二进制位。
            int y = 0;
            while (k!=0)
            {
                if((n&1)==0)
                {
                    y += (int) Math.pow(2,m)*(k&1);//看k的m位是否为1,1的话就要计算相加的和
                    k = k>>1;
                    n = n>>1;
                    m++;
                }else {
                    m++;   //如果x的位是1的话，y的这个位为0，不加,然后持续进位。
                    n = n>>1;  //
                }
            }
            System.out.println(y);
        }

        //测试用例：
        //3
        //4 1
        //1
        //4 5
        //9
        //4 9
        //17








        //List<Integer> list = new ArrayList<>();
        //for(int l = 0;l<t;l++)
        //{
        //    int n = sc.nextInt();
        //    int k = sc.nextInt();
        //    int m = 0;
        //    int count = 0;
        //    while (k!=0)
        //    {
        //        if((n&1)==0)
        //        {
        //            count +=(int)Math.pow(2,m)*(k&1);
        //            n = n>>1;
        //            k = k>>1;
        //            m++;
        //        }
        //        else
        //        {
        //            m++;
        //            n = n>>1;
        //        }
        //    }
        //    list.add(count);
        //}
        //for(int i = 0;i<list.size();i++)
        //{
        //    System.out.println(list.get(i));
        //}
        //sc.close();






            //System.out.println(count);
            //for(int j=1;j<Integer.MAX_VALUE;j++)
            //{
            //
            //
            //
            //    if(x+j==(x|j))
            //    {
            //        count++;
            //        if(count==k)
            //        {
            //            System.out.println(j);
            //            break;
            //        }
            //    }
            //}

    }
//    1
//4 2




   /*
    import java.util.Scanner;
    public class Main {
    */
        //public static void main(String[] args) {
        //    Scanner in = new Scanner(System.in);
        //    int t = in.nextInt();
        //    int[][] data = new int[t][2];
        //
        //    for(int i = 0;i<t;i++){
        //        data[i][0] = in.nextInt();
        //        data[i][1] = in.nextInt();
        //    }
        //
        //    for(int i = 0;i<t;i++){
        //        int y = gety(data[i][0],data[i][1]);
        //        System.out.println(y);
        //    }
        //}
        //
        //private static int gety(int i, int j) {
        //    int result = 0;
        //    if(i%2==1){
        //        result=1;
        //        i = i>>1;
        //    }else {
        //        if(j%2==1){
        //            result=1;
        //        }
        //        i = i>>1;
        //        j = j>>1;
        //    }
        //    int addnum = 2;
        //    while(i!=0||j!=0){
        //        if(i%2==0){
        //            if(j%2==1){
        //                result+=addnum;
        //            }
        //            j = j>>1;
        //        }
        //        i = i>>1;
        //        addnum = addnum<<1;
        //    }
        //    return result;
        //}
    //}

}