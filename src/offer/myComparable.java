package offer;


import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by huali on 2018/6/29.
 */
public class myComparable {
    public String PrintMinNumber(int [] numbers) {
        String s = new String();
        if(numbers==null||numbers.length<=0)
            return s;
        TreeSet<Mycomparator> arr = new TreeSet<>();
        for(int i=0;i<numbers.length;i++)
        {
            arr.add(new Mycomparator(i+"arr",String.valueOf(numbers[i])));
        }


        Iterator<Mycomparator> iterator = arr.iterator();
        while (iterator.hasNext()) {
            Mycomparator worker = iterator.next();
            System.out.println(worker);
            s += worker.a;
        }
        return s;
    }



    public static void main(String []args)
    {
        int arr[] = {1,2, 1,6,3,4,5,1,1,1};
        System.out.println(new myComparable().PrintMinNumber(arr));
    }
}
class Mycomparator implements Comparable<Mycomparator> {
    public String a;
    String i;
    Mycomparator(String i,String a) {
        this.i = i;
        this.a = a;
    }
    @Override
    public int compareTo(Mycomparator o2)
    {
        String a = this.a+o2.a;
        String b = o2.a+this.a;
        int result = a.compareTo(b);
        if(result==0)
        {
            return this.i.compareTo(o2.i);
        }
        return result;
    }
    @Override
    public String toString() {
        return "Mycomparator [i=" + i + ", a=" + a + "]";
    }

}