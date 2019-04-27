package InterviewDirectory.nowcode_middle.String1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huali on 2018/10/10.
 */
public class mozhangqianghua {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(sc.nextInt());
        }

        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i<m;i++)
        {
            if(list.size()==1)
                break;
            int minindex = findminindexx(list);
            if(minindex>0&&minindex+1<list.size()&&minindex-1>=0)
            {
                int t = Math.min(list.get(minindex+1),list.get(minindex-1))+list.get(minindex);
                if(list.get(minindex+1)>list.get(minindex-1))
                {
                    for(int j = 0;j<list.size();j++)
                    {
                        if(j==minindex-1)
                        {
                            temp.add(t);
                            j++;
                        }else
                            temp.add(list.get(j));
                    }
                }else {
                    for(int j = 0;j<list.size();j++)
                    {
                        if(j==minindex)
                        {
                            temp.add(t);
                            j++;
                        }else
                            temp.add(list.get(j));
                    }
                }
            }
            else if(minindex==0&&minindex+1<list.size()){
                temp.add(list.get(0)+list.get(1));
                for(int j = 2;j<list.size();j++)
                {
                    temp.add(list.get(j));
                }
            }
            else if(minindex==list.size()-1&&minindex-1>=0){
                temp.add(list.get(list.size()-1)+list.get(list.size()-2));
                for(int j = 0;j<list.size()-2;j++)
                {
                    temp.add(list.get(j));
                }
            }
            list = new ArrayList<>(temp);
            temp = new ArrayList<>();
            if(list.size()==1)
                break;
        }
        System.out.println(list.get(findminindexx(list)));

    }

    private static int findminindexx(List<Integer> list) {
        int indexmin = 0;
        int min = list.get(0);
        for(int i =1;i< list.size();i++)
        {
            if(min>list.get(i))
            {
                min = list.get((i));
                indexmin = i;
            }
        }
        return indexmin;
    }
}