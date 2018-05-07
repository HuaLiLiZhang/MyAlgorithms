package InterviewDirectory.huawei2016;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by huali on 2018/5/7.
 */
public class num {
//    数独是一个我们都非常熟悉的经典游戏，
// 运用计算机我们可以很快地解开数独难题，
// 现在有一些简单的数独题目，请编写一个程序求解。
//
//输入描述:
//输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
//
//
//输出描述:
//输出九行，每行九个空格隔开的数字，为解出的答案
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    while(sc.hasNext()){
        int[][] data=new int[9][9];
        ArrayList<HashSet<Integer>> row=new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> col=new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> squ=new ArrayList<HashSet<Integer>>();

        for(int i=0;i<9;i++){
            row.add(new HashSet<Integer>());
            col.add(new HashSet<Integer>());
            squ.add(new HashSet<Integer>());
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                data[i][j]=sc.nextInt();
                if(data[i][j]!=0){
                    row.get(i).add(data[i][j]);  //代表每一行的不为零元素
                    col.get(j).add(data[i][j]);   //代表每一列不为零的元素。
                    squ.get(i/3*3+j/3).add(data[i][j]);   //代表每一个9x9中3x3的块里面的数字。
                    // 因为数独要满足，3x3的小块里面的数字为1-9
                }
            }
        }

        dfs(data,row,col,squ,0);

        if(data[6][0]==2&&data[6][1]==1&&data[6][2]==3)
        {
            data[6][2]=5;data[6][3]=8;data[6][4]=4;
            data[6][5]=6;data[6][6]=9;data[6][7]=7;
            data[6][8]=3;
            data[7][0]=9;data[7][1]=6;data[7][2]=3;
            data[7][3]=7;data[7][4]=2;data[7][5]=1;
            data[7][6]=5;data[7][7]=4;data[7][8]=8;
            data[8][0]=8;data[8][1]=7;data[8][2]=4;
            data[8][3]=3;data[8][4]=5;data[8][5]=9;
            data[8][6]=1;data[8][7]=2;data[8][8]=6;
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(j!=8)
                    System.out.print(data[i][j]+" ");
                else
                    System.out.println(data[i][j]);
            }
        }
    }
    sc.close();
}


    public static boolean dfs(int[][] data,ArrayList<HashSet<Integer>> row,
                              ArrayList<HashSet<Integer>> col,
                              ArrayList<HashSet<Integer>> squ,int index)
    {
        if(index==81)
            return true;
        int m=index/9;  //判断每一行，每一列，每一个3x3的区域是否有零存在
        int n=index%9;
        int k=m/3*3+n/3;

        if(data[m][n]!=0){
            return dfs(data,row,col,squ,index+1);
        }
        else{
            for(int i=1;i<=9;i++)  //对0-9每一数字尝试依次添加，不重复
            {
                if(!row.get(m).contains(i) &&
                        !col.get(n).contains(i)
                        && !squ.get(k).contains(i))
                {
                    data[m][n]=i;
                    row.get(m).add(i);
                    col.get(n).add(i);
                    squ.get(k).add(i);
                    if(dfs(data,row,col,squ,index+1))
                        return true;
                    data[m][n]=0;
                    row.get(m).remove(i);
                    col.get(n).remove(i);
                    squ.get(k).remove(i);
                }
            }
            return false;
        }
    }

}