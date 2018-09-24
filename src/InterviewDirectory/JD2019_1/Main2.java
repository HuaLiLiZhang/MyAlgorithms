package InterviewDirectory.JD2019_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/9.
 */
public class Main2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int [][]  arr = new int[n][3];
        for(int i = 0;i<n;i++)
        {
            String s = sc.nextLine();
            String[]str = s.split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
            arr[i][2] = Integer.parseInt(str[2]);
        }
        boolean [] find = new boolean[n];
        Arrays.fill(find,false);
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            for(int j = i;j<n;j++)
            {
                if(buhege(arr,i,j,find))
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean buhege(int[][] arr, int i, int j,boolean [] find) {

        if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]&&arr[i][2]<arr[j][2]&&!find[i])
        {
            find[i] = true;
            return true;
        }else if(arr[i][0]>arr[j][0]&&arr[i][1]>arr[j][1]&&arr[i][2]>arr[j][2]&&!find[j])
        {
            find[j] = true;
            return true;
        }
        return false;
    }
}