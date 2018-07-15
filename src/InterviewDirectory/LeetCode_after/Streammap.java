package InterviewDirectory.LeetCode_after;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by huali on 2018/7/14.
 */
public class Streammap {
    public static void main(String[] args)
    {
        List<String> strings = Arrays.asList("abc","fsdfs","jsdf","") ;
        // 获取空字符串的数量
        long count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println(count);


        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList =
                numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);



        //Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。
        // 以下代码片段使用 forEach 输出了10个随机数：

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        random.ints().limit(10).sorted().forEach(System.out::println);


        //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：

        List<String>strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered =
                strings1.stream().filter(string -> !string.isEmpty()).
                        collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString =
                strings1.stream().filter(string -> !string.isEmpty()).
                        collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);


    }
}