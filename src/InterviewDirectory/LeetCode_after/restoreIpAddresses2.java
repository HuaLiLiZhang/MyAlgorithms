package InterviewDirectory.LeetCode_after;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huali on 2018/7/18.
 */
public class restoreIpAddresses2 {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> ip = new ArrayList<>();
        dfs(s, res, ip,0);
        return res;
    }

    private void dfs(String s, ArrayList<String> res, ArrayList<String> ip, int start) {
        if(ip.size()==4&&start==s.length())
        {
            res.add(ip.get(0)+"."+ip.get(1)+"."+ip.get(2)+"."+ip.get(3));
            return ;
        }
        if(s.length()-start>3*(4-ip.size()))
            return;
        if(s.length()-start<(4-ip.size()))
            return;
        int num = 0;
        for(int i=start;i<start+3&&i<s.length();i++)
        {
            num = num*10+(s.charAt(i)-'0');
            if(num<0||num>255)
                continue;
            ip.add(s.substring(start,i+1));
            dfs(s, res, ip, i+1);
            ip.remove(ip.size()-1);
            if(num==0)
                break;
        }
    }
    public static void main(String[] args)
    {
        restoreIpAddresses2 re = new restoreIpAddresses2();
        ArrayList<String> arr = re.restoreIpAddresses("25525511135");
        System.out.println(arr);

        //List<Integer> list = new ArrayList<>();
        //list.add(1);
        //list.add(2);
        //list.add(3);
        //list.add(4);
        //list.add(5);

        //System.out.println(arr);
        //List sub = list.subList(1,3);
        //System.out.println(sub);
        //list.add(2,10);
        //System.out.println(list);
        //System.out.println(sub);
    //    修改原list会影响sublist，报错Exception in thread "main" java.util.ConcurrentModificationException
    //    List  sublist = list.subList(1,4);
    //    sublist.add(18);
    //    System.out.println(sublist);
    //    System.out.println(list);
    //    如果修改sublist，也会影响原list，原list也会被修改，不会报错，sublist返回的是list一个镜像。
    //    sublist是返回的list的一个镜像而不是新实例。用来保证原list不被修改
    //    之前的抛异常是因为更改了原来的list而要使用sublist的时候必然报异常。

        //ArrayList<Integer> arr = new ArrayList<>(list.subList(1,3));
        //        //arr.add(10);
        //        //list.add(181);
        //        //System.out.println(list);
        //        //System.out.println(arr);
    }
}