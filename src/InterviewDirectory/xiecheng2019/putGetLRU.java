package InterviewDirectory.xiecheng2019;


import java.util.*;
import java.util.Map.Entry;

/**
 * Created by huali on 2018/9/4.
 */
public class putGetLRU<K, V> {
    //题目描述：
    //设计一个数据结构，实现LRU cache的功能，LRU，最近最少使用缓存，支持put和get两种方法：
    //新插入或获取key意味着被使用一次。

    //int initSize;
    //LinkedHashMap<K, V> cache;
    //
    //public Main3(int size) {
    //    this.initSize = size;
    //    this.cache = new LinkedHashMap<K, V>(size, 0.75f, true) {
    //        private static final long serialVersionUID = 1L;
    //
    //        @Override
    //        protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
    //            return size() > Main3.this.initSize;
    //        }
    //    };
    //}
    //
    //public V get(K key) {
    //    return cache.get(key);
    //}
    //
    //public V put(K key, V value) {
    //    return cache.put(key, value);
    //}
    //
    //public int size() {
    //    return cache.size();
    //}
    //



    //测试用例：
    //2
    //p 1 1
    //p 2 2
    //g 1
    //p 2 102
    //p 3 3
    //g 1
    //g 2
    //g 3

    //结果：
    //1
    //1
    //-1
    //3




    public static Deque<Node> deque = new LinkedList<>();
    public static Deque<Node> deque1 = new LinkedList<>();
    static int n;
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //Main3<Integer,Integer> main3 = new Main3<>(n);
        sc.nextLine();
        //while (sc.hasNext())
        //{
        //    String s = sc.nextLine();
        //    String [] stemp = s.split(" ");
        //    if(stemp[0].equals("p"))
        //    {
        //        main3.put(Integer.parseInt(stemp[1]),Integer.parseInt(stemp[2]));
        //    }else if(stemp[0].equals("g"))
        //    {
        //        if(main3.get(Integer.parseInt(stemp[1]))==null)
        //            System.out.println(-1);
        //        else
        //            System.out.println(main3.get(Integer.parseInt(stemp[1])));
        //    }
        //}

        while (sc.hasNext())
        {
            String s = sc.nextLine();
            String [] stemp = s.split(" ");
            if(stemp[0].equals("p"))
            {
                put(Integer.parseInt(stemp[1]),Integer.parseInt(stemp[2]));
            }else if(stemp[0].equals("g"))
            {
                Object o = get(Integer.parseInt(stemp[1]));
                if(o==null)
                    System.out.println(-1);
                else
                    System.out.println(o);
            }
        }

    }

    private static void put(int k, int v) {
        Node no = new Node(k,v);
        if(deque.isEmpty())
        {
            deque.addLast(no);
        }else {
            if(deque.size()>=n)
            {
                while (!deque.isEmpty()&&deque.getFirst().hashCode()!=k)
                {
                    deque1.addLast(deque.getFirst());
                    deque.removeFirst();
                }
                if(!deque.isEmpty()&&deque.getFirst().hashCode()==k)
                {
                    deque.removeFirst();
                    deque.addFirst(no);
                    while (!deque1.isEmpty())
                    {
                        deque.addFirst(deque1.getLast());
                        deque1.removeLast();
                    }

                }else
                {
                    while (!deque1.isEmpty())
                    {
                        deque.addLast(deque1.getFirst());
                        deque1.removeFirst();
                    }
                    deque.removeFirst();
                    deque.addLast(no);
                }
            }else
            {
                deque.addLast(no);
            }
        }
    }

    private static Object get(int i) {

        while (!deque.isEmpty()&&deque.getFirst().hashCode()!=i)
        {
            deque1.addLast(deque.getFirst());
            deque.removeFirst();
        }
        if(!deque.isEmpty())
        {
            int v = deque.getFirst().v;
            deque.removeFirst();
            while (!deque1.isEmpty())
            {
                deque.addFirst(deque1.getLast());
                deque1.removeLast();
            }
            deque.addLast(new Node(i,v));
            return v;
        }else
        {
            while (!deque1.isEmpty())
            {
                deque.addFirst(deque1.getLast());
                deque1.removeLast();
            }
            return null;
        }
    }
}
class Node{
    int k;
    int v;
    Node(int k,int v){
        this.k = k;
        this.v = v;
    }

    @Override
    public int hashCode() {
        return k;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}