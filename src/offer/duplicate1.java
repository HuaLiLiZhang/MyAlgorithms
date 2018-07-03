package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huali on 2018/7/1.
 */
public class duplicate1 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length<=0)
            return false;
        Map<String, Integer> map = new HashMap<>();
        int i=0;
        for(;i<length;i++)
        {
            if(!map.containsKey(String.valueOf(numbers[i])))
                map.put(String.valueOf(numbers[i]),1);
            else
            {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args)
    {
        int []arr = {2,1,3,1,4};
        int [] end = new int[1];
        System.out.println(new duplicate1().duplicate(arr, arr.length, end));
    }


    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers==null||length<=0)
            return false;
        for(int i=0;i<length;++i)
        {
            if(numbers[i]<0||numbers[i]>length-1)
                return false;
        }
        for(int i=0;i<length;++i)
        {
            while (numbers[i]!=i)
            {
                if (numbers[i] == numbers[numbers[i]])
                {
                    duplication[i] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i]=numbers[temp];
                numbers[temp]=temp;
            }

        }
        return false;
    }
}