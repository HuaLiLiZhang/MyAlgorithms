package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by huali on 2018/6/24.
 */
public class ArrayPermutation {
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> arr = new ArrayList<>();
        if(str!=null&&str.length()>0)
        {
            Permutationhelper(str.toCharArray(), 0, arr);
            Collections.sort(arr);
        }
        return arr;


    }

    private void Permutationhelper(char[] chars, int i, ArrayList<String> arr) {
        if(i==chars.length-1)
        {
            arr.add(String.valueOf(chars));
        }
        else
        {
            for(int j=i;j<chars.length;j++)
            {
                if(j==i||chars[j]!=chars[i])
                {
                    swap(chars, i,j);
                    Permutationhelper(chars, i+1, arr);
                    swap(chars, i,j);
                }
            }
        }
    }

    private void swap(char[] ch, int j, int i) {
        char temp = ch[j];
        ch[j] = ch[i];
        ch[i]=temp;
    }

    public static void main(String []args)
    {
        System.out.println(new ArrayPermutation().Permutation("abc"));
    }
}