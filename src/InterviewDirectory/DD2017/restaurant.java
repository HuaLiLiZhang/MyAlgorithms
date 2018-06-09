package InterviewDirectory.DD2017;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by huali on 2018/6/7.
 */
public class restaurant {
    public static void main(String []args) {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext()) {
            int n = sr.nextInt();
            int m = sr.nextInt();
            int []tablepeoplenum = new int[n];

            for(int i=0;i<n;i++)
            {
                tablepeoplenum[i]= sr.nextInt();
            }
            int[][] peoplemoney = new int[m][2];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<2;j++)
                {
                    peoplemoney[i][j] = sr.nextInt();
                }
            }
            Arrays.sort(tablepeoplenum);
            Arrays.sort(peoplemoney, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });
            long res = 0L;
            int index = 0;
            boolean[] tableb = new boolean[n];
            for(int i=0;i<m;i++)
            {
                if(peoplemoney[i][0]>tablepeoplenum[n-1])
                    continue;
                index = bs(tablepeoplenum, peoplemoney[i][0]);
                while (index<n&&tableb[index])
                {
                    index++;
                }
                if(index<n)
                {
                    res += peoplemoney[i][1];
                    tableb[index] = true;
                }
            }

            System.out.println(res);


        }
    }

    private static int bs(int[] num, int tar) {
        int low = 0;
        int high = num.length-1;
        int mid = 0;
        while (low<=high)
        {
            mid = (high+low)>>1;
            if(num[mid]>=tar)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}