package InterviewDirectory.xiecheng2019;

import java.util.*;

/**
 * Created by huali on 2018/9/4.
 */
public class shijianduantitle {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        long A = sc.nextInt();
        sc.nextLine();
        int count = 0;
        int [][] arr = new int[N][3];
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<N;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();

            if(arr[i][1]<=A&&arr[i][2]>=A)
            {
                list.add(arr[i][0]);
            }
            sc.nextLine();
        }

        if(list.size()==0)
            System.out.println("null");
        else {
            Collections.sort(list);
            for(int i = 0;i<list.size();i++)
                System.out.println(list.get(i));
        }
        sc.close();
    }
}