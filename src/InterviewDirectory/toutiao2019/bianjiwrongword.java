package InterviewDirectory.toutiao2019;

import java.util.*;

/**
 * Created by huali on 2018/8/12.
 */
/*
"""
为了提高文章的质量，每篇文章（假设全是英文）都会有m名编辑进行审核，每个编辑独立工作，会把觉得有问题的句子通过下标记录下来。
比如[1, 10], 1表示病句的第一个字符，10表示并举的最后一个字符，也就是从1到10这101个字符组成的句子，是有问题的。
现在需要把多名编辑有问题的句子合并起来。
A编辑指出是[1, 10],[32, 45]
B:[5, 16], [78, 94]
那么可以合并成[1, 16], [32, 45], [78, 94]
示例：
输入：
3   #3名编辑
1,10;32,45
78,94;5,16
80,100;200,220;16,32
输出：
1,45;78,100;200,220
"""
* */
public class bianjiwrongword {

    public static void main(String[] args)
    {
        int [][] arr = {{1,10},{32,45},{78,94},{5,16}, {80,100},{200,220},{16,32}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++)
        {
            if(list.size()==0)
            {
                list.add(arr[i][0]);
                list.add(arr[i][1]);
            }
            else if(list.get(list.size()-1)<arr[i][0])
            {
                list.add(arr[i][0]);
                list.add(arr[i][1]);
            }else {
                if(list.get(list.size()-1)<arr[i][1])
                {
                    list.remove(list.size()-1);
                    list.add(arr[i][1]);
                }
            }
        }
        for(int i = 0;i<list.size();i++)
        {
            if(i%2!=0&&i!=list.size()-1)
            {
                System.out.print(list.get(i));
                System.out.print(";");
            }
            else if(i%2==0)
            {
                System.out.print(list.get(i));
                System.out.print(",");
            }else
            {
                System.out.print(list.get(i));
            }
        }
    }
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String str = "";
        int count =0;
        for(int i =0;i<m;i++)
        {
            if(i!=m-1)
                str += sc.next()+";";
            else
                str += sc.next();

        }

//3
//1,10;32,45
//78,94;5,16
//80,100;200,220;16,32

        count = str.split(";").length;
        String[] s = str.split(";");
        int[][] arr = new int[count][2];
        for(int i=0;i<count;i++)
        {
            arr[i][0] = Integer.parseInt(s[i].split(",")[0]);
            arr[i][1] = Integer.parseInt(s[i].split(",")[1]);
        }
        //二维数组只比较第一列进行排序,利用比较器，进行一维的比较。
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //System.out.println(arr);
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<count;i++)
        {
            if(i==0)
            {
                list.add(arr[i][0]);
                list.add(arr[i][1]);
            }
            if(!list.isEmpty())
            {
                if(list.get(list.size()-1)>=arr[i][0])
                {
                    //要求得两个区间后面的最大值。Math.max(arr[i][1], list.get(list.size()-1))
                    list.set(list.size()-1, Math.max(arr[i][1], list.get(list.size()-1)));
                }else
                {
                    list.add(arr[i][0]);
                    list.add(arr[i][1]);
                }
            }
        }
        for(int i = 0;i<list.size();i++)
        {
            if(i%2!=0&&i!=list.size()-1)
            {
                System.out.print(list.get(i));
                System.out.print(";");
            }
            else if(i%2==0)
            {
                System.out.print(list.get(i));
                System.out.print(",");
            }else
            {
                System.out.print(list.get(i));
            }
        }

    }*/
}
