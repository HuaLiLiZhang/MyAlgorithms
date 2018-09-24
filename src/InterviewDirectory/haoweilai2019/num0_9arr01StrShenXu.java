package InterviewDirectory.haoweilai2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/8/28.
 */
public class num0_9arr01StrShenXu {
    //题目描述：
    //对于固定的数组：{0,1,2,3,4,5,6,7,8,9}，
    // 输入布尔数组：  {0,1,1,1,1,1,1,1,1,0}，
    // 0表示对应下标出现也可以不出现，1表示必须出现。
    // 输出所有可能性组合，转化为字符串，并按照字符串升序排序：
//测试用例：
//0 1 1 1 1 1 1 1 1 0
//012345678
//0123456789
//12345678
//123456789


    //思路：利用深度优先遍历，可以找出所有的解
    //start代表开始的位置0，从第一元素，如果arr[i]==1，代表必须选泽，那么加入到Stringbuffer中，
    // 如果为0，可加入可不加入，首先加入，跟前面的arr[i]==1,的情况一样，
    // 然后不加入，那么跳过，stringbuffer不加入相应位置的索引i,不加入不删除，只遍历下一个即可。
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        int []arr = new int[10];
        for(int i = 0;i<st.length;i++)
        {
            arr[i] = Integer.parseInt(st[i]);
        }

        List<String> list = new ArrayList<>();
        StringBuffer strbu = new StringBuffer();
        dfs(arr, 0, list,strbu);
        Collections.sort(list);
        for(String s : list)
            System.out.println(s);

    }

    //dfs：一般找出所有的解，设置条件找到需要的解。
    private static void dfs(int[] arr, int start, List<String> list, StringBuffer strbu) {
        if(start>=arr.length)
        {
            list.add(strbu.toString());
            return ;
        }

        if(arr[start]==1)
        {
            strbu.append(start);  //这个是相应位置为1的情况，所有相连接
            dfs(arr, start+1,list, strbu);
            strbu.deleteCharAt(strbu.length()-1);
        }else {
            // 如果为0，可加入可不加入，首先加入，跟前面的arr[i]==1,的情况一样，
            // 然后不加入，那么跳过，stringbuffer不加入相应位置的索引i,不加入不删除，只遍历下一个即可。
            strbu.append(start);
            dfs(arr,start+1,list,strbu);
            strbu.deleteCharAt(strbu.length()-1);
            dfs(arr, start+1, list, strbu);
        }

        return ;
    }

//    一般有几个0就有2的几次方种可能。
//0 0 1 0 1 1 1 1 1 0
//012345678
//0123456789
//01245678
//012456789
//02345678
//023456789
//0245678
//02456789
//12345678
//123456789
//1245678
//12456789
//2345678
//23456789
//245678
//2456789

    //public static void main(String[] args)
    //{
    //    Scanner sc = new Scanner(System.in);
    //    while (sc.hasNext()) {
    //        int arr[] = {0,1,2,3,4,5,6,7,8,9};
    //        int temp[] = new int[10];
    //        for(int i=0;i<arr.length;i++){
    //            temp[i] = sc.nextInt();
    //        }
    //
    //        StringBuffer stringBuffer = new StringBuffer();
    //        List<String> li = new ArrayList<>();
    //        dfs(li,stringBuffer,0,arr,temp);
    //        Collections.sort(li);
    //        for(int i=0;i<li.size();i++){
    //            System.out.println(li.get(i));
    //        }
    //    }
    //}
    //    private static void dfs(List<String> list, StringBuffer stringBuffer, int i, int[] arr, int[] bo) {
    //    if(i>=arr.length){
    //        list.add(stringBuffer.toString());
    //        return;
    //    }
    //    if(bo[i]==1){
    //        stringBuffer.append(arr[i]);
    //        dfs(list,stringBuffer,i+1,arr,bo);
    //        stringBuffer.deleteCharAt(stringBuffer.length()-1);
    //    }else{
    //        stringBuffer.append(arr[i]);
    //        dfs(list,stringBuffer,i+1,arr,bo);
    //        stringBuffer.deleteCharAt(stringBuffer.length()-1);
    //
    //        dfs(list,stringBuffer,i+1,arr,bo);
    //    }
    //}

}