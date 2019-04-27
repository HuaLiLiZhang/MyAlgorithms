package InterviewDirectory.xiaomi2019;

import java.util.*;

/**
 * Created by huali on 2018/9/20.
 */
public class onlydisplayOnesjinzhi {
//    每行输入一个字符串，第一个数为多少进制，中间用#分开，第二个数为进制下的数值。输出，只出现一次的数
// 输出，只有只出现一次的数。就是这个数值与其他数值都不一样就输出。只出现一次的数。如果都不一样，或者很多不一样，都要输出。
//10#15
//4#32
//4#33
//8#17
//11#12
//12#16
//14#11
//END
//4#32
//11#12
//12#16

//10#15
//4#32
//4#33
//8#17
//END
//4#32



//10#15
//14#11
//4#33
//8#17
//END
//None

   /* public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Map<Integer,List<Integer>> map = new LinkedHashMap<>();
        int sum = 0;
        while (sc.hasNext())
        {
            String temp = sc.nextLine();
            if(temp.equals("END"))
                break;
            else
            {
                list.add(temp);
                String[] str = temp.split("#");
                int jinzhi = Integer.parseInt(str[0]);
                int m = Integer.parseInt(str[1]);
                int N = 0,count=0;
                while (m!=0)
                {
                    N += (m%10)*Math.pow(jinzhi,count);
                    count++;
                    m = m/10;
                }


                if(map.containsKey(N))
                {
                    List<Integer> li = map.get(N);
                    li.add(sum);
                    map.put(N,li);
                }
                else
                {
                    List<Integer> li = new ArrayList<>();
                    li.add(sum);
                    map.put(N,li);
                }
                sum++;


            }
        }
        int count = 0;
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet())
        {
            if(entry.getValue().size()==1) {
                System.out.println(list.get(entry.getValue().get(0)));
                count++;
            }
        }
        if(count==0)
            System.out.println("None");
    }*/



    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            List<String> list = new ArrayList<>();

            while(sc.hasNext()){
                String str = sc.nextLine();
                if(str.equals("END"))break;
                list.add(str);
            }

            int[] shuzhi = new int[list.size()];
            for(int i = 0;i<shuzhi.length;i++){
                String[] temp = list.get(i).split("#");
                shuzhi[i] = Integer.parseInt(temp[1],Integer.parseInt(temp[0]));
                //parseInt(String s, int radix)直接就是进制转换后的十进制的数字
            }

            List<Integer> index = new ArrayList<>();
            boolean[] yishu = new boolean[list.size()];
            Arrays.fill(yishu, true);

            for(int i = 0;i<list.size();i++){
                boolean flag = index.contains(shuzhi[i]);
                if(flag&&yishu[i]){
                    for(int j = 0;j<list.size();j++){
                        if(shuzhi[j]==shuzhi[i]){
                            yishu[j]=false;
                        }
                    }
                }
                if(!flag){
                    index.add(shuzhi[i]);
                }
            }

            for(int i = 0;i<list.size();i++){
                if(yishu[i]){
                    System.out.println(list.get(i));
                }
            }
        }
}