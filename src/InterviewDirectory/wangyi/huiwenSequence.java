package InterviewDirectory.wangyi;

import java.util.Scanner;

/**
 * Created by huali on 2018/4/25.
 */
public class huiwenSequence {
    public static void main(String[] args)
    {
        Scanner sr = new Scanner(System.in);
        while(sr.hasNext())
        {
            int num = sr.nextInt();
            if(num<1||num>50)
                break;
            int [] arr = new int[num];
            for(int i =0;i<num;i++)
            {
                arr[i] = sr.nextInt();
                if(arr[i]>10000||arr[i]<1)
                    break;
            }
            int count = 0;
            int head = 0;
            int tail = num-1;
            while (head < tail)
            {
                if(arr[head]>arr[tail])
                {
                    arr[--tail] += arr[tail+1];
                    count++;
                }
                else if(arr[head]<arr[tail])
                {
                    arr[++head] += arr[head-1];
                    count++;
                }else {
                    head++;
                    tail--;
                }
            }
            System.out.println(count);

        }
        sr.close();
    }
}