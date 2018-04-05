package InterviewDirectory.tenth_sortalgorithm;

import java.util.Arrays;

/**
 * Created by huali on 2018/4/4.
 */
public class Main {
    public static void main(String []args)
    {
        bubble_sort bubble = new bubble_sort();
        int []arr = {3,5,2,7,6,1,10};
        bubble.bubblesort(arr);
        System.out.println(Arrays.toString(arr));


    }
}