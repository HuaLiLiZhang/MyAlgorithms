package InterviewDirectory.pingduoduo2019_2;

import java.util.Scanner;

/**
 * Created by huali on 2018/8/30.
 */
public class chessBoardooxx {
    //长方形的棋盘，每个格子可能是一下三种情况：
    //A放障碍物，不可移动，B放小木块，C格子为空。
    //如果把棋盘竖起来，小木块会向下掉落，直至落到障碍物上，或者落到障碍物上叠加的小木块，如果底部没有障碍物，则掉出棋盘

    //问：最后棋盘的 状态。

//测试用例:
//3 4
//.oxo
//o..o
//.xox
//
//结果
//..xo
//.o.o
//.x.x

//4 5
//ox.ox
//.ooxo
//..xoo
//oxo..
//.x.ox
//..ox.
//.ox..
//.x...

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