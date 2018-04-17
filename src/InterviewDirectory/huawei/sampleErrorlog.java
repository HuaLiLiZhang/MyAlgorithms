package InterviewDirectory.huawei;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by huali on 2018/4/17.
 */
public class sampleErrorlog {
    //开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
    //处理:
    //1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
    //2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
    //3.输入的文件可能带路径，记录文件名称不能带路径
    public static  void main(String []args) {
        Scanner sr = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();  //LinkedHashMap
        do {

            String str = sr.next();
            int index = sr.nextInt();
            int in  = str.lastIndexOf('\\');
            str = str.substring(in+1, str.length()) + " " + index;
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }

        } while (sr.hasNext());
        sr.close();
        //对记录排序
        //对记录进行排序
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            //降序
            @Override
            public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
                return (arg1.getValue() - arg0.getValue()) == 0 ? (arg0.getValue() - arg1.getValue()) : (arg1.getValue() - arg0.getValue());
            }
        });
        //只输出前8条
        int m = 0;
        for (Map.Entry<String, Integer> mapping : list) {
            m++;
            if (m <= 8) {
                String[] str = mapping.getKey().split(" ");
                String k = str[0].length() > 16 ? str[0].substring(str[0].length() - 16) : str[0];
                String n = str[1];
                System.out.println(k + " " + n + " " + mapping.getValue());
            } else {
                break;
            }
        }
    }
    //public static  void main(String []args) {
    //    Scanner sr = new Scanner(System.in);
    //    HashMap<String, Integer> map = new LinkedHashMap<>();
    //    do {
    //
    //        String str = sr.next();
    //        int index = sr.nextInt();
    //        int in  = str.lastIndexOf('\\');
    //        str = str.substring(in+1, str.length()) + " " + index;
    //        if (map.containsKey(str)) {
    //            map.put(str, map.get(str) + 1);
    //        } else {
    //            map.put(str, 1);
    //        }
    //
    //    } while (sr.hasNext());
    //    sr.close();
    //    //对记录排序
    //    //对记录进行排序
    //    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
    //    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
    //        //降序
    //        @Override
    //        public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
    //            return (arg1.getValue() - arg0.getValue()) == 0 ? (arg0.getValue() - arg1.getValue()) : (arg1.getValue() - arg0.getValue());
    //        }
    //    });
    //    //只输出前8条
    //    int m = 0;
    //    for (Map.Entry<String, Integer> mapping : list) {
    //        m++;
    //        if (m <= 8) {
    //            String[] str = mapping.getKey().split(" ");
    //            String k = str[0].length() > 16 ? str[0].substring(str[0].length() - 16) : str[0];
    //            String n = str[1];
    //            System.out.println(k + " " + n + " " + mapping.getValue());
    //        } else {
    //            break;
    //        }
    //    }
    //
    //}
}