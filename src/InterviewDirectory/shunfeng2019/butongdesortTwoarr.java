package InterviewDirectory.shunfeng2019;

import java.util.*;

/**
 * Created by huali on 2018/9/17.
 */
public class butongdesortTwoarr {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr0 = new int[n];
        int []arr1 = new int[n];
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for(int i = 0;i<2*n;i++)
        {
            if(i<n)
            {
                arr0[i] = sc.nextInt();
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr0[i],list);
            }else
            {
                arr1[i-n] = sc.nextInt();
                if(map.containsKey(arr1[i-n]))
                {
                    int j = map.get(arr1[i-n]).get(0);
                    map.get(arr0[i-n]).add(j);
                }
            }
        }
        int count =0;
        for(int i = 0;i<map.size();i++)
        {
            int m0 = arr0[i] ;
            int m1 = arr1[i];
            List<Integer> list0 = map.get(m0);
            List<Integer> list1 = map.get(m1);
            if(list0==null||list1==null||list0.size()!=list1.size())
                continue;
            if((list0.get(0)>list0.get(1)&&list1.get(0)<list1.get(1))||
                    (list0.get(0)<list0.get(1)&&list1.get(0)>list1.get(1)))
                count++;

        }
        System.out.println(count);

    }
}