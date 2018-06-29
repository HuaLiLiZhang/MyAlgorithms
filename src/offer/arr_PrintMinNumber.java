package offer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by huali on 2018/6/28.
 */
public class arr_PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        String s = new String();
        if(numbers==null||numbers.length<=0)
            return s;
        ArrayList<String> arr = new ArrayList<>();
        for(int i: numbers)
        {
            arr.add(String.valueOf(i));
        }
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                int result = a.compareTo(b);
                return result;
            }
        });

        for(String tmp:arr)
        {
            s += tmp;
        }
        return s;
    }
}
