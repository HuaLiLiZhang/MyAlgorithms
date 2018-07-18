package InterviewDirectory.Tencent2018;

import java.util.*;

/**
 * Created by huali on 2018/7/16.
 */
public class test {
    public static void main(String[] args)
    {
        /*Map map0 = new HashMap();
        map0.put(1l, "abc"); // 1l就会转为Long类型存进去
        System.out.println(map0.get(1)); // 1 就会当做Integer类型


        Map map = new HashMap();
        map.put(1l, "abc");
        Long a = 1l;
        Integer b = 1;
        Set set = map.keySet();
        for (Object object : set) {
            System.out.println(object instanceof Long); //true
        }
        System.out.println(a.hashCode() == b.hashCode()); //true ，存在同一个桶里面
        System.out.println(a.equals(b)); //false 同一个桶的链表两个元素
        System.out.println(map.get(1)); // null

        List<? super Object> list = new ArrayList<>();
        list.add("afdsfd");
        list.add(2131);
        list.add('a');
        list.add(true);
        System.out.println(list);

        List<?> list1 = new ArrayList<>(Arrays.asList("234","sfgg"));
        //System.out.println(list1.get(0));
        //System.out.println(list1.get(1));

        Arrays.asList("a","af","ffdsg").
                stream().filter(x->!x.equals("a")).forEach(System.out::println);

*/
        testAllocation();
    }

    private static final int _1MB = 1024*1024;
    /**
     * VM ARGS: -verbose:gc - Xms20m -Xmx20m -Xmn10m - XX:SurvivorRatio=8 -XX:+PrintGCDetails
     */
    public static void testAllocation(){
        byte[] allocation1, allocation2,allocation3 ,allocation4;
        allocation1 = new byte [2 * _1MB];
        allocation2 = new byte [2 * _1MB];
        allocation3 = new byte [2 * _1MB];
        allocation4 = new byte [4 * _1MB];
    }
}