package InterviewDirectory.offerTwice;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by huali on 2018/8/23.
 */
public class ArraysSort {
    public static void main(String[] args)
    {
        String [] wordlist = {"Pdsgdfgdf","jfsdkjfksdfg","sdfusdf"};
        List<String> output = Arrays.stream(wordlist).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(output);

        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> squareNums = list.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println(squareNums);


        Stream  stream = Stream.of("a","b","c");
        String [] strArray = new String[]{"a","b","c"};
        //stream = Stream.of(strArray);
        //System.out.println(stream);
        //stream = Arrays.stream(strArray);
        //System.out.println(stream);
        List<String> list1 = Arrays.asList(strArray);
        stream  = list1.stream();
        //System.out.println(stream);
        List<String> list2 = (List<String>) stream.collect(Collectors.toList());
        System.out.println(list2);
        //一个 Stream 只可以使用一次
        stream  = list1.stream();
        Set<String> set = (Set<String>) stream.collect(Collectors.toSet());
        System.out.println(set);
        stream  = list1.stream();
        Stack stack = (Stack) stream.collect(Collectors.toCollection(Stack::new));
        System.out.println(stack);
        stream  = list1.stream();
        String str = stream.collect(Collectors.joining()).toString();
        System.out.println(str);


        List<String> list4 = Arrays.asList("a","jjgjf");
        List<String> out  = list4.stream().map(String::toUpperCase).collect(Collectors.toList());

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        //Filtered value: three
        //Mapped value: THREE
        //Filtered value: four
        //Mapped value: FOUR

        List<Integer> list23 = Arrays.asList(1,2,3,4,5);
        Integer sum = list23.stream().reduce(0,(a,b)->(a+b));  //求和
        System.out.println(sum);


        String concat = Stream.of("A","B","C","D").reduce("",String::concat);
        System.out.println(concat);

        double minvalue = Stream.of(-1.5,1.0,-3.0,-2.0).reduce(Double.MAX_VALUE,Double::min);
        System.out.println(minvalue);

        double minvalue1 = Stream.of(-1.5,1.0,-3.0,-2.0).reduce(0.0, Double ::sum);
        System.out.println(minvalue1);

        double minvalue2 = Stream.of(-1.5,1.0,-3.0,-2.0).reduce(Double::sum).get();
        System.out.println(minvalue2);

        concat = Stream.of("a", "B", "c", "D", "e", "F").filter(x->x.compareTo("Z")>0).reduce("",String::concat);
        System.out.println(concat);








        //Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5,1};
        //Arrays.sort(a, 0,3);
        //for(int i : a)
        //    System.out.print(i+" ");
        //
        //Comparator<Integer> c = new myComparator();
        //Arrays.sort(a, 0, 7, new Comparator<Integer>() {
        //    @Override
        //    public int compare(Integer o1, Integer o2) {
        //        return o2-o1;
        //    }
        //});
        //for(Integer ele : a)
        //{
        //    System.out.print(ele +" ");
        //}
    }
}
class myComparator implements Comparator<Integer>{
    @Override
    public int compare (Integer o1, Integer o2)
    {
        return o2-o1;
    }
}