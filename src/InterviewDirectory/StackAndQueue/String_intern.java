package InterviewDirectory.StackAndQueue;

/**
 * Created by huali on 2018/3/12.
 */
public class String_intern {
    public void intern1()
    {
    //    //String str1 = new String("SEU")+ new String("Calvin");
    //    //System.out.println(str1.intern() == str1);
    //    //System.out.println(str1 == "SEUCalvin");
    //
    //
    //    //String str2 = "SEUCalvin";//新加的一行代码，其余不变
    //    //String str3 = new String("SEU")+ new String("Calvin");
    //    //System.out.println(str3.intern() == str2); //ntern()方法设计的初衷，就是重用String对象，以节省内存消耗
    //    //System.out.println(str3 == "SEUCalvin");
    //
    //
    //    String s = new String("1");
    //    s.intern();
    //    String s2 = "1";
    //    System.out.println(s == s2);
    //    //String s = newString("1")，生成了常量池中的“1” 和堆空间中的字符串对象。
    //    //
    //    //s.intern()，这一行的作用是s对象去常量池中寻找后发现"1"已经存在于常量池中了。
    //    //
    //    //String s2 = "1"，这行代码是生成一个s2的引用指向常量池中的“1”对象。
    //    //
    //    //结果就是 s 和 s2 的引用地址明显不同。因此返回了false。
    //    String s3 = new String("1") + new String("1");
    //    s3.intern();
    //    String s4 = "11";
    //    System.out.println(s3 == s4);
    //    //System.out.println(s3.intern()==s3);
    //    //String s3 = new String("1") + newString("1")，这行代码在字符串常量池中生成“1” ，并在堆空间中生成s3引用指向的对象（内容为"11"）。注意此时常量池中是没有 “11”对象的。
    //    //
    //    //s3.intern()，这一行代码，是将 s3中的“11”字符串放入 String 常量池中，此时常量池中不存在“11”字符串，JDK1.6的做法是直接在常量池中生成一个 "11" 的对象。
    //    //
    //    //但是在JDK1.7中，常量池中不需要再存储一份对象了，可以直接存储堆中的引用。这份引用直接指向 s3 引用的对象，也就是说s3.intern() ==s3会返回true。
    //    //
    //    //String s4 = "11"， 这一行代码会直接去常量池中创建，但是发现已经有这个对象了，此时也就是指向 s3 引用对象的一个引用。因此s3 == s4返回了true。

    //
    //    String ss = new String("1");
    //    String ss2 = "1";
    //    ss.intern();
    //    System.out.println(ss == ss2);
    //
    //    //String s = newString("1")，生成了常量池中的“1” 和堆空间中的字符串对象。
    //    //
    //    //String s2 = "1"，这行代码是生成一个s2的引用指向常量池中的“1”对象，但是发现已经存在了，那么就直接指向了它。
    //    //
    //    //s.intern()，这一行在这里就没什么实际作用了。因为"1"已经存在了。
    //    //
    //    //结果就是 s 和 s2 的引用地址明显不同。因此返回了false。
    //    String ss3 = new String("1") + new String("1");
    //    String ss4 = "11";
    //    ss3.intern();
    //    System.out.println(ss3 == ss4);
    ////    String s3 = new String("1") + newString("1")，这行代码在字符串常量池中生成“1” ，并在堆空间中生成s3引用指向的对象（内容为"11"）。注意此时常量池中是没有 “11”对象的。
    //    //
    //    //String s4 = "11"， 这一行代码会直接去生成常量池中的"11"。
    //    //
    //    //s3.intern()，这一行在这里就没什么实际作用了。因为"11"已经存在了。
    //    //
    //    //结果就是 s3 和 s4 的引用地址明显不同。因此返回了false。
    //    //所以s.intern(),在前面和在后面是很重要的，在前面是指向 s3 引用对象的一个引用。
    //    // 在后面的话，在常量池中已经存在，就没有意义了。
    //
    //
    //    String str1 = new StringBuilder("计算机").append("软件").toString();
    //    System.out.println(str1.intern()==str1); //true
    //
    //    String str2 = new StringBuilder("ja").append("va").toString();
    //    System.out.println(str2.intern()==str2);  //false

        String s5 = new String("1")+new String("1");
        s5.intern();
        String s6 = "11";
        System.out.println(s5==s6);
        //java启动时默认会放入一些字符，如果这些字符存在，则返回false，否则返回true，好像有点不是很对。因为前面已经在常量池中添加了“11”这个字符。



        //第一个问题，为什么“String s = new String("1")”在堆空间和常量池中同时生成对象？
        // 答:这个问题，String类型的常量池比较特殊。
        // 它的主要使用方法有两种：直接使用双引号声明出来的String对象会直接存储在常量池中。
        // 如果不是用双引号声明的String对象，可以使用String提供的intern方法。
        // intern 方法会从字符串常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中。
        // 所以，因为有引号，所以会直接存储字符串对象到常量池中。
        //
        //问题2.1“new String("1")”为什么只在常量池中生成“1”，而堆空间没有？
        // 按“原文1”中论述，只能理解为这个“new String("1")”没有直接引用？



        //问题2.2 String s3 = new String("1") + newString("1")；
        // 为什么只在堆空间生成“11”而没有在常量池中生成“11”？
        // 按“原文1”论述，只能理解为字符串连接操作生成对象和new一个对象的差异？？？
        //答:因为被引号引起来的只有"1"，所以只会生成"1"，常量池中存在的是直接用引号引起来的字符值，
        // 是不会计算"1"+"1"的结果然后存入常量池中的；
        // 但是new String("1")+new String("1")是会在内存中进行计算的。
        // 也就是说，常量池中存在的引号所引起来的常量在编译前就已经确定好的，
        // 但是new String("1")+new String("1")是在运行的时候在堆内存中动态生成的，两个个"1"和一个"11"。



        ////String str1 = new String("SEU") + new String("Calvin");//true
        ////改成
        //String str1 = new String("SEU") ;  //false
        ////后
        //System.out.println(str1.intern() == str1);

        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));//true
        System.out.println(str5 == str3);//false
        System.out.println(str5.intern() == str3);//true
        System.out.println(str5.intern() == str4);//false


        //String a = new String("ab");
        //String b = new String("ab");
        //String c = "ab";
        //String d = "a" + "b";
        //String e = "b";
        //String f = "a" + e;
        //
        //System.out.println(b.intern() == a);//fasle
        //System.out.println(b.intern() == c);//true
        //System.out.println(b.intern() == d);//true  编译期d已确定(修改、赋值)为ab
        //System.out.println(b.intern() == f);//false
        //System.out.println(b.intern() == a.intern());//true


        // 编译期已确定
        String a = "abc";
        String b = "abc";
        String c = "a" + "b" + "c";
        String d = "a" + "bc";
        String e = "ab" + "c";

        System.out.println(a == b);//true
        System.out.println(a == c);//true
        System.out.println(a == d);//true
        System.out.println(a == e);//true
        System.out.println(c == d);//true
        System.out.println(c == e);//true
    }
}