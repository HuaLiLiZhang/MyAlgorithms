package InterviewDirectory.pingduoduo2019_2;

import java.util.Scanner;

/**
 * Created by huali on 2018/8/30.
 */
public class Main2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        char[][] ch = new char[N][M];
        for(int i = 0;i<N;i++)
        {
            String s = sc.nextLine();
            ch[i] = s.toCharArray();
        }

        for(int j = 0;j<M;j++)
        {
            for(int k = 0;k<N;k++)
            {
                for(int i = k;i<N;i++)
                {
                    while (i<N&&ch[i][j]!='o')
                        i++;
                    if(i>=N)
                        continue;
                    else {
                        int index = i;
                        while (i<N&&ch[i][j]=='o')
                            i++;
                        if(i>N)
                        {
                            ch[index][j] = '.';
                            continue;
                        }

                        while (i<N&&ch[i][j]!='x')
                            i++;
                        if(i>=N)
                            ch[index][j] = '.';
                        else
                        {
                            ch[index][j] = '.';
                            while (i>=0&&ch[i-1][j]=='o')
                                i--;
                            ch[i-1][j] = 'o';

                        }


                    }
                }
            }
        }
        for(int i =0;i<N;i++)
        {
            for(int j = 0;j<M;j++)
            {
                System.out.print(ch[i][j]);
            }
            System.out.println();
        }
    }
}