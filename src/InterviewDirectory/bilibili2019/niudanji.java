package InterviewDirectory.bilibili2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/9/21.
 */
public class niudanji {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        List<List<String>> re = new ArrayList<>();
        dfs(n, 0, list,re);
        int index =0 ;
        int max = Integer.MAX_VALUE;
        for(int i = 0;i<re.size();i++)
        {
            if(re.get(i).size()<max)
            {
                index  = i;
                max = re.get(i).size();
            }
        }
        for(int i = 0;i<re.get(index).size();i++)
        {
            System.out.print(re.get(index).get(i));
        }
        System.out.println();

    }

    private static void dfs(int n, int start, List<String> list, List<List<String>> re) {
        if(start*2+2==n)
        {
            list.add("3");
            List<String> temp = new ArrayList<>(list);
            re.add(temp);
            return;
        }
        if(start*2+1==n)
        {
            list.add("2");
            List<String> temp = new ArrayList<>(list);
            re.add(temp);
            return;
        }
        else {
           if(start*2+1<n)
           {
               list.add("2");
               dfs(n, start*2+1,list,re);
               list.remove(list.size()-1);
           }
            if(start*2+2<n)
            {
                list.add("3");
                dfs(n, start*2+2,list,re);
                list.remove(list.size()-1);
            }
        }
        return ;
    }
}