package InterviewDirectory.StackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by huali on 2018/3/9.
 */
public class Main {
    public static void main(String []args)
    {
        ////1.sort排序String[]数组：升序:从小到大
        //String[] names = { "Liz", "John", "Eric", "Alan" };
        ////只排序前两个
        ////[John, Liz, Eric, Alan]
        //Arrays.sort(names, 0, 2);
        ////全部排序
        ////[Alan, Eric, John, Liz]
        //Arrays.sort(names);
        //String [] name = {"li","ad","sf","qw"};
        //Arrays.sort(name);
        //
        ////2.使用该方法可以返回一个固定大小的List，如：
        //List<String> str= Arrays.asList("welcome","to","fsdg");
        //List<Integer> intList = Arrays.asList(1, 2, 3, 4);
        //int[]a={1,2,3,4};
        //
        ////3.toString()方法：方便我们打印出数组的内容。int[] ,String[],long[],boolean[]...
        //System.out.println(Arrays.toString(name));
        //System.out.println(Arrays.toString(a));
        //
        ////4.deepToString:方法：打印二维数组，任何类型；
        //int[][] twoD={{1,2,3,4},{3,6,7,8}};
        //System.out.println(Arrays.deepToString(twoD));
        //
        ////5.equals：方法：使用Arrays.equals().来比较1维数组是否相等。
        //String[] names1 = { "Eric", "John", "Alan", "Liz" };
        //String[] names2 = { "Eric", "John", "Alan", "Liz" };
        //System.out.println(Arrays.equals(names1,names2));
        //
        ////6.Arrays.deepEquals能够去判断更加复杂的数组是否相等。
        //int[][] stuGrades1 = { { 80, 81, 82 }, { 84, 85, 86 }, { 87, 88, 89 } };
        //int[][] stuGrades2 = { { 80, 81, 82 }, { 84, 85, 86 }, { 87, 88, 89 } };
        //System.out.println(Arrays.deepEquals(stuGrades1, stuGrades2));
        //
        ////7.fill()方法，用某个数组填充数组。
        //int[] array1 = new int[8];
        //Arrays.fill(array1, 1);
        ////[1, 1, 1, 1, 1, 1, 1, 1]
        //System.out.println(Arrays.toString(array1));
        //Arrays.fill(array1, 3);
        //System.out.println(Arrays.toString(array1));


        //Stack1_getMin stack =new Stack1_getMin();
        //stack.push1(1);
        //stack.push1(2);
        //stack.push1(1);
        //stack.push1(5);
        //stack.push1(4);
        //stack.push1(3);
        //int s1= stack.pop1();
        //System.out.println(s1);
        //int s2= stack.pop1();
        //System.out.println(s2);
        //int s3= stack.pop1();
        //System.out.println(s3);
        //int s4= stack.pop1();
        //System.out.println(s4);
        //int s5= stack.pop1();
        //System.out.println(s5);
        //int s6= stack.pop1();
        //System.out.println(s6);

        //TwoStackQueue que= new TwoStackQueue();
        //que.add(1);
        //que.add(3);
        //que.add(5);
        //int num = que.peek();
        //int num1 = que.poll();
        ////System.out.println(num);
        //System.out.println(num1);
        //que.add(6);
        //que.add(91);
        //que.add(100);
        //int legalStr_biaoshifu09 = que.peek();
        //int ShuangShengCiTwoStr_randomCut_reverse = que.poll();
        ////System.out.println(legalStr_biaoshifu09);
        //System.out.println(ShuangShengCiTwoStr_randomCut_reverse);
        //int maxLengthNoDownSequence = que.poll();
        //System.out.println(maxLengthNoDownSequence);
        //int getTheEquationSolution = que.poll();
        //System.out.println(getTheEquationSolution);
        //int num6 = que.poll();
        //System.out.println(num6);
        //int num7 = que.poll();
        //System.out.println(num7);


        //Stack<Integer> s =new Stack<>();
        //s.push(1);
        //s.push(2);
        //s.push(1);
        //s.push(5);
        //s.push(4);
        //s.push(3);
        //ReverseStack stack =new ReverseStack();
        //stack.reverse(s);
        //while (!s.empty())
        //    System.out.println(s.pop());


        //Pet d1 = new Dog();
        //Pet d2 = new Dog();
        //Pet c1 = new Cat();
        //Pet d3 = new Dog();
        //Pet c2 = new Cat();
        //Pet d4 = new Dog();
        //Pet d5 = new Dog();
        //Pet c3 = new Cat();
        //
        //DogCatQueue dogcat = new DogCatQueue();
        //dogcat.add(d1);
        //dogcat.add(d2);
        //dogcat.add(c1);
        //dogcat.add(d3);
        //dogcat.add(c2);
        //dogcat.add(d4);
        //dogcat.add(d5);
        //dogcat.add(c3);
        //dogcat.PollCat();
        //dogcat.PollCat();
        //dogcat.PollCat();
        //boolean r1= dogcat.isCatQueueEmpty();
        //System.out.println(r1);
        //dogcat.PollDog();
        //dogcat.PollDog();
        //dogcat.PollDog();
        //dogcat.PollDog();
        //dogcat.PollDog();
        //boolean r2 = dogcat.isDogQueueEmpty();
        //System.out.println(r2);
        //boolean r3 = dogcat.isEmpty();
        //System.out.println(r3);
        ////dogcat.pollAll();
        ////System.out.println(dogcat.isEmpty());

        //Stack<Integer> s =new Stack<>();
        //s.push(1);
        //s.push(2);
        //s.push(1);
        //s.push(5);
        //s.push(4);
        //s.push(3);
        //sortStackByStack s1= new sortStackByStack();
        //s1.stacksort(s);
        //while (!s.isEmpty())
        //    System.out.println(s.pop());

        //String left="left";
        //String mid="mid";
        //String right = "right";
        //hannoiProblem1_digui hanoi =new hannoiProblem1_digui();
        //int step = hanoi.hanoiproblem(2,left,mid,right);
        //System.out.println(step);
        //
        //hanoiProblem2 hanoi1= new hanoiProblem2();
        //int step1 = hanoi1.hanoiProblem(2,left,mid,right);
        //System.out.println(step1);


        //int [] arr={4,3,5,4,3,3,6,7};
        //MaxInWindows max = new MaxInWindows();
        ////ArrayList<Integer> list = max.maxinwindows(arr,3);
        ////System.out.println(list);
        //int[] res = max.maxwindows(arr,3);
        //System.out.println(Arrays.toString(res));

        //int [] arr = {3,4,5,2,1};
        //int[]arr={4,5,6};
        //TreeNode head = new getMaxTree().getmaxtree(arr);
        //System.out.println(head.val);

        //int[][] map ={{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        //int maxArea = new maxRecSize().maxrecsize(map);  //6
        //System.out.println(maxArea);

        //String_intern s=new String_intern();
        //s.intern1();

        //node head =new node(1);
        //node n1 =new node(2);
        //node n2 =new node(3);
        //node n3 =new node(4);
        //node n4 =new node(5);
        //head.next=n1;
        //n1.next=n2;
        //n2.next=n3;
        //n3.next=n4;
        //n4.next=null;
        //
        //reverseList list = new reverseList() ;
        //node pre = list.reverselist(head);
        //System.out.println(pre.val);
        //int []arr = {1,7,3,6,9,0,2,5,4};
        //int num = new getNumInarray().getNum(arr,3);
        //System.out.println(num);


        //node head =new node(1);
        //node n1 =new node(2);
        //node n2 =new node(3);
        //node n3 =new node(4);
        //node n4 =new node(5);
        //head.next=n1;
        //n1.next=n2;
        //n2.next=n3;
        //n3.next=n4;
        //n4.next=head;
        //node h = new reversePartList().reversepart(head,2,4);
        //while (h!=null)
        //{
        //    System.out.println(h.val);
        //    h=h.next;
        //}

        //node one =new CircleList().josephusKilll(head,3);
        //System.out.println(one.val);



        node head =new node(7);
        node n1 =new node(9);
        node n2 =new node(1);
        node n3 =new node(8);
        node n4 =new node(5);
        node n5 =new node(2);
        node n6 =new node(5);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;
        //boolean yesno = new isHuiWenlist().isPalindrome3(head);
        //System.out.println(yesno);
        //listPartition1 list = new listPartition1();
        listPartition2 list = new listPartition2();
        //node hh = list.listpartition(head,5);
        node hh = list.listPartition(head,5);
        while (hh!=null)
        {
            System.out.print(hh.val+"->");
            hh=hh.next;
            if(hh==null)
                System.out.println("null");
        }





    }
}